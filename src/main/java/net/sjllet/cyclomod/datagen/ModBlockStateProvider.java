package net.sjllet.cyclomod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.sjllet.cyclomod.CycloMod;
import net.sjllet.cyclomod.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CycloMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        // WILLOVIUM
        blockWithItem(ModBlocks.WILLOVIUM_BLOCK);
        blockWithItem(ModBlocks.RAW_WILLOVIUM_BLOCK);
        blockWithItem(ModBlocks.WILLOVIUM_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_WILLOVIUM_ORE);
        blockWithItem(ModBlocks.NETHER_WILLOVIUM_ORE);
        blockWithItem(ModBlocks.END_STONE_WILLOVIUM_ORE);
        // SIHIRLITE
        blockWithItem(ModBlocks.SIHIRLITE_BLOCK);
        blockWithItem(ModBlocks.BUDDING_SIHIRLITE);
        // OTROS
        blockWithItem(ModBlocks.SOUND_BLOCK);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}