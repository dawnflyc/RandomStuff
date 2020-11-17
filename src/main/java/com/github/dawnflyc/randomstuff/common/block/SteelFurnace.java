package com.github.dawnflyc.randomstuff.common.block;

import com.github.dawnflyc.randomstuff.RandomStuff;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MinecartItem;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.LootParameter;
import net.minecraft.world.storage.loot.LootParameters;

import javax.annotation.Nullable;
import java.util.List;

public class SteelFurnace extends Machine implements IBlockRegistered {

    public static SteelFurnace steelFurnace;

    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    public SteelFurnace(Properties properties) {
        super(properties);
    }

    public SteelFurnace() {
        super();
        steelFurnace=this;
        this.setRegistryName(RandomStuff.MODID,"steel_furnace");

        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
    }

/*    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (!worldIn.isRemote){
            LootContext.Builder builder=new LootContext.Builder((ServerWorld) worldIn);
            builder.withLuck(player.getLuck());
            builder.withRandom(worldIn.rand);
            builder.withNullableParameter(LootParameters.TOOL,player.getHeldItem(handIn));
            builder.withNullableParameter(LootParameters.POSITION,pos);
            builder.withNullableParameter(LootParameters.BLOCK_STATE,state);
            List<ItemStack> itemStackList= state.getDrops(builder);
            for (ItemStack itemStack : itemStackList) {
                player.sendMessage(itemStack.getTextComponent());
            }
        }
        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }*/
}
