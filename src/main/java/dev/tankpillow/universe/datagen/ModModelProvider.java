package dev.tankpillow.universe.datagen;

import dev.tankpillow.universe.block.ModBlocks;
import dev.tankpillow.universe.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        blockModelGenerators.createTrivialCube(ModBlocks.ALUMINUM_BLOCK);
        blockModelGenerators.createTrivialCube(ModBlocks.ALUMINUM_ORE);
        blockModelGenerators.createTrivialCube(ModBlocks.DEEPSLATE_ALUMINUM_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(ModItems.ALUMINUM_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.RAW_ALUMINUM, ModelTemplates.FLAT_ITEM);
    }
}
