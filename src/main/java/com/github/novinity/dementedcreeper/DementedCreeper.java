package com.github.novinity.dementedcreeper;

import com.mojang.logging.LogUtils;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(DementedCreeper.MODID)
public class DementedCreeper {

    public static final String MODID = "dementedcreeper";
    private static final Logger LOGGER = LogUtils.getLogger();

    public DementedCreeper() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    }
}
