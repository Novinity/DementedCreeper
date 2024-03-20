package com.github.novinity.dementedcreeper.entity.client;

import com.github.novinity.dementedcreeper.DementedCreeper;
import com.github.novinity.dementedcreeper.entity.custom.DementedCreeperEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class DementedCreeperRenderer extends MobRenderer<DementedCreeperEntity, DementedCreeperModel<DementedCreeperEntity>> {
    public DementedCreeperRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new DementedCreeperModel<>(pContext.bakeLayer(ModModelLayers.DEMENTED_CREEPER_LAYER)), 0.5f);
    }
    @Override
    public ResourceLocation getTextureLocation(DementedCreeperEntity dementedCreeperEntity) {
        return new ResourceLocation(DementedCreeper.MODID, "textures/entity/demented_creeper.png");
    }

    @Override
    public void render(DementedCreeperEntity pEntity, float pEntityYaw, float pPartialTicks,
                       PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {


        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
