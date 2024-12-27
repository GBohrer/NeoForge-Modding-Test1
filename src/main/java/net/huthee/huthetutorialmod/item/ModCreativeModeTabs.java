package net.huthee.huthetutorialmod.item;

import net.huthee.huthetutorialmod.HutheTutorialMod;
import net.huthee.huthetutorialmod.block.ModBlocks;
import net.huthee.huthetutorialmod.item.custom.ChiselItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, HutheTutorialMod.MOD_ID);

    public static final Supplier<CreativeModeTab> MANITE_ITEMS_TAB = CREATIVE_MODE_TAB.register(
            "manite_items_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.MANITE_INGOT.get()))
                    .title(Component.translatable("creativetab.huthetutorialmod.manite_items"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.MANITE_INGOT);
                        output.accept(ModItems.MANITE_BAR);
                        output.accept(ModItems.MANITE_NUGGET);
                        output.accept(ModBlocks.MANITE_BLOCK);

                        output.accept(ModItems.CHISEL);
                        output.accept(ModItems.EXTRACTOR);
                    })
                    .build());

    public static final Supplier<CreativeModeTab> EXPERILITE_ITEMS_TAB = CREATIVE_MODE_TAB.register(
            "experilite_items_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.RAW_EXPERILITE.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(HutheTutorialMod.MOD_ID, "manite_items_tab"))
                    .title(Component.translatable("creativetab.huthetutorialmod.experilite_items"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.RAW_EXPERILITE);
                        output.accept(ModBlocks.RAW_EXPERILITE_BLOCK);
                        output.accept(ModBlocks.EXPERILITE_ORE);
                        output.accept(ModBlocks.EXPERILITE_ORE_EMPTY);
                        output.accept(ModBlocks.DEEPSLATE_EXPERILITE_ORE);
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }

}
