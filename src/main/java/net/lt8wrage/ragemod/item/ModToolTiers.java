package net.lt8wrage.ragemod.item;

import net.lt8wrage.ragemod.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
    public static final Tier ENDERITE = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_ENDERITE_TOOL,
            5000, 10f, 5f, 30, ()-> Ingredient.of(ModItems.ENDERITE_INGOT));
}
