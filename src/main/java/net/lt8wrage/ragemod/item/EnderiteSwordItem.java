package net.lt8wrage.ragemod.item;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.projectile.ThrownEnderpearl;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

public class EnderiteSwordItem extends SwordItem {

    public EnderiteSwordItem(Tier tier, Item.Properties properties) {
        super(tier, properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {

        ItemStack sword = player.getItemInHand(hand);

        if (!player.getInventory().contains(new ItemStack(Items.ENDER_PEARL))) {
            return InteractionResultHolder.fail(sword);
        }

        if (!player.getAbilities().instabuild) {

            boolean hasEnderitePearl = false;

            for (ItemStack stack : player.getInventory().items) {
                if (stack.is(ModItems.ENDERITE_PEARL.get())) {
                    hasEnderitePearl = true;
                    break;
                }
            }

            if (!hasEnderitePearl) {
                for (ItemStack stack : player.getInventory().items) {
                    if (stack.is(Items.ENDER_PEARL)) {
                        stack.shrink(1);
                        break;
                    }
                }
            }
        }

            ThrownEnderpearl pearl = new ThrownEnderpearl(level, player);

            pearl.setItem(new ItemStack(Items.ENDER_PEARL));

            pearl.shootFromRotation(
                    player,
                    player.getXRot(),
                    player.getYRot(),
                    0.0F,
                    1.5F,
                    1.0F
            );

            level.addFreshEntity(pearl);

            player.getCooldowns().addCooldown(this, 20); // 1 seconde

            level.playSound(
                    null,
                    player.getX(),
                    player.getY(),
                    player.getZ(),
                    SoundEvents.ENDER_PEARL_THROW,
                    player.getSoundSource(),
                    0.5F,
                    1.0F
            );


        return InteractionResultHolder.success(sword);
    }
}