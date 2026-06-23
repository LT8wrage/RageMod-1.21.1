package net.lt8wrage.ragemod.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties CARROT_OF_DOOM_AND_DESPAIR = new FoodProperties.Builder().nutrition(20).saturationModifier(20f)
            .effect(() -> new MobEffectInstance(MobEffects.SATURATION, Integer.MAX_VALUE, 0, false, false), 1.0F).build();
}
