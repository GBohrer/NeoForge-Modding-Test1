package net.huthee.huthetutorialmod.item.custom;

import net.huthee.huthetutorialmod.HutheTutorialMod;
import net.huthee.huthetutorialmod.block.ModBlocks;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MagicExtractorItem extends Item {
    private static final Map<Block, Block> EXTRACTOR_MAP =
            Map.ofEntries(
                    Map.entry(ModBlocks.EXPERILITE_ORE.get(), ModBlocks.EXPERILITE_ORE_EMPTY.get()),
                    Map.entry(ModBlocks.DEEPSLATE_EXPERILITE_ORE.get(), ModBlocks.DEEPSLATE_EXPERILITE_ORE_EMPTY.get())
            );

    public MagicExtractorItem(Properties properties) { super(properties); }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {

        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

        if(EXTRACTOR_MAP.containsKey(clickedBlock)) {
            if(!level.isClientSide()) {
                level.setBlockAndUpdate(context.getClickedPos(), EXTRACTOR_MAP.get(clickedBlock).defaultBlockState());

                Objects.requireNonNull(context.getPlayer()).giveExperiencePoints(30);

                context.getItemInHand().hurtAndBreak(2, ((ServerLevel) level), context.getPlayer(),
                        item -> Objects.requireNonNull(context.getPlayer()).onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, context.getClickedPos(), SoundEvents.ALLAY_HURT, SoundSource.BLOCKS);
            }
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if(Screen.hasShiftDown()){
            tooltipComponents.add(Component.translatable("tooltip.huthetutorialmod.extractor"));
        } else {
            tooltipComponents.add(Component.translatable("tooltip.huthetutorialmod.default"));
        }
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
