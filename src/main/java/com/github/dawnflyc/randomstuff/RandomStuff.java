package com.github.dawnflyc.randomstuff;

import com.github.dawnflyc.processtree.Tree;
import com.github.dawnflyc.randomstuff.common.block.TileEntityTypeRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("randomstuff")
public class RandomStuff {

    public static final String MODID = "randomstuff";
    public static final String NAME = "Random Stuff";

    public RandomStuff() {
        Tree tree=new Tree(this.getClass().getPackage().getName());
        tree.run();
        TileEntityTypeRegistry.TILE_ENTITY_TYPE_DEFERRED_REGISTER.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
