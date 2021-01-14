package com.github.dawnflyc.randomstuff.common.block.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public abstract class MachineTileEntity extends TileEntity {

    public MachineTileEntity(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }
}
