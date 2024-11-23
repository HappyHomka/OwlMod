package com.homka.owlmod.entity;

import com.homka.owlmod.OwlMod;
import com.homka.owlmod.entity.custom.SichEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityType;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {

    public static final EntityType<SichEntity> SICH = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(OwlMod.MOD_ID,"sich"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, SichEntity::new)
                    .dimensions(EntityDimensions.fixed(1f,1f)).build());


    public static void registerModEntities() {
        OwlMod.LOGGER.info("Registering Entities for " + OwlMod.MOD_ID);
    }
}
