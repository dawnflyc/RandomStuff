package com.github.dawnflyc.randomstuff.common.block.tileentity;

import com.github.dawnflyc.randomstuff.RandomStuff;
import com.github.dawnflyc.randomstuff.common.block.SteelFurnace;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntityType;

import javax.annotation.Nullable;


public class SteelFurnaceTileEntity extends MachineTileEntity implements ITileEntityRegistered {

    public static final TileEntityType TILE_ENTITY_TYPE = TileEntityType.Builder.create(() -> {
        return new SteelFurnaceTileEntity();
    }, SteelFurnace.steelFurnace).build(null).setRegistryName(RandomStuff.MODID, "steel_furnace_tileentity");


    public SteelFurnaceTileEntity() {
        super(TILE_ENTITY_TYPE);
    }


    @Nullable
    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
        return new SUpdateTileEntityPacket(pos, 1, getUpdateTag());
    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
        handleUpdateTag(pkt.getNbtCompound());
    }

    @Override
    public CompoundNBT getUpdateTag() {
        CompoundNBT compoundNBT = new CompoundNBT();
        return compoundNBT;
    }

    @Override
    public void handleUpdateTag(CompoundNBT tag) {
    }
}
