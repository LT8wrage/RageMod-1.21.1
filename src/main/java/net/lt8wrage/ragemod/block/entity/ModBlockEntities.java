package net.lt8wrage.ragemod.block.entity;

import net.lt8wrage.ragemod.RageMod;
import net.lt8wrage.ragemod.block.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, RageMod.MODID);

    public static final Supplier<BlockEntityType<UpgradeModifierBlockEntity>> UPGRADE_MODIFIER_BE =
            BLOCK_ENTITIES.register("upgrade_modifier_be", ()-> BlockEntityType.Builder.of(
                    UpgradeModifierBlockEntity::new, ModBlocks.UPGRADE_MODIFIER.get()).build(null));

    public static void register (IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
