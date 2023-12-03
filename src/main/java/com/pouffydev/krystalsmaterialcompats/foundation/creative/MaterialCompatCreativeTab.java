package com.pouffydev.krystalsmaterialcompats.foundation.creative;

import com.pouffydev.krystalsmaterialcompats.KMCItems;
import com.pouffydev.krystalsmaterialcompats.MaterialCompats;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nonnull;

public class MaterialCompatCreativeTab extends CreativeModeTab {
    private static final String PATH = "textures/gui/container/creative_inventory/";
    public MaterialCompatCreativeTab(String label) {
        super(label);
        this.setBackgroundImage(new ResourceLocation(MaterialCompats.ID, PATH + "tab_material_compats.png"));
        this.hideTitle();
    }
    
    @Override
    public ItemStack makeIcon() {
        return new ItemStack(KMCItems.enderium_sheet.get());
    }
    
    @Nonnull
    @Override
    public ResourceLocation getTabsImage() {
        return new ResourceLocation(MaterialCompats.ID, PATH + "material_compat_tabs.png");
    }
}
