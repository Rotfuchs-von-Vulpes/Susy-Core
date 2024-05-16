package supersymmetry.entity.passive;

import com.google.common.base.Predicate;
import gregtechfoodoption.item.GTFOMetaItem;
import net.minecraft.block.Block;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.AbstractSkeleton;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Biomes;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;
import supersymmetry.entity.ai.EntityAIBegFox;

import java.util.UUID;

import static supersymmetry.api.sound.SusySounds.*;

public class EntityFox extends EntityTameable {
    public static final Biome[] POSSIBLE_BIOME_SPAWNS = {Biomes.SWAMPLAND, Biomes.BEACH, Biomes.COLD_BEACH, Biomes.FOREST, Biomes.PLAINS, Biomes.ROOFED_FOREST, Biomes.EXTREME_HILLS};
    private static final DataParameter<Float> DATA_HEALTH_ID = EntityDataManager.createKey(EntityFox.class, DataSerializers.FLOAT);
    private static final DataParameter<Boolean> BEGGING = EntityDataManager.createKey(EntityFox.class, DataSerializers.BOOLEAN);
    /** Float used to smooth the rotation of the fox head */
    private float headRotationCourse;
    private float headRotationCourseOld;
    /** true is the fox is wet else false */
    private boolean isWet;
    /** True if the fox is shaking else False */
    private boolean isShaking;
    /** This time increases while fox is shaking and emitting water particles. */
    private float timeFoxIsShaking;
    private float prevTimeFoxIsShaking;
    public EntityFox(World worldIn) {
        super(worldIn);
        this.setSize(0.6F, 0.85F);
        this.setTamed(false);
    }



    protected void initEntityAI()
    {
        this.aiSit = new EntityAISit(this);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(3, new EntityFox.AIAvoidEntity<>(this, EntityLlama.class, 24.0F, 1.5D, 1.5D));
        this.tasks.addTask(4, new EntityAILeapAtTarget(this, 0.4F));
        this.tasks.addTask(5, new EntityAIAttackMelee(this, 1.0D, true));
        this.tasks.addTask(6, new EntityAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
        this.tasks.addTask(7, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(8, new EntityAIWanderAvoidWater(this, 1.0D));
        this.tasks.addTask(9, new EntityAIBegFox(this, 8.0F));
        this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(10, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(4, new EntityAITargetNonTamed<>(this, EntityAnimal.class, false, (Predicate<Entity>) mob -> mob instanceof EntityChicken || mob instanceof EntityRabbit));
        this.targetTasks.addTask(5, new EntityAINearestAttackableTarget<>(this, AbstractSkeleton.class, false));
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);

        if (this.isTamed())
        {
            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
        }
        else
        {
            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8.0D);
        }

        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
    }

    /**
     * Sets the active target the Task system uses for tracking
     */
    public void setAttackTarget(@javax.annotation.Nullable EntityLivingBase entitylivingbaseIn)
    {
        super.setAttackTarget(entitylivingbaseIn);

        if (entitylivingbaseIn == null)
        {
            this.setAngry(false);
        }
        else if (!this.isTamed())
        {
            this.setAngry(true);
        }
    }

    protected void updateAITasks()
    {
        this.dataManager.set(DATA_HEALTH_ID, this.getHealth());
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataManager.register(DATA_HEALTH_ID, this.getHealth());
        this.dataManager.register(BEGGING, Boolean.FALSE);
    }

    protected void playStepSound(@NotNull BlockPos pos, @NotNull Block blockIn)
    {
        this.playSound(SoundEvents.ENTITY_WOLF_STEP, 0.15F, 1.0F);
    }

//    public static void registerFixesFox(DataFixer fixer)
//    {
//        EntityLiving.registerFixesMob(fixer, EntityFox.class);
//    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(@NotNull NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);
        compound.setBoolean("Angry", this.isAngry());
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(@NotNull NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);
        this.setAngry(compound.getBoolean("Angry"));
    }

    protected SoundEvent getAmbientSound()
    {
        if (this.isAngry())
        {
            return FOX_AGGRO;
        }
        else if (this.rand.nextInt(3) == 0)
        {
            return this.isTamed() && this.dataManager.get(DATA_HEALTH_ID) < 10.0F ? FOX_SCREECH : FOX_SNIFF;
        }
        else
        {
            return FOX_IDLE;
        }
    }

