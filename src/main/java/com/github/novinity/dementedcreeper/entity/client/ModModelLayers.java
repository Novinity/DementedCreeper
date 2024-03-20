package com.github.novinity.dementedcreeper.entity.client;

import com.github.novinity.dementedcreeper.DementedCreeper;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {
    public static final ModelLayerLocation DEMENTED_CREEPER_LAYER = new ModelLayerLocation(
            new ResourceLocation(DementedCreeper.MODID, "demented_creeper_layer"),
            "main"
    );
}
