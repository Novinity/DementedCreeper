package com.github.novinity.dementedcreeper;

import com.github.novinity.dementedcreeper.entity.ModEntities;
import com.github.novinity.dementedcreeper.entity.client.DementedCreeperRenderer;
import com.github.novinity.dementedcreeper.item.ModCreativeTabs;
import com.github.novinity.dementedcreeper.item.ModItems;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(DementedCreeper.MODID)
public class DementedCreeper {
    public static final String MODID = "dementedcreeper";
    private static final Logger LOGGER = LogUtils.getLogger();

    public DementedCreeper() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModEntities.register(modEventBus);
        ModItems.register(modEventBus);
        ModCreativeTabs.register(modEventBus);
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntities.DEMENTED_CREEPER.get(), DementedCreeperRenderer::new);
        }
    }
}
