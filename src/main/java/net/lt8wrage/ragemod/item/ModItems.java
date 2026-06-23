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

    //tools
    public static final DeferredItem<SwordItem> ENDERITE_SWORD = ITEMS.register("enderite_sword", () -> new SwordItem(ModToolTiers.ENDERITE, new Item.Properties()
            .attributes(SwordItem.createAttributes(ModToolTiers.ENDERITE, 5,-2.4f))));
    public static final DeferredItem<PickaxeItem> ENDERITE_PICKAXE = ITEMS.register("enderite_pickaxe", () -> new PickaxeItem(ModToolTiers.ENDERITE, new Item.Properties()
            .attributes(PickaxeItem.createAttributes(ModToolTiers.ENDERITE, 1.0f,-2.8f))));
    public static final DeferredItem<ShovelItem> ENDERITE_SHOVEL = ITEMS.register("enderite_shovel", () -> new ShovelItem(ModToolTiers.ENDERITE, new Item.Properties()
            .attributes(ShovelItem.createAttributes(ModToolTiers.ENDERITE, 1.5f,-3.0f))));
    public static final DeferredItem<AxeItem> ENDERITE_AXE = ITEMS.register("enderite_axe", () -> new AxeItem(ModToolTiers.ENDERITE, new Item.Properties()
            .attributes(AxeItem.createAttributes(ModToolTiers.ENDERITE, 6.0f,-3.2f))));
    public static final DeferredItem<HoeItem> ENDERITE_HOE = ITEMS.register("enderite_hoe", () -> new HoeItem(ModToolTiers.ENDERITE, new Item.Properties()
            .attributes(HoeItem.createAttributes(ModToolTiers.ENDERITE, 0f,-3.0f))));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
