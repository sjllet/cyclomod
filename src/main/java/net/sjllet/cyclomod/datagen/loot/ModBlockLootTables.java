package net.sjllet.cyclomod.datagen.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import net.sjllet.cyclomod.block.ModBlocks;
import net.sjllet.cyclomod.item.ModItems;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.WILLOVIUM_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_WILLOVIUM_BLOCK.get());
        this.dropSelf(ModBlocks.SIHIRLITE_BLOCK.get());

        this.add(ModBlocks.WILLOVIUM_ORE.get(),
                block -> createOreDrop(ModBlocks.WILLOVIUM_ORE.get(), ModItems.RAW_WILLOVIUM.get()));
        this.add(ModBlocks.SIHIRLITE_CLUSTER.get(),
                block -> createOreDrop(ModBlocks.SIHIRLITE_CLUSTER.get(), ModItems.SIHIRLITE_SHARD.get()));
        this.add(ModBlocks.DEEPSLATE_WILLOVIUM_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_WILLOVIUM_ORE.get(), ModItems.RAW_WILLOVIUM.get()));
        this.add(ModBlocks.END_STONE_WILLOVIUM_ORE.get(),
                block -> createOreDrop(ModBlocks.END_STONE_WILLOVIUM_ORE.get(), ModItems.RAW_WILLOVIUM.get()));
        this.add(ModBlocks.NETHER_WILLOVIUM_ORE.get(),
                block -> createNuggetOreDrops(ModBlocks.NETHER_WILLOVIUM_ORE.get(), ModItems.WILLOVIUM_NUGGET.get()));

        this.dropSelf(ModBlocks.WILLOVIUM_STAIRS.get());
        this.dropSelf(ModBlocks.WILLOVIUM_BUTTON.get());
        this.dropSelf(ModBlocks.WILLOVIUM_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.WILLOVIUM_TRAPDOOR.get());
        this.dropSelf(ModBlocks.WILLOVIUM_FENCE.get());
        this.dropSelf(ModBlocks.WILLOVIUM_FENCE_GATE.get());
        this.dropSelf(ModBlocks.WILLOVIUM_WALL.get());

        this.add(ModBlocks.WILLOVIUM_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.WILLOVIUM_SLAB.get()));
        this.add(ModBlocks.WILLOVIUM_DOOR.get(),
                block -> createDoorTable(ModBlocks.WILLOVIUM_DOOR.get()));
    }

    protected LootTable.Builder createNuggetOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock, this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 6.0F))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}