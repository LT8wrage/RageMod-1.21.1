package net.lt8wrage.ragemod.item;

import net.lt8wrage.ragemod.RageMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(RageMod.MODID);

    public static final DeferredItem<Item> ENDERITE_SCRAP = ITEMS.register("enderite_scrap", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ENDERITE_INGOT = ITEMS.register("enderite_ingot", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
