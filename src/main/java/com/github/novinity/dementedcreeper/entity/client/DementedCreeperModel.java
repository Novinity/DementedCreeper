package com.github.novinity.dementedcreeper.entity.client;// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.github.novinity.dementedcreeper.DementedCreeper;
import com.github.novinity.dementedcreeper.entity.animations.ModAnimationDefinitions;
import com.github.novinity.dementedcreeper.entity.custom.DementedCreeperEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class DementedCreeperModel<T extends Entity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	private final ModelPart creeper;
	private final ModelPart head;

	public DementedCreeperModel(ModelPart root) {
		this.creeper = root.getChild("root");
		this.head = creeper
				.getChild("body")
				.getChild("lowerbody")
				.getChild("upperbody")
				.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition lowerbody = body.addOrReplaceChild("lowerbody", CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, -6.0F, -2.0F, 8.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 0.0F));

		PartDefinition upperbody = lowerbody.addOrReplaceChild("upperbody", CubeListBuilder.create().texOffs(16, 22).addBox(-4.0F, -6.0F, -2.0F, 8.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 0.0F));

		PartDefinition head = upperbody.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 0.0F));

		PartDefinition lbleg = body.addOrReplaceChild("lbleg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -6.0F, 2.0F));

		PartDefinition lfleg = body.addOrReplaceChild("lfleg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -4.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 21).addBox(-2.0F, 5.0F, -4.0F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -6.0F, -2.0F));

		PartDefinition rbleg = body.addOrReplaceChild("rbleg", CubeListBuilder.create().texOffs(0, 18).addBox(-2.0F, 2.0F, 0.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(1, 17).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -6.0F, 2.0F));

		PartDefinition rfleg = body.addOrReplaceChild("rfleg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -4.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -6.0F, -2.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

		this.animateWalk(ModAnimationDefinitions.DEMENTED_CREEPER_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
		this.animate(((DementedCreeperEntity)entity).idleAnimationState, ModAnimationDefinitions.DEMENTED_CREEPER_IDLE, ageInTicks, 1f);
	}

	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 100F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		creeper.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return creeper;
	}
}