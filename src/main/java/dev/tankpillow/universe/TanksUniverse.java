package dev.tankpillow.universe;

import dev.tankpillow.universe.block.ModBlocks;
import dev.tankpillow.universe.item.ModCreativeTab;
import dev.tankpillow.universe.item.ModItems;
import dev.tankpillow.universe.misc.CapeRegistry;
import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

public class TanksUniverse implements ModInitializer {

	public static final String MOD_ID = "tanks-universe";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		CompletableFuture.runAsync(CapeRegistry::load);

		ModCreativeTab.register();
		ModItems.register();
		ModBlocks.register();
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
