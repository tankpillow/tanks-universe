package dev.tankpillow.universe.datagen;

import dev.tankpillow.universe.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagsProvider.BlockTagsProvider {

    public ModBlockTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        // Blocks that use requiresCorrectToolForDrops() only drop items when mined with a tool from these tags.
        this.builder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(key(ModBlocks.ALUMINUM_ORE))
                .add(key(ModBlocks.DEEPSLATE_ALUMINUM_ORE))
                .add(key(ModBlocks.ALUMINUM_BLOCK))
                .add(key(ModBlocks.RAW_ALUMINUM_BLOCK));

        // Same tier as vanilla iron and copper: stone pickaxe or better.
        this.builder(BlockTags.NEEDS_STONE_TOOL)
                .add(key(ModBlocks.ALUMINUM_ORE))
                .add(key(ModBlocks.DEEPSLATE_ALUMINUM_ORE))
                .add(key(ModBlocks.ALUMINUM_BLOCK))
                .add(key(ModBlocks.RAW_ALUMINUM_BLOCK));
    }

    private static ResourceKey<Block> key(Block block) {
        return block.builtInRegistryHolder().key();
    }
}
