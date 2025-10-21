package net.sjllet.cyclomod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sjllet.cyclomod.CycloMod;
import net.sjllet.cyclomod.block.ModBlocks;
import net.sjllet.cyclomod.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CycloMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.RAW_WILLOVIUM);
        simpleItem(ModItems.WILLOVIUM_INGOT);
        simpleItem(ModItems.WILLOVIUM_NUGGET);
        simpleBlockItem(ModBlocks.WILLOVIUM_DOOR);
        evenSimplerBlockItem(ModBlocks.WILLOVIUM_STAIRS);
        evenSimplerBlockItem(ModBlocks.WILLOVIUM_SLAB);
        evenSimplerBlockItem(ModBlocks.WILLOVIUM_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.WILLOVIUM_FENCE_GATE);
        fenceItem(ModBlocks.WILLOVIUM_FENCE, ModBlocks.WILLOVIUM_BLOCK);
        buttonItem(ModBlocks.WILLOVIUM_BUTTON, ModBlocks.WILLOVIUM_BLOCK);
        wallItem(ModBlocks.WILLOVIUM_WALL, ModBlocks.WILLOVIUM_BLOCK);
        trapdoorItem(ModBlocks.WILLOVIUM_TRAPDOOR);

        simpleItem(ModItems.SIHIRLITE_SHARD);
        simpleItem(ModItems.SILVER_GUNPOWDER);
        simpleItem(ModItems.TITANIUM_STAR);
        simpleItem(ModItems.GEAR);
        simpleItem(ModItems.RIVATO_GUM);
        simpleItem(ModItems.ALCOHOL);
        simpleItem(ModItems.METAL_DETECTOR);

        handheldItem(ModItems.WILLOVIUM_SWORD);
        handheldItem(ModItems.WILLOVIUM_PICKAXE);
        handheldItem(ModItems.WILLOVIUM_AXE);
        handheldItem(ModItems.WILLOVIUM_SHOVEL);
        handheldItem(ModItems.WILLOVIUM_HOE);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(CycloMod.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(CycloMod.MOD_ID,"item/" + item.getId().getPath()));
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(CycloMod.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(CycloMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(CycloMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(CycloMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(CycloMod.MOD_ID, "item/" + item.getId().getPath()));
    }

}