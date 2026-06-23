package net.lt8wrage.ragemod.item;

import net.lt8wrage.ragemod.RageMod;
import net.lt8wrage.ragemod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RageMod.MODID);

    public static final Supplier<CreativeModeTab> ENDERITE = CREATIVE_MODE_TAB.register("enderite_tab",
            ()-> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ENDERITE_SCRAP.get()))
                    .title(Component.translatable("creativetab.ragemod.enderite"))
                    .displayItems((ItemDisplayParameters, output) -> {
                        //normal items
                        output.accept(ModItems.ENDERITE_INGOT);
                        output.accept(ModItems.ENDERITE_SCRAP);
                        output.accept(ModItems.GOLDEN_CORE);

                        //food
                        output.accept(ModItems.CARROT_OF_DOOM_AND_DESPAIR);

                        //tools
                        output.accept(ModItems.ENDERITE_SWORD);
                        output.accept(ModItems.ENDERITE_PICKAXE);
                        output.accept(ModItems.ENDERITE_AXE);
                        output.accept(ModItems.ENDERITE_SHOVEL);
                        output.accept(ModItems.ENDERITE_HOE);

                        //blocks
                        output.accept(ModBlocks.ENDERITE_BLOCK);
                        output.accept(ModBlocks.ENDERITE_DEBRIS);

                    }).build());
    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
