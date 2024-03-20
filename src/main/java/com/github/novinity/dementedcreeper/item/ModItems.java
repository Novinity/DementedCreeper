package com.github.novinity.dementedcreeper.item;

import com.github.novinity.dementedcreeper.DementedCreeper;
import com.github.novinity.dementedcreeper.entity.ModEntities;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DementedCreeper.MODID);

    public static final RegistryObject<Item> DEMENTED_CREEPER_SPAWN_EGG = ITEMS.register("demented_creeper_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.DEMENTED_CREEPER, 0x91FF33, 0x5B3D3D,
                    new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