    protected SoundEvent getHurtSound(@NotNull DamageSource damageSourceIn)
    {
        return FOX_HURT;
    }

    protected SoundEvent getDeathSound()
    {
        return FOX_DEATH;
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    protected float getSoundVolume()
    {
        return 0.4F;
    }

    /*@javax.annotation.Nullable
    protected ResourceLocation getLootTable()
    {
        return LootTableList.ENTITIES_WOLF;
    }*/

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate()
    {
        super.onLivingUpdate();

        if (!this.world.isRemote && this.isWet && !this.isShaking && !this.hasPath() && this.onGround)
        {
            this.isShaking = true;
            this.timeFoxIsShaking = 0.0F;
            this.prevTimeFoxIsShaking = 0.0F;
            this.world.setEntityState(this, (byte)8);
        }

        if (!this.world.isRemote && this.getAttackTarget() == null && this.isAngry())
        {
            this.setAngry(false);
        }
    }/**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        super.onUpdate();
        this.headRotationCourseOld = this.headRotationCourse;

        if (this.isBegging())
        {
            this.headRotationCourse += (1.0F - this.headRotationCourse) * 0.4F;
        }
        else
        {
            this.headRotationCourse += (0.0F - this.headRotationCourse) * 0.4F;
        }

        if (this.isWet())
        {
            this.isWet = true;
            this.isShaking = false;
            this.timeFoxIsShaking = 0.0F;
            this.prevTimeFoxIsShaking = 0.0F;
        }
        else if ((this.isWet || this.isShaking) && this.isShaking)
        {
            if (this.timeFoxIsShaking == 0.0F)
            {
                this.playSound(SoundEvents.ENTITY_WOLF_SHAKE, this.getSoundVolume(), (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
            }

            this.prevTimeFoxIsShaking = this.timeFoxIsShaking;
            this.timeFoxIsShaking += 0.05F;

            if (this.prevTimeFoxIsShaking >= 2.0F)
            {
                this.isWet = false;
                this.isShaking = false;
                this.prevTimeFoxIsShaking = 0.0F;
                this.timeFoxIsShaking = 0.0F;
            }

            if (this.timeFoxIsShaking > 0.4F)
            {
                float f = (float)this.getEntityBoundingBox().minY;
                int i = (int)(MathHelper.sin((this.timeFoxIsShaking - 0.4F) * (float)Math.PI) * 7.0F);

                for (int j = 0; j < i; ++j)
                {
                    float f1 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.width * 0.5F;
                    float f2 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.width * 0.5F;
                    this.world.spawnParticle(EnumParticleTypes.WATER_SPLASH, this.posX + (double)f1, (f + 0.8F), this.posZ + (double)f2, this.motionX, this.motionY, this.motionZ);
                }
            }
        }
    }

    /**
     * True if the wolf is wet
     */
    @SideOnly(Side.CLIENT)
    public boolean isFoxWet()
    {
        return this.isWet;
    }

    /**
     * Used when calculating the amount of shading to apply while the wolf is wet.
     */
    @SideOnly(Side.CLIENT)
    public float getShadingWhileWet(float v)
    {
        return 0.75F + (this.prevTimeFoxIsShaking + (this.timeFoxIsShaking - this.prevTimeFoxIsShaking) * v) / 2.0F * 0.25F;
    }

    @SideOnly(Side.CLIENT)
    public float getShakeAngle(float a, float b)
    {
        float f = (this.prevTimeFoxIsShaking + (this.timeFoxIsShaking - this.prevTimeFoxIsShaking) * a + b) / 1.8F;

        if (f < 0.0F)
        {
            f = 0.0F;
        }
        else if (f > 1.0F)
        {
            f = 1.0F;
        }

        return MathHelper.sin(f * (float)Math.PI) * MathHelper.sin(f * (float)Math.PI * 11.0F) * 0.15F * (float)Math.PI;
    }

    @SideOnly(Side.CLIENT)
    public float getInterestedAngle(float p_70917_1_)
    {
        return (this.headRotationCourseOld + (this.headRotationCourse - this.headRotationCourseOld) * p_70917_1_) * 0.15F * (float)Math.PI;
    }

    public float getEyeHeight()
    {
        return this.height * 0.8F;
    }

    /**
     * The speed it takes to move the entityliving's rotationPitch through the faceEntity method. This is only currently
     * use in wolves.
     */
    public int getVerticalFaceSpeed()
    {
        return this.isSitting() ? 20 : super.getVerticalFaceSpeed();
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(@NotNull DamageSource source, float amount)
    {
        if (this.isEntityInvulnerable(source))
        {
            return false;
        }
        else
        {
            Entity entity = source.getTrueSource();

            if (this.aiSit != null)
            {
                this.aiSit.setSitting(false);
            }

            if (entity != null && !(entity instanceof EntityPlayer) && !(entity instanceof EntityArrow))
            {
                amount = (amount + 1.0F) / 2.0F;
            }

            return super.attackEntityFrom(source, amount);
        }
    }

    public boolean attackEntityAsMob(Entity entityIn)
    {
        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float)((int)this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue()));

        if (flag)
        {
            this.applyEnchantments(this, entityIn);
        }

        this.playSound(FOX_BITE, this.getSoundVolume(), this.getSoundPitch());

        return flag;
    }

