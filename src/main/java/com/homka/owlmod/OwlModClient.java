package com.homka.owlmod;

import com.homka.owlmod.block.ModBlocks;
import com.homka.owlmod.entity.ModEntities;
import com.homka.owlmod.entity.client.ModModelLayers;
import com.homka.owlmod.entity.client.SichModel;
import com.homka.owlmod.entity.client.SichRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;

public class OwlModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.OWL_STATUE_ONE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.OWL_STATUE_TWO, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.OWL_STATUE_THREE, RenderLayer.getCutout());

        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SICH, SichModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.SICH, SichRenderer::new);
    }
}
