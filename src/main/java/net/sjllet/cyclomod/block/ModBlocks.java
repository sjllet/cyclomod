package net.sjllet.cyclomod.block;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sjllet.cyclomod.CycloMod;
import net.sjllet.cyclomod.block.custom.SoundBlock;
import net.sjllet.cyclomod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, CycloMod.MOD_ID);

    // WILLOVIUM
    public static final RegistryObject<Block> WILLOVIUM_BLOCK = registerBlock("willovium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK)));
    public static final RegistryObject<Block> RAW_WILLOVIUM_BLOCK = registerBlock("raw_willovium_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK)));
    public static final RegistryObject<Block> WILLOVIUM_ORE = registerBlock("willovium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3,6)));
    public static final RegistryObject<Block> DEEPSLATE_WILLOVIUM_ORE = registerBlock("deepslate_willovium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3,7)));
    public static final RegistryObject<Block> NETHER_WILLOVIUM_ORE = registerBlock("nether_willovium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3,7)));
    public static final RegistryObject<Block> END_STONE_WILLOVIUM_ORE = registerBlock("end_stone_willovium_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3,7)));

    public static final RegistryObject<Block> WILLOVIUM_STAIRS = registerBlock("willovium_stairs",
            () -> new StairBlock(() -> ModBlocks.WILLOVIUM_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK)));
    public static final RegistryObject<Block> WILLOVIUM_SLAB = registerBlock("willovium_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK)));

    public static final RegistryObject<Block> WILLOVIUM_BUTTON = registerBlock("willovium_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON),
            BlockSetType.IRON, 10, false));
    public static final RegistryObject<Block> WILLOVIUM_PRESSURE_PLATE = registerBlock("willovium_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK),
                    BlockSetType.IRON));

    public static final RegistryObject<Block> WILLOVIUM_FENCE = registerBlock("willovium_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK)));
    public static final RegistryObject<Block> WILLOVIUM_FENCE_GATE = registerBlock("willovium_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK), SoundEvents.CHAIN_PLACE, SoundEvents.ANVIL_BREAK));
    public static final RegistryObject<Block> WILLOVIUM_WALL = registerBlock("willovium_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK)));

    public static final RegistryObject<Block> WILLOVIUM_DOOR = registerBlock("willovium_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).noOcclusion(), BlockSetType.IRON));
    public static final RegistryObject<Block> WILLOVIUM_TRAPDOOR = registerBlock("willovium_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).noOcclusion(), BlockSetType.IRON));

    // SIHIRLITE
    public static final RegistryObject<Block> SIHIRLITE_BLOCK = registerBlock("sihirlite_block",
            () -> new AmethystBlock(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK)));
    public static final RegistryObject<Block> BUDDING_SIHIRLITE = registerBlock("budding_sihirlite",
            () -> new AmethystBlock(BlockBehaviour.Properties.copy(Blocks.BUDDING_AMETHYST).noLootTable()));
    public static final RegistryObject<Block> SMALL_SIHIRLITE_BUD = registerBlock("small_sihirlite_bud",
            () -> new AmethystClusterBlock(3, 4, BlockBehaviour.Properties.copy(Blocks.AMETHYST_CLUSTER)
                    .noOcclusion().strength(1.5F).sound(SoundType.SMALL_AMETHYST_BUD).lightLevel(state -> 1).noLootTable()));
    public static final RegistryObject<Block> MEDIUM_SIHIRLITE_BUD = registerBlock("medium_sihirlite_bud",
            () -> new AmethystClusterBlock(4, 3, BlockBehaviour.Properties.copy(Blocks.AMETHYST_CLUSTER)
                    .noOcclusion().strength(1.5F).sound(SoundType.MEDIUM_AMETHYST_BUD).lightLevel(state -> 2).noLootTable()));
    public static final RegistryObject<Block> LARGE_SIHIRLITE_BUD = registerBlock("large_sihirlite_bud",
            () -> new AmethystClusterBlock(4, 3, BlockBehaviour.Properties.copy(Blocks.AMETHYST_CLUSTER)
                    .noOcclusion().strength(1.5F).sound(SoundType.LARGE_AMETHYST_BUD).lightLevel(state -> 4).noLootTable()));
    public static final RegistryObject<Block> SIHIRLITE_CLUSTER = registerBlock("sihirlite_cluster",
            () -> new AmethystClusterBlock(7, 3, BlockBehaviour.Properties.copy(Blocks.AMETHYST_CLUSTER)
                    .noOcclusion().strength(1.5F).sound(SoundType.AMETHYST_CLUSTER).lightLevel(state -> 5)));
    // OTROS
    public static final RegistryObject<Block> SOUND_BLOCK = registerBlock("sound_block",
            () -> new SoundBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).noLootTable()));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}