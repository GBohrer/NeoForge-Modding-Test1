package net.huthee.huthetutorialmod.item;

import net.huthee.huthetutorialmod.HutheTutorialMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(HutheTutorialMod.MOD_ID);

    public static final DeferredItem<Item> MANITE = ITEMS.register("manite",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> EXPERILITE = ITEMS.register("experilite",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
