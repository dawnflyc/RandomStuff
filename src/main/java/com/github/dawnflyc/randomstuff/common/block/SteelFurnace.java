package com.github.dawnflyc.randomstuff.common.block;

import com.github.dawnflyc.randomstuff.RandomStuff;
import com.github.dawnflyc.randomstuff.common.block.tileentity.SteelFurnaceTileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.state.DirectionProperty;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class SteelFurnace extends Machine implements IBlockRegistered {

    public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    public static SteelFurnace steelFurnace;

    public SteelFurnace(Properties properties) {
        super(properties);
    }

    public SteelFurnace() {
        super();
        steelFurnace = this;
        this.setRegistryName(RandomStuff.MODID, "steel_furnace");

        this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
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
