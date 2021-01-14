package com.github.dawnflyc.randomstuff.common.block;

import com.github.dawnflyc.randomstuff.RandomStuff;
import com.github.dawnflyc.randomstuff.common.block.tileentity.SteelFurnaceTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.LootParameters;

import javax.annotation.Nullable;
import java.util.List;

public class SteelFurnace extends Machine implements IBlockRegistered {

    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    public static SteelFurnace steelFurnace;

    public SteelFurnace(Block.Properties properties) {
        super(properties);
    }

    public SteelFurnace() {
        super();
        steelFurnace = this;
        super.setRegistryName(RandomStuff.MODID, "steel_furnace");

        super.setDefaultState(super.stateContainer.getBaseState().with(FACING, Direction.NORTH));
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new SteelFurnaceTileEntity();
    }

        @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (!worldIn.isRemote && handIn==Hand.MAIN_HAND){
            LootContext.Builder builder=new LootContext.Builder((ServerWorld) worldIn);
            builder.withLuck(player.getLuck());
            builder.withRandom(worldIn.rand);
            BlockPos posi=new BlockPos(pos.getX(),pos.getY()-1,pos.getZ());
            BlockState blockState=worldIn.getBlockState(posi);
            builder.withNullableParameter(LootParameters.TOOL,player.getHeldItem(handIn));
            builder.withNullableParameter(LootParameters.POSITION,posi);
            builder.withNullableParameter(LootParameters.BLOCK_STATE,blockState);
            List<ItemStack> itemStackList= blockState.getDrops(builder);
            for (ItemStack itemStack : itemStackList) {
                player.addItemStackToInventory(itemStack);
            }
        }
        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }
}
