package com.github.novinity.dementedcreeper.entity.event;

import com.github.novinity.dementedcreeper.DementedCreeper;
import com.github.novinity.dementedcreeper.entity.ModEntities;
import com.github.novinity.dementedcreeper.entity.custom.DementedCreeperEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DementedCreeper.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.DEMENTED_CREEPER.get(), DementedCreeperEntity.createAttributes().build());
    }
}
