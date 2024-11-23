package com.homka.owlmod.entity.client;

import com.homka.owlmod.OwlMod;
import com.homka.owlmod.entity.custom.SichEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class SichRenderer extends MobEntityRenderer<SichEntity,SichModel<SichEntity>> {
    public static final Identifier TEXTURE = Identifier.of(OwlMod.MOD_ID,"textures/entity/sich.png");

    public SichRenderer(EntityRendererFactory.Context context) {
        super(context, new SichModel<>(context.getPart(ModModelLayers.SICH)),0.6f);
    }

    @Override
    public Identifier getTexture(SichEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(SichEntity livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {


        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
