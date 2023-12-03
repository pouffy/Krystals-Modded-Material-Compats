package com.pouffydev.krystalsmaterialcompats.content.item;

import com.pouffydev.krystal_core.foundation.data.lang.KrystalCoreLang;
import com.pouffydev.krystalsmaterialcompats.MaterialCompats;
import net.minecraft.ChatFormatting;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.tags.ITagManager;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;

public class MissingTagNotifier extends Item {
    private TagKey<Item> tag;
    public MissingTagNotifier(Properties properties, TagKey<Item> tag) {
        super(properties);
        this.tag = tag;
    }
    
    @Override
    public void fillItemCategory(CreativeModeTab tab, NonNullList<ItemStack> list) {
        if (!shouldHide())
            super.fillItemCategory(tab, list);
    }
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int p_41407_, boolean p_41408_) {
        //Always remove the item from the inventory
        int i = stack.getCount();
        stack.shrink(i);
    }
    public boolean shouldHide() {
        ITagManager<Item> tagManager = ForgeRegistries.ITEMS.tags();
        return tagManager.isKnownTagName(tag) || !tagManager.getTag(tag).isEmpty();
    }
    
    public String getTagID () {
        return tag.location().toString();
    }
    
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        if (!shouldHide()) {
            tooltip.add(KrystalCoreLang.translateDirect(MaterialCompats.ID, "item.tag_notifier", getTagID()).withStyle(Style.EMPTY.withColor(0x5d460a)));
        }
        
    }
}
