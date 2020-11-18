package com.github.dawnflyc.randomstuff.common.util;

import com.github.dawnflyc.randomstuff.common.block.SteelFurnace;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class RSGroup extends ItemGroup {

    public static final RSGroup INSTANCE = new RSGroup();

    public RSGroup() {
        super("rs_group");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(SteelFurnace.steelFurnace);
    }
}
