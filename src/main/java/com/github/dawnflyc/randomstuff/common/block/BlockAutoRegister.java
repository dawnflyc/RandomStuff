package com.github.dawnflyc.randomstuff.common.block;

import com.github.dawnflyc.processtree.ITreeHandler;
import com.github.dawnflyc.processtree.Result;
import com.github.dawnflyc.processtree.TreeScan;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
@TreeScan(method = Block.class)
public class BlockAutoRegister implements ITreeHandler<Block> {

    private static final Set<Block> BLOCKS=new HashSet<>();

    @Override
    public void handle(Result<Block> result) {
        for (Class<?> aClass : result.getClassSet()) {
            for (Field field : aClass.getDeclaredFields()){
                if (Modifier.isPublic(field.getModifiers()) && Modifier.isFinal(field.getModifiers()) && Modifier.isStatic(field.getModifiers()) && field.getType().equals(aClass)){
                    try {
                        BLOCKS.add((Block) field.get(null));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    @SubscribeEvent
    public static void registerBlock(RegistryEvent.Register<Block> event) {
        BLOCKS.forEach(block -> event.getRegistry().register(block));
    }

    @SubscribeEvent
    public static void registerItem(RegistryEvent.Register<Item> event) {
        BLOCKS.forEach(block -> event.getRegistry().register(new BlockItem(block,new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName())));
    }
}
