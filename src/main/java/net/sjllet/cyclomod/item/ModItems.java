package net.sjllet.cyclomod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sjllet.cyclomod.CycloMod;

import java.util.Properties;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CycloMod.MOD_ID);

    public static final RegistryObject<Item> RAW_WILLOVIUM = ITEMS.register("raw_willovium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WILLOVIUM_INGOT = ITEMS.register("willovium_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> WILLOVIUM_NUGGET = ITEMS.register("willovium_nugget",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}