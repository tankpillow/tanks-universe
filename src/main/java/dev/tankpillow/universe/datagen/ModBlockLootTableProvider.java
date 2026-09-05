package dev.tankpillow.universe.datagen;

import dev.tankpillow.universe.block.ModBlocks;
import dev.tankpillow.universe.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTableProvider extends FabricBlockLootSubProvider {

    public ModBlockLootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {
        this.add(ModBlocks.ALUMINUM_ORE, (block) -> this.createOreDrop(block, ModItems.RAW_ALUMINUM));
        this.add(ModBlocks.DEEPSLATE_ALUMINUM_ORE, (block) -> this.createOreDrop(block, ModItems.RAW_ALUMINUM));
        this.add(ModBlocks.ALUMINUM_BLOCK, block -> this.createSingleItemTable(ModBlocks.ALUMINUM_BLOCK));
    }
}
