package com.github.dawnflyc.randomstuff.common.item;

import com.github.dawnflyc.randomstuff.RandomStuff;
import com.mojang.authlib.GameProfile;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.FakePlayer;

import java.util.UUID;

public class TestItem extends Item {
    public TestItem() {
        super(new Properties());
        this.setRegistryName(RandomStuff.MODID,"test");
    }


    @Override
    public ActionResultType onItemUse(ItemUseContext event) {
        if (event.getWorld().isRemote){
            event.getWorld().sendBlockBreakProgress(event.getWorld().rand.nextInt(100),event.getPos(),event.getWorld().rand.nextInt(10));
        }
        return ActionResultType.SUCCESS;
    }
}
