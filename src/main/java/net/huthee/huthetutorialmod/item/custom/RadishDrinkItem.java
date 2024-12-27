package net.huthee.huthetutorialmod.item.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;

import java.util.List;

public class RadishDrinkItem extends Item {

    public RadishDrinkItem(Properties properties) { super(properties); }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if(Screen.hasShiftDown()) {
            tooltipComponents.add(Component.translatable("tooltip.huthetutorialmod.radish_drink"));
        } else {
            tooltipComponents.add(Component.translatable("tooltip.huthetutorialmod.default"));
        }
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
