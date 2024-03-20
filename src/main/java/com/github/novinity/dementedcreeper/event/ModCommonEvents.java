package com.github.novinity.dementedcreeper.event;

import com.github.novinity.dementedcreeper.DementedCreeper;
import com.github.novinity.dementedcreeper.entity.ModEntities;
import com.github.novinity.dementedcreeper.entity.custom.DementedCreeperEntity;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = DementedCreeper.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCommonEvents {
    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            SpawnPlacements.register(ModEntities.DEMENTED_CREEPER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE,
                    DementedCreeperEntity::canSpawn);
        });
    }
}
