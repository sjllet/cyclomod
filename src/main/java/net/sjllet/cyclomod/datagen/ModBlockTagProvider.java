package net.sjllet.cyclomod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.sjllet.cyclomod.CycloMod;
import net.sjllet.cyclomod.block.ModBlocks;
import net.sjllet.cyclomod.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, CycloMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
                .add(ModBlocks.WILLOVIUM_ORE.get(),
                        ModBlocks.DEEPSLATE_WILLOVIUM_ORE.get(),
                        ModBlocks.NETHER_WILLOVIUM_ORE.get(),
                        ModBlocks.END_STONE_WILLOVIUM_ORE.get(),
                        ModBlocks.BUDDING_SIHIRLITE.get())
                .addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.WILLOVIUM_ORE.get(),
                        ModBlocks.DEEPSLATE_WILLOVIUM_ORE.get(),
                        ModBlocks.NETHER_WILLOVIUM_ORE.get(),
                        ModBlocks.END_STONE_WILLOVIUM_ORE.get(),
                        ModBlocks.WILLOVIUM_BLOCK.get(),
                        ModBlocks.RAW_WILLOVIUM_BLOCK.get(),
                        ModBlocks.SIHIRLITE_BLOCK.get(),
                        ModBlocks.BUDDING_SIHIRLITE.get(),
                        ModBlocks.SIHIRLITE_CLUSTER.get(),
                        ModBlocks.SMALL_SIHIRLITE_BUD.get(),
                        ModBlocks.MEDIUM_SIHIRLITE_BUD.get(),
                        ModBlocks.LARGE_SIHIRLITE_BUD.get(),
                        ModBlocks.WILLOVIUM_STAIRS.get(),
                        ModBlocks.WILLOVIUM_SLAB.get(),
                        ModBlocks.WILLOVIUM_FENCE.get(),
                        ModBlocks.WILLOVIUM_FENCE_GATE.get(),
                        ModBlocks.WILLOVIUM_WALL.get(),
                        ModBlocks.WILLOVIUM_BUTTON.get(),
                        ModBlocks.WILLOVIUM_PRESSURE_PLATE.get(),
                        ModBlocks.WILLOVIUM_DOOR.get(),
                        ModBlocks.WILLOVIUM_TRAPDOOR.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL);

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.WILLOVIUM_ORE.get(),
                        ModBlocks.DEEPSLATE_WILLOVIUM_ORE.get(),
                        ModBlocks.NETHER_WILLOVIUM_ORE.get(),
                        ModBlocks.END_STONE_WILLOVIUM_ORE.get(),
                        ModBlocks.WILLOVIUM_BLOCK.get(),
                        ModBlocks.RAW_WILLOVIUM_BLOCK.get(),
                        ModBlocks.WILLOVIUM_STAIRS.get(),
                        ModBlocks.WILLOVIUM_SLAB.get(),
                        ModBlocks.WILLOVIUM_FENCE.get(),
                        ModBlocks.WILLOVIUM_FENCE_GATE.get(),
                        ModBlocks.WILLOVIUM_WALL.get(),
                        ModBlocks.WILLOVIUM_BUTTON.get(),
                        ModBlocks.WILLOVIUM_PRESSURE_PLATE.get(),
                        ModBlocks.WILLOVIUM_DOOR.get(),
                        ModBlocks.WILLOVIUM_TRAPDOOR.get());

        this.tag(ModTags.Blocks.NEEDS_WILLOVIUM_TOOL)
                .add(ModBlocks.SIHIRLITE_BLOCK.get(),
                        ModBlocks.BUDDING_SIHIRLITE.get(),
                        ModBlocks.SIHIRLITE_CLUSTER.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL);

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL);

        this.tag(BlockTags.FENCES)
                .add(ModBlocks.WILLOVIUM_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.WILLOVIUM_FENCE_GATE.get());
        this.tag(BlockTags.WALLS)
                .add(ModBlocks.WILLOVIUM_WALL.get());
    }
}