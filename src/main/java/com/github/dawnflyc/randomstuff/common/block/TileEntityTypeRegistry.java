package com.github.dawnflyc.randomstuff.common.block;

import com.github.dawnflyc.randomstuff.RandomStuff;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityTypeRegistry {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPE_DEFERRED_REGISTER = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, RandomStuff.MODID);

    public static RegistryObject<TileEntityType<LightTileEntity>> lightTileEntity = TILE_ENTITY_TYPE_DEFERRED_REGISTER.register("light_tileentity", () -> {
        return TileEntityType.Builder.create(() -> {
            return new LightTileEntity();
        }, LightBlock.INSTANCE).build(null);
    });
}
