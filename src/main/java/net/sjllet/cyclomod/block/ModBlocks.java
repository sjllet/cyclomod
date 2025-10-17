package net.sjllet.cyclomod.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
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
    // SIHIRLITE
    public static final RegistryObject<Block> SIHIRLITE_BLOCK = registerBlock("sihirlite_block",
            () -> new AmethystBlock(BlockBehaviour.Properties.copy(Blocks.AMETHYST_BLOCK)));
    public static final RegistryObject<Block> BUDDING_SIHIRLITE = registerBlock("budding_sihirlite",
            () -> new AmethystBlock(BlockBehaviour.Properties.copy(Blocks.BUDDING_AMETHYST)));
    public static final RegistryObject<Block> SMALL_SIHIRLITE_BUD = registerBlock("small_sihirlite_bud",
            () -> new AmethystClusterBlock(3, 4, BlockBehaviour.Properties.copy(Blocks.AMETHYST_CLUSTER)
                    .noOcclusion().strength(1.5F).sound(SoundType.SMALL_AMETHYST_BUD).lightLevel(state -> 1)));
    public static final RegistryObject<Block> MEDIUM_SIHIRLITE_BUD = registerBlock("medium_sihirlite_bud",
            () -> new AmethystClusterBlock(4, 3, BlockBehaviour.Properties.copy(Blocks.AMETHYST_CLUSTER)
                    .noOcclusion().strength(1.5F).sound(SoundType.MEDIUM_AMETHYST_BUD).lightLevel(state -> 2)));
    public static final RegistryObject<Block> LARGE_SIHIRLITE_BUD = registerBlock("large_sihirlite_bud",
            () -> new AmethystClusterBlock(4, 3, BlockBehaviour.Properties.copy(Blocks.AMETHYST_CLUSTER)
                    .noOcclusion().strength(1.5F).sound(SoundType.LARGE_AMETHYST_BUD).lightLevel(state -> 4)));
    public static final RegistryObject<Block> SIHIRLITE_CLUSTER = registerBlock("sihirlite_cluster",
            () -> new AmethystClusterBlock(7, 3, BlockBehaviour.Properties.copy(Blocks.AMETHYST_CLUSTER)
                    .noOcclusion().strength(1.5F).sound(SoundType.AMETHYST_CLUSTER).lightLevel(state -> 5)));
    // OTROS
    public static final RegistryObject<Block> SOUND_BLOCK = registerBlock("sound_block",
            () -> new SoundBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

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