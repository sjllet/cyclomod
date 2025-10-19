package net.sjllet.cyclomod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties RIVATO_GUM = new FoodProperties.Builder().nutrition(11)
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.HUNGER, 200), 1.0f).build();
}