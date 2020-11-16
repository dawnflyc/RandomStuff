package com.github.dawnflyc.randomstuff.common.block;

import com.github.dawnflyc.processtree.ITreeHandler;
import com.github.dawnflyc.processtree.Result;
import com.github.dawnflyc.processtree.TreeScan;
import com.github.dawnflyc.randomstuff.common.util.RSGroup;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashSet;
import java.util.Set;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
@TreeScan(method = Block.class)
public class BlockRegistry implements ITreeHandler<Block> {

    @Override
    public void handle(Result<Block> result) {
        REG_BLOCKS.addAll(result.build());
        System.out.println("自动注册");
    }

    private static final Set<Block> REG_BLOCKS=new HashSet<>();

    @SubscribeEvent
    public static void registerBlock(RegistryEvent.Register<Block> event) {
        REG_BLOCKS.forEach(block -> event.getRegistry().register(block));
    }

    @SubscribeEvent
    public static void registerItem(RegistryEvent.Register<Item> event) {
        REG_BLOCKS.forEach(block -> event.getRegistry().register(new BlockItem(block, new Item.Properties().group(RSGroup.INSTANCE)).setRegistryName(block.getRegistryName())));
    }
}
