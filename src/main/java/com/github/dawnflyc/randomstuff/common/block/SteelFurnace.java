package com.github.dawnflyc.randomstuff.common.block;

import com.github.dawnflyc.randomstuff.RandomStuff;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class SteelFurnace extends Block {

    public static SteelFurnace steelFurnace;

    public SteelFurnace(Properties properties) {
        super(properties);
        System.out.println("注册熔炉");
    }

    public SteelFurnace() {
        this(Properties.create(Material.ROCK));
        steelFurnace=this;
        this.setRegistryName(RandomStuff.MODID,"steel_furnace");
    }
}
