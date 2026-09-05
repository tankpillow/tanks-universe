package dev.tankpillow.universe.item;

import dev.tankpillow.universe.TanksUniverse;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

public class ModItems {

    public static final Item ALUMINUM_INGOT = registerItem("aluminum_ingot");
    public static final Item RAW_ALUMINUM = registerItem("raw_aluminum");

    private static Item registerItem(String name) {
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TanksUniverse.MOD_ID, name));
        Item item = new Item(new Item.Properties().setId(key));
        return Registry.register(BuiltInRegistries.ITEM, key, item);
    }

    public static void register() {}

}
