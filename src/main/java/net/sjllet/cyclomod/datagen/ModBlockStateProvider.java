package net.sjllet.cyclomod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
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

        stairsBlock(((StairBlock) ModBlocks.WILLOVIUM_STAIRS.get()), blockTexture(ModBlocks.WILLOVIUM_BLOCK.get()));
        slabBlock(((SlabBlock) ModBlocks.WILLOVIUM_SLAB.get()), blockTexture(ModBlocks.WILLOVIUM_BLOCK.get()), blockTexture(ModBlocks.WILLOVIUM_BLOCK.get()));

        buttonBlock(((ButtonBlock) ModBlocks.WILLOVIUM_BUTTON.get()), blockTexture(ModBlocks.WILLOVIUM_BLOCK.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.WILLOVIUM_PRESSURE_PLATE.get()), blockTexture(ModBlocks.WILLOVIUM_BLOCK.get()));

        fenceBlock(((FenceBlock) ModBlocks.WILLOVIUM_FENCE.get()), blockTexture(ModBlocks.WILLOVIUM_BLOCK.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.WILLOVIUM_FENCE_GATE.get()), blockTexture(ModBlocks.WILLOVIUM_BLOCK.get()));
        wallBlock(((WallBlock) ModBlocks.WILLOVIUM_WALL.get()), blockTexture(ModBlocks.WILLOVIUM_BLOCK.get()));

        doorBlockWithRenderType(((DoorBlock) ModBlocks.WILLOVIUM_DOOR.get()), modLoc("block/willovium_door_bottom"), modLoc("block/willovium_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.WILLOVIUM_TRAPDOOR.get()), modLoc("block/willovium_trapdoor"), true, "cutout");

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