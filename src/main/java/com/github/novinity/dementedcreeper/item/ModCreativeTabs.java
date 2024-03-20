package com.github.novinity.dementedcreeper.item;

import com.github.novinity.dementedcreeper.DementedCreeper;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DementedCreeper.MODID);

    public static final RegistryObject<CreativeModeTab> ITEM_TAB = TABS.register("dementedcreeper_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.dementedcreeper_tab"))
                    .icon(ModItems.DEMENTED_CREEPER_SPAWN_EGG.get()::getDefaultInstance)
                    .displayItems((displayParams, output) -> {
                        ModItems.ITEMS.getEntries().forEach(item -> {
                            output.accept(item.get());
                        });
                    })
                    .build()
    );

    public static void register(IEventBus eventBus) {
        TABS.register(eventBus);
    }
}
