package supersymmetry.worldGen;

import gregtech.api.GTValues;
import gregtech.api.worldgen.config.WorldGenRegistry;
import net.minecraftforge.fml.common.Loader;
import org.apache.commons.io.FileUtils;
import org.jetbrains.annotations.NotNull;
import supersymmetry.Supersymmetry;
import supersymmetry.api.SusyLog;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class SuSyWorldGen {
    public static final List<String> DIMENSIONS = new ArrayList<String>() {
        {
            add("overworld");
            add("nether");
            add("end");
        }
    };
    public static final SuSyWorldGen INSTANCE = new SuSyWorldGen();
    private static final String VEIN_PATH = "/assets/gregtech/worldgen/vein";
    private static final String FLUID_PATH = "/assets/gregtech/worldgen/fluid";
    public static Path configPath = Loader.instance().getConfigDir().toPath().resolve(GTValues.MODID);
    private static final Path SUSY_CONFIG_PATH = Loader.instance().getConfigDir().toPath().resolve(Supersymmetry.MODID);
    private static final Path worldgenRootPath = configPath.resolve("worldgen");
    private static final Path susyWorldgenRootPath = SUSY_CONFIG_PATH.resolve("worldgen");
    private static final Path oreVeinRootPath = susyWorldgenRootPath.resolve("vein");
    private static final Path bedrockFluidVeinRootPath = susyWorldgenRootPath.resolve("fluid");
    private static Path oreVeinJarRootPath;
    private static Path bedrockFluidJarRootPath;
    private static final Map<Path, List<Path>> oreVeinsToAdd = new HashMap<>();
    private static final Map<Path, List<String>> fluidVeinsToAdd = new HashMap<>();
    private static final Path DUMMY_FILE_PATH = SUSY_CONFIG_PATH.resolve("worldgen").resolve("deleteToReset");
    private SuSyWorldGen() {}

    public boolean doesDummyFileExist() {
        return Files.exists(DUMMY_FILE_PATH);
    }

    public void createDummyFile() throws IOException {
        Files.createDirectories(DUMMY_FILE_PATH.getParent());
        Files.createFile(DUMMY_FILE_PATH);
    }

    public void removeAllVeins(Path worldgenRootPath) {
        DIMENSIONS.forEach(dimension -> {
            try {
                FileUtils.forceDelete(new File(worldgenRootPath.resolve("vein").resolve(dimension).toUri()));
            } catch (IOException e) {
                SusyLog.logger.info("Directory {} already removed", dimension);
            }
        });
    }

    @NotNull
    private static Path getActualVeinName(@NotNull Path path) {
        // String separator = FileSystems.getDefault().getSeparator(); !!!! Works on Linux, on Windows it returns <\>
        // !!!!

        String separator = System.getProperty("os.name").contains("Windows") ? "/" :
                FileSystems.getDefault().getSeparator();
        String[] split = path.toString().split("/");

        StringBuilder stringBuilder = new StringBuilder();

        Arrays.asList(split).forEach(part -> stringBuilder.append(part).append(separator));

        return Paths.get(stringBuilder.toString());
    }

    private static void extractAndCopy(List<Path> paths, String type) throws RuntimeException {
        paths.forEach(jarFile -> {
            oreVeinsToAdd.computeIfAbsent(jarFile.getParent(), k -> new ArrayList<>());

            Path name = oreVeinJarRootPath.getParent().relativize(jarFile);
            name = getActualVeinName(name);
            oreVeinsToAdd.get(jarFile.getParent()).add(name);

            try {
                Files.createDirectories(worldgenRootPath.resolve(name.getParent()));
                Files.copy(jarFile, worldgenRootPath.resolve(name), StandardCopyOption.REPLACE_EXISTING);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    private static List<Path> getJarPathList(Path assetPath) throws IOException {
        return Files.walk(assetPath)
                .filter(Files::isRegularFile)
                .collect(Collectors.toList());
    }

    private static void extractVeinDefinitionsFromJar(Path jarRootPath, Path rootPath, String type) throws IOException {
        SusyLog.logger.info("Attempting retrieval of standard SUSY worldgen definitions from {} to {}",
                jarRootPath, rootPath);

        List<Path> jarFiles = getJarPathList(jarRootPath);
        extractAndCopy(jarFiles, type);

        SusyLog.logger.info("Retrieved {} builtin SUSY worldgen {} definitions", jarFiles.size(), type);
    }

    private static void setPathAndExtractDefinitions() {
        FileSystem zipFileSystem = null;

        try {
            URI sampleUri = SuSyWorldGen.class.getResource("/assets/gregtech/.susyassetsroot").toURI();

            if (sampleUri.getScheme().equals("jar") || sampleUri.getScheme().equals("zip")) {
                zipFileSystem = FileSystems.newFileSystem(sampleUri, Collections.emptyMap());
                oreVeinJarRootPath = zipFileSystem.getPath(VEIN_PATH);
                bedrockFluidJarRootPath = zipFileSystem.getPath(FLUID_PATH);
            } else if (sampleUri.getScheme().equals("file")) {
                oreVeinJarRootPath = Paths.get(SuSyWorldGen.class.getResource(VEIN_PATH).toURI());
                bedrockFluidJarRootPath = Paths.get(SuSyWorldGen.class.getResource(FLUID_PATH).toURI());
            } else {
                throw new IllegalStateException(
                        "Unable to locate absolute path to SUSY worldgen root directory: " + sampleUri);
            }

            extractVeinDefinitionsFromJar(oreVeinJarRootPath, oreVeinRootPath, "vein");
            extractVeinDefinitionsFromJar(bedrockFluidJarRootPath, bedrockFluidVeinRootPath, "fluid");

        } catch (URISyntaxException | IOException impossible) {
            // this is impossible, since getResource always returns valid URI
            throw new RuntimeException(impossible);
        } finally {
            if (zipFileSystem != null) {
                // close zip file system to avoid issues
                IOUtils.closeQuietly(zipFileSystem);
            }
        }
    }

    public void addRemoveVeins() throws IOException {
        SusyLog.logger.info("Vein Size Before Addition: " + WorldGenRegistry.getOreDeposits().size());
        SusyLog.logger.info("Fluid Vein Size Before Addition: " + WorldGenRegistry.getBedrockVeinDeposits().size());

        this.removeAllVeins(worldgenRootPath);

        setPathAndExtractDefinitions();

        try {
            WorldGenRegistry.INSTANCE.reinitializeRegisteredVeins();
        } catch (IOException e) {
            e.printStackTrace();
        }

        SusyLog.logger.info("Vein Size After Addition: " + WorldGenRegistry.getOreDeposits().size());
        SusyLog.logger.info("Fluid Vein Size After Addition: " + WorldGenRegistry.getBedrockVeinDeposits().size());
    }
}
