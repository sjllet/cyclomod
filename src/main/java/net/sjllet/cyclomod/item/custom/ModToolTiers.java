package net.sjllet.cyclomod.item.custom;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import net.sjllet.cyclomod.CycloMod;
import net.sjllet.cyclomod.item.ModItems;
import net.sjllet.cyclomod.util.ModTags;

import java.util.List;

public class ModToolTiers {
    public static final Tier WILLOVIUM = TierSortingRegistry.registerTier(
            new ForgeTier(2, 999, 7f, 2.5f, 13,
                    ModTags.Blocks.NEEDS_WILLOVIUM_TOOL, () -> Ingredient.of(ModItems.WILLOVIUM_INGOT.get())),
            new ResourceLocation(CycloMod.MOD_ID, "willovium_ingot"), List.of(Tiers.IRON), List.of());
}