package net.sjllet.cyclomod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sjllet.cyclomod.CycloMod;
import net.sjllet.cyclomod.item.custom.FuelItem;
import net.sjllet.cyclomod.item.custom.MetalDetectorItem;

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
    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(200)));
    public static final RegistryObject<Item> SIHIRLITE_SHARD = ITEMS.register("sihirlite_shard",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SILVER_GUNPOWDER = ITEMS.register("silver_gunpowder",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GEAR = ITEMS.register("gear",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TITANIUM_STAR = ITEMS.register("titanium_star",
            () -> new FuelItem(new Item.Properties(), 40000));
    public static final RegistryObject<Item> RIVATO_GUM = ITEMS.register("rivato_gum",
            () -> new Item(new Item.Properties().food(ModFoods.RIVATO_GUM)));
    public static final RegistryObject<Item> CANNON_CORE = ITEMS.register("cannon_core",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ALCOHOL = ITEMS.register("alcohol",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}