    public void setTamed(boolean tamed)
    {
        super.setTamed(tamed);

        if (tamed)
        {
            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
        }
        else
        {
            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8.0D);
        }

        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0D);
    }

    public boolean processInteract(EntityPlayer player, @NotNull EnumHand hand)
    {
        ItemStack itemstack = player.getHeldItem(hand);

        if (this.isTamed())
        {
            if (!itemstack.isEmpty())
            {
                if (itemstack.getItem() instanceof ItemFood itemfood)
                {

                    if (this.dataManager.get(DATA_HEALTH_ID) < 20.0F) // fox favourite food pls
                    {
                        if (!player.capabilities.isCreativeMode)
                        {
                            itemstack.shrink(1);
                        }

                        this.heal((float)itemfood.getHealAmount(itemstack));
                        return true;
                    }
                }
            }

            if (this.isOwner(player) && !this.world.isRemote && !this.isBreedingItem(itemstack))
            {
                this.aiSit.setSitting(!this.isSitting());
                this.isJumping = false;
                this.navigator.clearPath();
                this.setAttackTarget(null);
            }
        }
        else if ((itemstack.getItem() == GTFOMetaItem.BLUEBERRY.getMetaItem() ||
                itemstack.getItem() == GTFOMetaItem.RASPBERRY.getMetaItem() ||
                itemstack.getItem() == GTFOMetaItem.STRAWBERRY.getMetaItem() ||
                itemstack.getItem() == GTFOMetaItem.CRANBERRY.getMetaItem()
        ) && !this.isAngry())
        {
            if (!player.capabilities.isCreativeMode)
            {
                itemstack.shrink(1);
            }

            if (!this.world.isRemote)
            {
                if (this.rand.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player))
                {
                    this.setTamedBy(player);
                    this.navigator.clearPath();
                    this.setAttackTarget(null);
                    this.aiSit.setSitting(true);
                    this.setHealth(20.0F);
                    this.playTameEffect(true);
                    this.world.setEntityState(this, (byte)7);
                }
                else
                {
                    this.playTameEffect(false);
                    this.world.setEntityState(this, (byte)6);
                }
            }

            return true;
        }

        return super.processInteract(player, hand);
    }

    /**
     * Handler for {@link World#setEntityState}
     */
    @SideOnly(Side.CLIENT)
    public void handleStatusUpdate(byte id) {
        if (id == 8)
        {
            this.isShaking = true;
            this.timeFoxIsShaking = 0.0F;
            this.prevTimeFoxIsShaking = 0.0F;
        }
        else
        {
            super.handleStatusUpdate(id);
        }
    }

    @SideOnly(Side.CLIENT)
    public float getTailRotation() {
        if (this.isAngry())
        {
            return (float)Math.PI / 8;
        }
        else
        {
            return this.isTamed() ? (-(this.getMaxHealth() - this.dataManager.get(DATA_HEALTH_ID)) * 0.01F) * (float)Math.PI : 0.0F;
        }
    }

    /**
     * Checks if the parameter is an item which this animal can be fed to breed it (wheat, carrots or seeds depending on
     * the animal type)
     */
    public boolean isBreedingItem(ItemStack stack) {
        return stack.getItem() instanceof ItemFood && ((ItemFood)stack.getItem()).isWolfsFavoriteMeat();
    }

    /**
     * Will return how many at most can spawn in a chunk at once.
     */
    public int getMaxSpawnedInChunk()
    {
        return 8;
    }

    /**
     * Determines whether this wolf is angry or not.
     */
    public boolean isAngry()
    {
        return (this.dataManager.get(TAMED) & 2) != 0;
    }

    /**
     * Sets whether this wolf is angry or not.
     */
    public void setAngry(boolean angry) {
        byte b0 = this.dataManager.get(TAMED);

        if (angry)
        {
            this.dataManager.set(TAMED, (byte) (b0 | 2));
        }
        else
        {
            this.dataManager.set(TAMED, (byte) (b0 & -3));
        }
    }

    public EntityFox createChild(@NotNull EntityAgeable ageable) {
        EntityFox entityfox = new EntityFox(this.world);
        UUID uuid = this.getOwnerId();

        if (uuid != null)
        {
            entityfox.setOwnerId(uuid);
            entityfox.setTamed(true);
        }

        return entityfox;
    }

    public void setBegging(boolean beg)
    {
        this.dataManager.set(BEGGING, beg);
    }

    /**
     * Returns true if the mob is currently able to mate with the specified mob.
     */
    public boolean canMateWith(@NotNull EntityAnimal otherAnimal) {
        if (otherAnimal == this)
        {
            return false;
        }
        else if (!this.isTamed())
        {
            return false;
        }
        else if (!(otherAnimal instanceof EntityFox entityfox))
        {
            return false;
        }
        else
        {

            if (!entityfox.isTamed())
            {
                return false;
            }
            else if (entityfox.isSitting())
            {
                return false;
            }
            else
            {
                return this.isInLove() && entityfox.isInLove();
            }
        }
    }

    public boolean isBegging()
    {
        return this.dataManager.get(BEGGING);
    }

    public boolean shouldAttackEntity(@NotNull EntityLivingBase target, @NotNull EntityLivingBase owner) {
        if (!(target instanceof EntityCreeper) && !(target instanceof EntityGhast))
        {
            if (target instanceof EntityFox entityfox)
            {

                if (entityfox.isTamed() && entityfox.getOwner() == owner)
                {
                    return false;
                }
            }

            if (target instanceof EntityPlayer || target instanceof EntityFox)
            {
                return false;
            }
            else
            {
                return !(target instanceof AbstractHorse) || !((AbstractHorse)target).isTame();
            }
        }
        else
        {
            return false;
        }
    }

    public boolean canBeLeashedTo(@NotNull EntityPlayer player) {
        return !this.isAngry() && super.canBeLeashedTo(player);
    }

    class AIAvoidEntity<T extends Entity> extends EntityAIAvoidEntity<T> {
        private final EntityFox fox;

        public AIAvoidEntity(EntityFox foxIn, Class<T> classToAvoidIn, float avoidDistanceIn, double farSpeedIn, double p_i47251_7_)
        {
            super(foxIn, classToAvoidIn, avoidDistanceIn, farSpeedIn, p_i47251_7_);
            this.fox = foxIn;
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean shouldExecute()
        {
            if (super.shouldExecute() && this.closestLivingEntity instanceof EntityLlama)
            {
                return !this.fox.isTamed() && this.avoidLlama((EntityLlama)this.closestLivingEntity);
            }
            else
            {
                return false;
            }
        }

        private boolean avoidLlama(EntityLlama p_190854_1_)
        {
            return p_190854_1_.getStrength() >= EntityFox.this.rand.nextInt(5);
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting()
        {
            EntityFox.this.setAttackTarget(null);
            super.startExecuting();
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void updateTask()
        {
            EntityFox.this.setAttackTarget((EntityLivingBase)null);
            super.updateTask();
        }
    }
}
