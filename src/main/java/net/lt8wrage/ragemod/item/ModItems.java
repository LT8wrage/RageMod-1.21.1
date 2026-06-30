package net.lt8wrage.ragemod.item;

import net.lt8wrage.ragemod.RageMod;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(RageMod.MODID);

    //basic items
    public static final DeferredItem<Item> ENDERITE_SCRAP = ITEMS.register("enderite_scrap", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ENDERITE_INGOT = ITEMS.register("enderite_ingot", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> GOLDEN_CORE = ITEMS.register("golden_core", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ENDERITE_TEMPLATE = ITEMS.register("enderite_template", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ENDERITE_PEARL = ITEMS.register("enderite_pearl", () -> new EnderitePearlItem(new Item.Properties()));

    //food
    public static final DeferredItem<Item> CARROT_OF_DOOM_AND_DESPAIR = ITEMS.register("carrot_of_doom_and_despair", () -> new Item(new Item.Properties()
            .food(ModFoodProperties.CARROT_OF_DOOM_AND_DESPAIR)));

    //tools
    public static final DeferredItem<EnderiteSwordItem> ENDERITE_SWORD = ITEMS.register("enderite_sword", () -> new EnderiteSwordItem(ModToolTiers.ENDERITE, new Item.Properties()
            .attributes(SwordItem.createAttributes(ModToolTiers.ENDERITE, 5, -2.4f))));
    public static final DeferredItem<PickaxeItem> ENDERITE_PICKAXE = ITEMS.register("enderite_pickaxe", () -> new PickaxeItem(ModToolTiers.ENDERITE, new Item.Properties()
            .attributes(PickaxeItem.createAttributes(ModToolTiers.ENDERITE, 1.0f,-2.8f))));
    public static final DeferredItem<ShovelItem> ENDERITE_SHOVEL = ITEMS.register("enderite_shovel", () -> new ShovelItem(ModToolTiers.ENDERITE, new Item.Properties()
            .attributes(ShovelItem.createAttributes(ModToolTiers.ENDERITE, 1.5f,-3.0f))));
    public static final DeferredItem<AxeItem> ENDERITE_AXE = ITEMS.register("enderite_axe", () -> new AxeItem(ModToolTiers.ENDERITE, new Item.Properties()
            .attributes(AxeItem.createAttributes(ModToolTiers.ENDERITE, 6.0f,-3.2f))));
    public static final DeferredItem<HoeItem> ENDERITE_HOE = ITEMS.register("enderite_hoe", () -> new HoeItem(ModToolTiers.ENDERITE, new Item.Properties()
            .attributes(HoeItem.createAttributes(ModToolTiers.ENDERITE, 0f,-3.0f))));

    //armor
    public static final DeferredItem<ArmorItem> ENDERITE_HELMET = ITEMS.register("enderite_helmet",
            ()-> new ArmorItem(ModArmorMaterials.ENDERITE_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(50))));
    public static final DeferredItem<ArmorItem> ENDERITE_CHESTPLATE = ITEMS.register("enderite_chestplate",
            ()-> new ArmorItem(ModArmorMaterials.ENDERITE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(50))));
    public static final DeferredItem<ArmorItem> ENDERITE_LEGGINGS = ITEMS.register("enderite_leggings",
            ()-> new ArmorItem(ModArmorMaterials.ENDERITE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(50))));
    public static final DeferredItem<ArmorItem> ENDERITE_BOOTS = ITEMS.register("enderite_boots",
            ()-> new ArmorItem(ModArmorMaterials.ENDERITE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(50))));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
