package com.github.dawnflyc.randomstuff.common.item;

import com.github.dawnflyc.processtree.IScanResultHandler;
import com.github.dawnflyc.processtree.Result;
import com.github.dawnflyc.processtree.ScanNode;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashSet;
import java.util.Set;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
@ScanNode(target = Item.class)
public class ItemRegistry implements IScanResultHandler<Item> {

    private static final Set<Item> REG_ITEMS = new HashSet<>();

    @SubscribeEvent
    public static void registerItem(RegistryEvent.Register<Item> event) {
        REG_ITEMS.forEach(item -> event.getRegistry().register(item));
    }

    @Override
    public void handle(Result<Item> result) {
        result.build().forEach(item -> REG_ITEMS.add(item));
    }
}
