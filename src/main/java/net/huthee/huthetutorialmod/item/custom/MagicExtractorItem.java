package net.huthee.huthetutorialmod.item.custom;

import net.huthee.huthetutorialmod.HutheTutorialMod;
import net.huthee.huthetutorialmod.block.ModBlocks;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class MagicExtractorItem extends Item {

    public MagicExtractorItem(Properties properties) { super(properties); }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {

        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

        if(clickedBlock.equals(ModBlocks.EXPERILITE_ORE.get()) || clickedBlock.equals(ModBlocks.DEEPSLATE_EXPERILITE_ORE.get())) {
            if(!level.isClientSide()) {
                context.getItemInHand().hurtAndBreak(2, ((ServerLevel) level), context.getPlayer(),
                        item -> Objects.requireNonNull(context.getPlayer()).onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, context.getClickedPos(), SoundEvents.ALLAY_HURT, SoundSource.BLOCKS);
            }
        }

        return InteractionResult.SUCCESS;
    }
}
