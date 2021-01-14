package com.github.dawnflyc.randomstuff;

import com.github.dawnflyc.processtree.ProcessTree;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

@Mod(RandomStuff.MODID)
public class RandomStuff {

    public static final String MODID = "randomstuff";

    public static final String NAME = "Random Stuff";

    public RandomStuff() {
        ProcessTree tree = new ProcessTree(this.getClass().getPackage().getName());
        tree.start();

    }
}
