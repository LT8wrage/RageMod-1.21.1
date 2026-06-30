package net.lt8wrage.ragemod.screen.custom;

import com.mojang.blaze3d.systems.RenderSystem;
import net.lt8wrage.ragemod.RageMod;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class UpgradeModifierScreen extends AbstractContainerScreen<UpgradeModifierMenu> {
    private static final ResourceLocation GUI_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(RageMod.MODID, "textures/gui/upgrade_modifier/upgrade_modifier_gui.png");

    public UpgradeModifierScreen(UpgradeModifierMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);

        this.imageWidth = 183;
        this.imageHeight = 190;

        this.inventoryLabelY += 13;

        this.titleLabelX = 8;
        this.titleLabelY = 4;
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float v, int i, int i1) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F,1.0F,1.0F,1.0F);
        RenderSystem.setShaderTexture(0, GUI_TEXTURE);

        int x = (width - imageWidth) /2 ;
        int y = (height - imageHeight) /2 ;

        guiGraphics.blit(
                GUI_TEXTURE,
                x, y,
                0, 0,
                183, 190,
                183, 190
        );;
    }
}
