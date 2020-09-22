package com.github.dawnflyc.randomstuff.common.block;

import jdk.nashorn.internal.ir.Block;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;

import javax.annotation.Nullable;

public class LightTileEntity extends TileEntity implements ITickableTileEntity {

    public int power;

    public LightTileEntity() {
        super(TileEntityTypeRegistry.lightTileEntity.get());
    }


    @Override
    public void tick() {
        if (!world.isRemote){
            transfer(pos.up());
            transfer(pos.down());
            transfer(pos.east());
            transfer(pos.west());
            transfer(pos.north());
            transfer(pos.south());
        }
    }

    public void transfer(BlockPos pos){
        TileEntity tileEntity= world.getTileEntity(pos);
        if (tileEntity!=null && tileEntity instanceof LightTileEntity){
            LightTileEntity lightTileEntity= (LightTileEntity) tileEntity;
            if (this.power-lightTileEntity.power>0){
                this.power--;
                lightTileEntity.power++;
                markDirty();
                lightTileEntity.markDirty();
            }
        }
    }

    @Override
    public void read(CompoundNBT compound) {
        power=compound.getInt("power");
        super.read(compound);
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        compound.putInt("power",power);
        return super.write(compound);
    }

    @Nullable
    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
        return new SUpdateTileEntityPacket(pos,1,getUpdateTag());
    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
        handleUpdateTag(pkt.getNbtCompound());
    }

    @Override
    public CompoundNBT getUpdateTag() {
        CompoundNBT compoundNBT = super.getUpdateTag();
        compoundNBT.putInt("power",power);
        return compoundNBT;
    }

    @Override
    public void handleUpdateTag(CompoundNBT tag) {
    power=tag.getInt("power");
    }
}
