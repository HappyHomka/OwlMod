// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package com.homka.owlmod.entity.client;

import com.homka.owlmod.entity.animation.ModAnimations;
import com.homka.owlmod.entity.custom.SichEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class SichModel<T extends SichEntity> extends SinglePartEntityModel<T> {
	private final ModelPart Sich;
	private final ModelPart head;

	public SichModel(ModelPart root) {
		this.Sich = root.getChild("Sich");
		this.head = Sich.getChild("head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData Sich = modelPartData.addChild("Sich", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData head = Sich.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.5F, -7.0F, -7.0F, 7.75F, 7.5F, 7.5F, new Dilation(0.0F))
		.uv(32, 11).cuboid(-1.25F, -2.25F, -7.9F, 1.25F, 2.2F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.3F, -2.8F));

		ModelPartData head_r1 = head.addChild("head_r1", ModelPartBuilder.create().uv(30, 16).cuboid(-4.0F, -14.3F, -9.8F, 6.0F, 0.0F, 8.75F, new Dilation(0.0F)), ModelTransform.of(0.25F, 1.55F, 8.8F, 0.5236F, 0.0F, 0.0F));

		ModelPartData body = Sich.addChild("body", ModelPartBuilder.create().uv(0, 16).cuboid(-4.75F, -1.5F, -5.0F, 8.25F, 7.5F, 6.5F, new Dilation(0.0F)), ModelTransform.of(0.0F, -8.25F, -3.0F, 0.4363F, 0.0F, 0.0F));

		ModelPartData wing0 = body.addChild("wing0", ModelPartBuilder.create(), ModelTransform.of(1.5F, -1.1F, 0.2F, -0.1745F, 3.1416F, 0.0F));

		ModelPartData wing2 = wing0.addChild("wing2", ModelPartBuilder.create().uv(30, 25).cuboid(1.5F, -1.5F, -1.5F, 1.75F, 6.5F, 5.25F, new Dilation(0.0F))
		.uv(32, 0).cuboid(1.5F, -1.0F, 3.75F, 1.75F, 6.0F, 1.25F, new Dilation(0.0F))
		.uv(0, 31).cuboid(1.5F, 5.0F, -1.5F, 1.75F, 2.5F, 5.25F, new Dilation(0.0F))
		.uv(32, 7).cuboid(1.5F, 7.5F, -1.5F, 1.75F, 1.0F, 2.5F, new Dilation(0.0F)), ModelTransform.of(9.25F, -0.25F, 2.5F, 3.098F, 0.0F, -3.1416F));

		ModelPartData wing1 = body.addChild("wing1", ModelPartBuilder.create().uv(32, 7).cuboid(-1.0F, 3.4584F, 4.4402F, 1.75F, 1.0F, 2.5F, new Dilation(0.0F))
		.uv(0, 31).cuboid(-1.0F, 1.2084F, 1.6902F, 1.75F, 2.25F, 5.25F, new Dilation(0.0F))
		.uv(32, 0).mirrored().cuboid(-1.25F, -4.8416F, 0.4402F, 1.75F, 6.0F, 1.25F, new Dilation(0.0F)).mirrored(false)
		.uv(30, 25).cuboid(-1.0F, -5.2916F, 1.6902F, 1.75F, 6.5F, 5.25F, new Dilation(0.0F)), ModelTransform.of(4.5F, 1.9F, 3.45F, -0.1745F, 3.1416F, 0.0F));

		ModelPartData tail = Sich.addChild("tail", ModelPartBuilder.create(), ModelTransform.of(0.0F, -2.9F, 1.2F, 0.8727F, 0.0F, 0.0F));

		ModelPartData tail_r1 = tail.addChild("tail_r1", ModelPartBuilder.create().uv(14, 31).cuboid(-3.5F, -3.9F, 0.2F, 6.0F, 5.75F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 2.9F, 0.55F, 0.3927F, 0.0F, 0.0F));

		ModelPartData leg0 = Sich.addChild("leg0", ModelPartBuilder.create().uv(36, 11).cuboid(-1.0F, -1.0F, -1.5F, 1.25F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(1.5F, -1.5F, -0.5F));

		ModelPartData leg1 = Sich.addChild("leg1", ModelPartBuilder.create().uv(36, 11).cuboid(-1.25F, -1.0F, -1.5F, 1.25F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.0F, -1.5F, -0.5F));
		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void setAngles(SichEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw,headPitch);

		this.animateMovement(ModAnimations.ELF_OWL_FLYING, limbSwing,limbSwingAmount,2f,2.5f);
		this.updateAnimation(entity.idleAnimationState,ModAnimations.ELF_OWL_STANDING,ageInTicks,1f);
	}

	private void setHeadAngles(float headYaw,float headPitch){
		headYaw = MathHelper.clamp(headYaw,-30.0f,30.0f);
		headPitch = MathHelper.clamp(headPitch,-25.0f,45.0f);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
		Sich.render(matrices, vertexConsumer, light, overlay, color);
	}

	@Override
	public ModelPart getPart() {
		return Sich;
	}

}