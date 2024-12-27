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

    public static final Supplier<CreativeModeTab> HUTHE_MAGIC_TAB = CREATIVE_MODE_TAB.register(
            "huthe_magic_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.RAW_EXPERILITE.get()))
                    .title(Component.translatable("creativetab.huthetutorialmod.huthe_magic"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.RAW_EXPERILITE);
                        output.accept(ModBlocks.EXPERILITE_ORE);
                        output.accept(ModBlocks.EXPERILITE_ORE_EMPTY);
                        output.accept(ModBlocks.DEEPSLATE_EXPERILITE_ORE);
                        output.accept(ModBlocks.DEEPSLATE_EXPERILITE_ORE_EMPTY);
                        output.accept(ModBlocks.RAW_EXPERILITE_BLOCK);
                        output.accept(ModBlocks.MAGIC_BLOCK);

                        output.accept(ModItems.MANITE_INGOT);
                        output.accept(ModItems.MANITE_BAR);
                        output.accept(ModItems.MANITE_NUGGET);
                        output.accept(ModBlocks.MANITE_BLOCK);

                        output.accept(ModItems.CHISEL);
                        output.accept(ModItems.EXTRACTOR);

                        output.accept(ModItems.RADISH);
                        output.accept(ModItems.RADISH_DRINK);

                        output.accept(ModItems.FROSTFIRE_COAL);
                        output.accept(ModItems.STARLIGHT_ASH);
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }

}
