package supersymmetry.common;

import com.alcatrazescapee.notreepunching.common.items.ItemCeramicBucket;
import com.alcatrazescapee.notreepunching.common.items.ModItems;
import gregtech.common.items.MetaItems;
import gregtechfoodoption.item.GTFOMetaItem;
import net.minecraft.block.BlockCauldron;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.StatList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.IFluidHandlerItem;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import supersymmetry.Supersymmetry;
import gregtech.api.unification.material.Materials;

import static gregtech.common.items.MetaItems.SHAPE_MOLD_BALL;
import static gregtech.common.items.MetaItems.STICKY_RESIN;

@Mod.EventBusSubscriber(modid = Supersymmetry.MODID)
public class EventHandlers {

    private static final String FIRST_SPAWN = Supersymmetry.MODID + ".first_spawn";
    private static boolean cancelFillBucket = false;

    @SubscribeEvent
    public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {

        NBTTagCompound playerData = event.player.getEntityData();
        NBTTagCompound data = playerData.hasKey(EntityPlayer.PERSISTED_NBT_TAG) ? playerData.getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG) : new NBTTagCompound();

        if(!event.player.getEntityWorld().isRemote && !data.getBoolean(FIRST_SPAWN)) {
            data.setBoolean(FIRST_SPAWN, true);
            playerData.setTag(EntityPlayer.PERSISTED_NBT_TAG, data);

            event.player.addItemStackToInventory(GTFOMetaItem.EMERGENCY_RATIONS.getStackForm(10));
            event.player.addItemStackToInventory(MetaItems.PROSPECTOR_LV.getChargedStack(100000));
        }
    }

    @SubscribeEvent
    @SuppressWarnings("all")
    public static void onPlayerLeftClick(PlayerInteractEvent.RightClickBlock event) {
        ItemStack itemStack = event.getItemStack();
        World world = event.getWorld();
        BlockPos pos = event.getPos();
        IBlockState blockState = world.getBlockState(pos);

        if (itemStack.getItem() == ModItems.CERAMIC_BUCKET && !world.isRemote && blockState.getBlock() instanceof BlockCauldron) {
            event.setCanceled(true);
            BlockCauldron cauldron = (BlockCauldron) blockState.getBlock();
            ItemCeramicBucket bucket = (ItemCeramicBucket) itemStack.getItem();
            FluidStack fluid = bucket.getFluid(itemStack);
            int level = blockState.getValue(BlockCauldron.LEVEL);
            if (fluid == null && level >= 3) {
                if (!event.getEntityPlayer().capabilities.isCreativeMode) {
                    IFluidHandlerItem fluidHandler = FluidUtil.getFluidHandler(itemStack);
                    fluidHandler.fill(new FluidStack(FluidRegistry.WATER, 1000), true);
                    cancelFillBucket = true;
                }

                cauldron.setWaterLevel(world, pos, blockState, 0);
                event.getEntityPlayer().addStat(StatList.CAULDRON_USED);
                world.playSound(null, pos, SoundEvents.ITEM_BUCKET_FILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
            } else if (fluid != null && fluid.getFluid() == FluidRegistry.WATER && level < 3) {
                if (!event.getEntityPlayer().capabilities.isCreativeMode) {
                    IFluidHandlerItem fluidHandler = FluidUtil.getFluidHandler(itemStack);
                    fluidHandler.drain(1000, true);
                }
                cancelFillBucket = true;

                cauldron.setWaterLevel(world, pos, blockState, 3);
                event.getEntityPlayer().addStat(StatList.CAULDRON_FILLED);
                world.playSound(null, pos, SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
            }
        }
    }

    @SubscribeEvent
    public static void onBucketFill(FillBucketEvent event) {
        RayTraceResult target = event.getTarget();
        if (cancelFillBucket &&
                target != null &&
                event.getWorld().getBlockState(target.getBlockPos()).getBlock() instanceof BlockCauldron) {
            event.setCanceled(true);
            cancelFillBucket = false;
        }
    }

    @SubscribeEvent
    public static void onCrafted(PlayerEvent.ItemCraftedEvent event) {
        if (event.crafting.isItemEqual(FluidUtil.getFilledBucket(Materials.SaltWater.getFluid(1000)))) {
            for (int i = 0; i < event.craftMatrix.getSizeInventory(); i++) {
                if (event.craftMatrix.getStackInSlot(i).isItemEqual(new ItemStack(Items.WATER_BUCKET))) {
                    event.craftMatrix.setInventorySlotContents(i, new ItemStack(Items.AIR));
                    break;
                }
            }
        }

        if (event.crafting.isItemEqual(STICKY_RESIN.getStackForm())) {
            for (int i = 0; i < event.craftMatrix.getSizeInventory(); i++) {
                ItemStack stack = event.craftMatrix.getStackInSlot(i);
                if (stack.isItemEqual(SHAPE_MOLD_BALL.getStackForm())) {
                    event.craftMatrix.setInventorySlotContents(i, SHAPE_MOLD_BALL.getStackForm(stack.getCount() + 1));
                    break;
                }
            }
        }
    }
}
