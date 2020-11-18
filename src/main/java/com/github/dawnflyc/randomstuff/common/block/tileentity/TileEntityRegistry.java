package com.github.dawnflyc.randomstuff.common.block.tileentity;

import com.github.dawnflyc.processtree.ITreeHandler;
import com.github.dawnflyc.processtree.Result;
import com.github.dawnflyc.processtree.TreeScan;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashSet;
import java.util.Set;

@TreeScan(method = ITileEntityRegistered.class, priority = -1)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TileEntityRegistry implements ITreeHandler<ITileEntityRegistered> {

    private static final Set<TileEntityType> REG_TILE_ENTITY_TYPES = new HashSet<>();

    @SubscribeEvent
    public static void registerTileEntity(RegistryEvent.Register<TileEntityType<?>> event) {
        REG_TILE_ENTITY_TYPES.forEach(tileEntityType -> event.getRegistry().register(tileEntityType));
    }

    @Override
    public void handle(Result<ITileEntityRegistered> result) {
        result.build().forEach(iTileEntityRegistered -> REG_TILE_ENTITY_TYPES.add(iTileEntityRegistered.getType()));
    }
}
