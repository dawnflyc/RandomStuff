package com.github.dawnflyc.randomstuff;

import com.github.dawnflyc.processtree.Tree;
import net.minecraftforge.fml.common.Mod;

@Mod("randomstuff")
public class RandomStuff {

    public static final String MODID = "randomstuff";
    public static final String NAME = "Random Stuff";

    public RandomStuff() {
        Tree tree = new Tree(this.getClass().getPackage().getName());
        tree.run();
    }
}
