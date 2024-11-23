package com.homka.owlmod.entity.client;

import com.homka.owlmod.OwlMod;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer SICH =
            new EntityModelLayer(Identifier.of(OwlMod.MOD_ID,"sich"),"main");
}
