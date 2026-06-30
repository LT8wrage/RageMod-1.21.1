package net.lt8wrage.ragemod.block.custom;

import com.mojang.serialization.MapCodec;
import net.lt8wrage.ragemod.block.entity.UpgradeModifierBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class UpgradeModifierBlock extends BaseEntityBlock {
    public static final MapCodec<UpgradeModifierBlock> CODEC = simpleCodec(UpgradeModifierBlock::new);

    public UpgradeModifierBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new UpgradeModifierBlockEntity(blockPos, blockState);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state,
                                              Level level, BlockPos pos,
                                              Player player, InteractionHand hand,
                                              BlockHitResult hitResult) {

        if (level.getBlockEntity(pos) instanceof UpgradeModifierBlockEntity upgradeModifierBlockEntity) {
            if (!level.isClientSide()) {
                ((ServerPlayer) player).openMenu(
                        new SimpleMenuProvider(
                                upgradeModifierBlockEntity,
                                Component.literal("upgrade_modifier")
                        ),
                        pos
                );
            }
            return ItemInteractionResult.SUCCESS;
        }

        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }
}
