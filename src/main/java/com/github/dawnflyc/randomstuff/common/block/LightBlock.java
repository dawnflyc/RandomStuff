package com.github.dawnflyc.randomstuff.common.block;

import com.github.dawnflyc.randomstuff.RandomStuff;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.conditions.BlockStateProperty;
import net.minecraftforge.common.util.Constants;

import javax.annotation.Nullable;

public class LightBlock extends Block {

    public static final LightBlock INSTANCE=new LightBlock();

    public LightBlock() {
        super(Properties.create(Material.ROCK));
        this.setRegistryName(RandomStuff.MODID,"light_block");
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new LightTileEntity();
    }




    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (!worldIn.isRemote) {
            TileEntity tileEntity = worldIn.getTileEntity(pos);
            if (tileEntity != null && tileEntity instanceof LightTileEntity) {
                LightTileEntity lightTileEntity = (LightTileEntity) tileEntity;
                if (player.isSneaking()) {
                    lightTileEntity.power++;
                } else {
                    player.sendStatusMessage(new StringTextComponent(lightTileEntity.power + ""), true);
                }
            }
        }
        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }

}
