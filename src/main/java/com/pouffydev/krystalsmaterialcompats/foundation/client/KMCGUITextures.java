package com.pouffydev.krystalsmaterialcompats.foundation.client;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.pouffydev.krystalsmaterialcompats.MaterialCompats;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public enum KMCGUITextures implements ScreenElement {
    BUTTON("widgets", 18, 18),
    BUTTON_HOVER("widgets", 18, 0, 18, 18),
    BUTTON_DOWN("widgets", 36, 0, 18, 18),
    ;
    
    public static final int FONT_COLOR = 0x575F7A;
    
    public final ResourceLocation location;
    public int width, height;
    public int startX, startY;
    
    private KMCGUITextures(String location, int width, int height) {
        this(location, 0, 0, width, height);
    }
    
    private KMCGUITextures(int startX, int startY) {
        this("icons", startX * 16, startY * 16, 16, 16);
    }
    
    private KMCGUITextures(String location, int startX, int startY, int width, int height) {
        this(MaterialCompats.ID, location, startX, startY, width, height);
    }
    
    private KMCGUITextures(String namespace, String location, int startX, int startY, int width, int height) {
        this.location = new ResourceLocation(namespace, "textures/gui/" + location + ".png");
        this.width = width;
        this.height = height;
        this.startX = startX;
        this.startY = startY;
    }
    
    @OnlyIn(Dist.CLIENT)
    public void bind() {
        RenderSystem.setShaderTexture(0, location);
    }
    
    @OnlyIn(Dist.CLIENT)
    @Override
    public void render(PoseStack ms, int x, int y) {
        bind();
        GuiComponent.blit(ms, x, y, 0, startX, startY, width, height, 256, 256);
    }
    
    @OnlyIn(Dist.CLIENT)
    public void render(PoseStack ms, int x, int y, GuiComponent component) {
        bind();
        component.blit(ms, x, y, startX, startY, width, height);
    }
}
