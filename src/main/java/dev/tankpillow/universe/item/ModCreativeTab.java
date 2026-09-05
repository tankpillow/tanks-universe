package dev.tankpillow.universe.item;

import dev.tankpillow.universe.TanksUniverse;
import dev.tankpillow.universe.block.ModBlocks;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeTab {

    public static final ResourceKey<CreativeModeTab> TANKS_UNIVERSE_TAB_KEY = ResourceKey.create(
            Registries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(TanksUniverse.MOD_ID, "tanks_universe_tab")
    );

    public static final CreativeModeTab TANKS_UNIVERSE_TAB = FabricCreativeModeTab.builder()
            .title(Component.translatable("itemGroup.tanks-universe"))
            .icon(() -> new ItemStack(ModItems.ALUMINUM_INGOT))
            .displayItems(((parameters, output) -> {
                output.accept(ModItems.ALUMINUM_INGOT);
                output.accept(ModItems.RAW_ALUMINUM);
                output.accept(ModBlocks.ALUMINUM_BLOCK);
                output.accept(ModBlocks.ALUMINUM_ORE);
                output.accept(ModBlocks.DEEPSLATE_ALUMINUM_ORE);
            })).build();

    public static void register() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, TANKS_UNIVERSE_TAB_KEY, TANKS_UNIVERSE_TAB);
    }
}
