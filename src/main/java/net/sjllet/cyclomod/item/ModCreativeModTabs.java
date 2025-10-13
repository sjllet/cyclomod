package net.sjllet.cyclomod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.sjllet.cyclomod.CycloMod;
import net.sjllet.cyclomod.block.ModBlocks;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CycloMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> CYCLOMOD_TAB = CREATIVE_MODE_TABS.register("cyclomod_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RAW_WILLOVIUM.get()))
                    .title(Component.translatable("creativetab.cyclomod_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.RAW_WILLOVIUM.get());
                        output.accept(ModItems.WILLOVIUM_INGOT.get());
                        output.accept(ModItems.WILLOVIUM_NUGGET.get());
                        output.accept(ModBlocks.WILLOVIUM_BLOCK.get());
                        output.accept(ModBlocks.WILLOVIUM_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_WILLOVIUM_ORE.get());
                        output.accept(ModBlocks.NETHER_WILLOVIUM_ORE.get());
                        output.accept(ModBlocks.END_STONE_WILLOVIUM_ORE.get());
                        output.accept(ModItems.METAL_DETECTOR.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
