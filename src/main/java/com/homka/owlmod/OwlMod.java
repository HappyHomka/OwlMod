package com.homka.owlmod;

import com.homka.owlmod.block.ModBlocks;
import com.homka.owlmod.block.ModBlockEntities;
import com.homka.owlmod.item.ModItemGroup;
import com.homka.owlmod.item.ModItems;
import com.homka.owlmod.sound.ModSounds;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OwlMod implements ModInitializer {
	public static final String MOD_ID = "owlmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
		ModItemGroup.registerItemGroups();
		ModSounds.registerSound();
		ModBlockEntities.registerModBE();
	}
}