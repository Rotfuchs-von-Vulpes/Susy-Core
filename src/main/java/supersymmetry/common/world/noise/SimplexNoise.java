package supersymmetry.common.world.noise;

import java.util.ArrayList;

public class SimplexNoise {
    long seed;
    int octaves;
    double lacunarity;
    double persistence;
    ArrayList<OpenSimplexNoise> noises;

    public SimplexNoise(long seed, int octaves, double lacunarity, double persistence) {
        this.seed = seed;
        this.octaves = octaves;
        this.lacunarity = lacunarity;
        this.persistence = persistence;
        this.noises = new ArrayList<>(octaves);

        for (int i = 0; i < octaves; i++) {
            this.noises.add(new OpenSimplexNoise(seed + i));
        }
    }

    public double getNoised(int x, int z) {
        double noised = 0;
        for (int i = 0; i < this.octaves; i++) {
            double lacunarity = Math.pow(this.lacunarity, i);
            noised += Math.pow(this.persistence, i) * this.noises.get(i).eval(lacunarity * x / 16, 0, lacunarity * z / 16);
        }

        return noised;
    }
}
