package com.github.novinity.dementedcreeper.entity;

import com.github.novinity.dementedcreeper.DementedCreeper;
import com.github.novinity.dementedcreeper.entity.custom.DementedCreeperEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, DementedCreeper.MODID);

    public static final RegistryObject<EntityType<DementedCreeperEntity>> DEMENTED_CREEPER =
            ENTITY_TYPES.register("demented_creeper", () -> EntityType.Builder.of(DementedCreeperEntity::new, MobCategory.MONSTER)
                    .sized(0.6f, 1.7f).build("demented_creeper"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
