package com.pouffydev.krystalsmaterialcompats.foundation.creative;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.pouffydev.krystalsmaterialcompats.foundation.client.KMCGUITextures;
import com.pouffydev.krystalsmaterialcompats.foundation.client.ScreenElement;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
/**
 * Credit to MrCrayfish for the following code
 * <p>
 * The filtering feature for the creative inventory uses code from MrCrayfish's
 * Furniture Mod.
 */
public class IconButton extends Button
{
    private ResourceLocation iconResource;
    private int iconU;
    private int iconV;
    
    public IconButton(int x, int y, Component message, OnPress onPress, ResourceLocation iconResource, int iconU, int iconV)
    {
        super(x, y, 20, 20, message, onPress);
        this.iconResource = iconResource;
        this.iconU = iconU;
        this.iconV = iconV;
    }
    
    public void setIcon(ResourceLocation iconResource, int iconU, int iconV)
    {
        this.iconResource = iconResource;
        this.iconU = iconU;
        this.iconV = iconV;
    }
    
    @Override
    public void renderButton(PoseStack poseStack, int mouseX, int mouseY, float partialTicks)
    {
        RenderSystem.setShader(GameRenderer::getPositionColorTexShader);
        if (visible) {
            KMCGUITextures button = !active ? KMCGUITextures.BUTTON_DOWN
                    : isHoveredOrFocused() ? KMCGUITextures.BUTTON_HOVER : KMCGUITextures.BUTTON;
            
            isHovered = mouseX >= x && mouseY >= y && mouseX < x + width && mouseY < y + height;
            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            drawBg(poseStack, button);
        }
        RenderSystem.enableBlend();
        RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        RenderSystem.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
        int offset = this.getYImage(this.isHoveredOrFocused());
        this.blit(poseStack, this.x, this.y, 0, 46 + offset * 20, this.width / 2, this.height);
        this.blit(poseStack, this.x + this.width / 2, this.y, 200 - this.width / 2, 46 + offset * 20, this.width / 2, this.height);
        if(!this.active)
        {
            RenderSystem.setShaderColor(0.5F, 0.5F, 0.5F, 1.0F);
        }
        RenderSystem.setShaderTexture(0, this.iconResource);
        this.blit(poseStack, this.x + 1, this.y + 1, this.iconU, this.iconV, 16, 16);
    }
    
    protected void drawBg(PoseStack matrixStack, KMCGUITextures button) {
        KMCGUITextures.BUTTON.bind();
        blit(matrixStack, x, y, button.startX, button.startY, button.width, button.height);
    }
}
