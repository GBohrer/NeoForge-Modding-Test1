package net.huthee.huthetutorialmod.item;

import net.huthee.huthetutorialmod.HutheTutorialMod;
import net.huthee.huthetutorialmod.item.custom.ChiselItem;
import net.huthee.huthetutorialmod.item.custom.MagicExtractorItem;
import net.huthee.huthetutorialmod.item.custom.RadishDrinkItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(HutheTutorialMod.MOD_ID);

    public static final DeferredItem<Item> RAW_EXPERILITE = ITEMS.register("raw_experilite",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> MANITE_INGOT = ITEMS.register("manite_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> MANITE_BAR = ITEMS.register("manite_bar",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> MANITE_NUGGET = ITEMS.register("manite_nugget",
            () -> new Item(new Item.Properties()));

    public  static final DeferredItem<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties().durability(1024)));
    public  static final DeferredItem<Item> EXTRACTOR = ITEMS.register("extractor",
            () -> new MagicExtractorItem(new Item.Properties().durability(1024)));
    public  static final DeferredItem<Item> RADISH = ITEMS.register("radish",
            () -> new Item(new Item.Properties().food(ModFoodProperties.RADISH)));
    public  static final DeferredItem<Item> RADISH_DRINK = ITEMS.register("radish_drink",
            () -> new RadishDrinkItem(new Item.Properties().food(ModFoodProperties.RADISH_DRINK)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
