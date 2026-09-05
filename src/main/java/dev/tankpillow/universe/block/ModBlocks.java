package dev.tankpillow.universe.block;

import dev.tankpillow.universe.TanksUniverse;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public class ModBlocks {

    public static final Block ALUMINUM_ORE = registerBlock("aluminum_ore",
            Block::new,
            BlockBehaviour.Properties.of()
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
    );

    public static final Block DEEPSLATE_ALUMINUM_ORE = registerBlock("deepslate_aluminum_ore",
            Block::new,
            BlockBehaviour.Properties.of()
                    .strength(4.5f, 3.0f)
                    .requiresCorrectToolForDrops()
            );

    public static final Block ALUMINUM_BLOCK = registerBlock("aluminum_block",
            Block::new,
            BlockBehaviour.Properties.of()
                    .strength(5.0f, 6.0f)
                    .requiresCorrectToolForDrops()
    );

    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties properties) {
        ResourceKey<Block> blockKey = keyOfBlock(name);
        Block block = blockFactory.apply(properties.setId(blockKey));

        ResourceKey<Item> itemKey = keyOfItem(name);
        BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix());
        Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);

        return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
    }

    private static ResourceKey<Block> keyOfBlock(String name) {
        return ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(TanksUniverse.MOD_ID, name));
    }

    private static ResourceKey<Item> keyOfItem(String name) {
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TanksUniverse.MOD_ID, name));
    }

    public static void register() {

    }

}
