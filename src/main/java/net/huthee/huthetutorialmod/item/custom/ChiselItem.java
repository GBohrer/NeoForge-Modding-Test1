package net.huthee.huthetutorialmod.item.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Objects;

public class ChiselItem extends Item {
    private static final Map<Block, Block> CHISEL_MAP =
            Map.ofEntries(
                    Map.entry(Blocks.STONE, Blocks.STONE_BRICKS),
                    Map.entry(Blocks.END_STONE, Blocks.END_STONE_BRICKS),
                    Map.entry(Blocks.DIORITE, Blocks.POLISHED_DIORITE),
                    Map.entry(Blocks.ANDESITE, Blocks.POLISHED_DIORITE),
                    Map.entry(Blocks.GRANITE, Blocks.POLISHED_GRANITE),
                    Map.entry(Blocks.DEEPSLATE, Blocks.DEEPSLATE_BRICKS),
                    Map.entry(Blocks.MUD, Blocks.MUD_BRICKS),
                    Map.entry(Blocks.TUFF, Blocks.TUFF_BRICKS),
                    Map.entry(Blocks.BLACKSTONE, Blocks.POLISHED_BLACKSTONE),
                    Map.entry(Blocks.BASALT, Blocks.POLISHED_BASALT),
                    Map.entry(Blocks.NETHER_WART_BLOCK, Blocks.RED_NETHER_BRICKS),
                    Map.entry(Blocks.TERRACOTTA, Blocks.BRICKS),
                    Map.entry(Blocks.PRISMARINE, Blocks.PRISMARINE_BRICKS),
                    Map.entry(Blocks.QUARTZ_BLOCK, Blocks.QUARTZ_BRICKS)
            );

    public ChiselItem(Properties properties) { super(properties); }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {

        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

        if(CHISEL_MAP.containsKey(clickedBlock)) {
            if(!level.isClientSide()) {     // ONLY SERVER
                level.setBlockAndUpdate(context.getClickedPos(), CHISEL_MAP.get(clickedBlock).defaultBlockState());

                context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
                        item -> Objects.requireNonNull(context.getPlayer()).onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, context.getClickedPos(), SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS);
            }
        }

        return InteractionResult.SUCCESS;
    }
}
