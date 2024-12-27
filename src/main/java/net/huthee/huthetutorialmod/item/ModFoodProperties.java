package net.huthee.huthetutorialmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Items;

public class ModFoodProperties {
    public static final FoodProperties RADISH = new FoodProperties.Builder()
            .nutrition(2)
            .saturationModifier(0.25f)
            .build();
    public static final FoodProperties RADISH_DRINK = new FoodProperties.Builder()
            .nutrition(6)
            .saturationModifier(0.55f)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 200), 0.65f)
            .usingConvertsTo(Items.GLASS_BOTTLE)
            .build();
}
