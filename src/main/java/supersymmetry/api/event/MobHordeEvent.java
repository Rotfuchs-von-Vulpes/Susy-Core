package supersymmetry.api.event;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MobHordeEvent {
    private Function<EntityPlayer, EntityLiving> entitySupplier;
    private int quantityMin;
    private int quantityMax;
    private boolean nightOnly;
    private ResourceLocation advancementUnlock;
    private int timerMin;
    private int timerMax;
    private int dimension = 0;
    private int maximumDistanceUnderground = -1;

    public static final List<MobHordeEvent> EVENTS = new ArrayList<>();

    public MobHordeEvent(Function<EntityPlayer, EntityLiving> entitySupplier, int quantityMin, int quantityMax) {
        this.entitySupplier = entitySupplier;
        this.quantityMin = quantityMin;
        this.quantityMax = quantityMax;
        this.EVENTS.add(this);
    }

    public MobHordeEvent setNightOnly(boolean nightOnly) {
        this.nightOnly = nightOnly;
        return this;
    }

    public MobHordeEvent setAdvancementUnlock(ResourceLocation advancementUnlock) {
        this.advancementUnlock = advancementUnlock;
        return this;
    }

    public boolean canRun(EntityPlayerMP player) {
        if (advancementUnlock != null) {
            Advancement advancement = resourceLocationToAdvancement(advancementUnlock, player.world);
            if (!player.getAdvancements().getProgress(advancement).isDone())
                return false;
        }
        if (player.dimension != this.dimension) {
            return false;
        }
        return !(player.world.isDaytime() && nightOnly) || hasToBeUnderground(player);
    }

    private static Advancement resourceLocationToAdvancement(ResourceLocation location, World world) {
        AdvancementManager advManager = ObfuscationReflectionHelper.getPrivateValue(World.class, world, "field_191951_C");
        return advManager.getAdvancement(location);
    }

    public int getNextDelay() {
        return timerMin + (int) (Math.random() * timerMax);
    }

    public MobHordeEvent setTimer(int min, int max) {
        this.timerMin = min;
        this.timerMax = max;
        return this;
    }

    public MobHordeEvent setDimension(int dimension) {
        this.dimension = dimension;
        return this;
    }

    public MobHordeEvent setMaximumDistanceUnderground(int maximumDistanceUnderground) {
        this.maximumDistanceUnderground = maximumDistanceUnderground;
        return this;
    }

    protected boolean hasToBeUnderground(EntityPlayer player) {
        return (maximumDistanceUnderground != -1 && !player.world.canBlockSeeSky(new BlockPos(player).up(maximumDistanceUnderground)));
    }
}
