package com.pouffydev.krystalsmaterialcompats.foundation.creative;

import com.google.common.collect.Lists;
import com.pouffydev.krystalsmaterialcompats.KMCItems;
import com.pouffydev.krystalsmaterialcompats.MaterialCompats;
import com.pouffydev.krystalsmaterialcompats.foundation.data.AllTags;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.event.ClientPlayerNetworkEvent;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.tags.ITagManager;
import org.lwjgl.glfw.GLFW;

import java.util.*;

/**
 * Credit to MrCrayfish for the following code
 * <p>
 * The filtering feature for the creative inventory uses code from MrCrayfish's
 * Furniture Mod.
 */
public class CreativeScreenEvents {
    private static final ResourceLocation ICONS = new ResourceLocation(MaterialCompats.ID, "textures/gui/icons.png");
    private static int startIndex;
    
    private List<TagFilter> filters;
    private List<TagButton> buttons;
    private Button btnScrollUp;
    private Button btnScrollDown;
    private Button btnEnableAll;
    private Button btnDisableAll;
    private boolean viewingFurnitureTab;
    private int guiCenterX = 0;
    private int guiCenterY = 0;
    
    @SubscribeEvent
    public void onPlayerLogout(ClientPlayerNetworkEvent.LoggedOutEvent event)
    {
        this.filters = null;
    }
    
    @SubscribeEvent
    public void onScreenInit(ScreenEvent.InitScreenEvent.Post event)
    {
        if(event.getScreen() instanceof CreativeModeInventoryScreen creativeScreen)
        {
            if(this.filters == null)
            {
                this.compileItems();
            }
            
            this.viewingFurnitureTab = false;
            this.guiCenterX = creativeScreen.getGuiLeft();
            this.guiCenterY = creativeScreen.getGuiTop();
            this.buttons = new ArrayList<>();
            
            event.addListener(this.btnScrollUp = new IconButton(this.guiCenterX - 22, this.guiCenterY - 12, new TranslatableComponent("gui.button.krystalsmaterialcompats.scroll_filters_up"), button -> {
                if(startIndex > 0) startIndex--;
                this.updateTagButtons();
            }, ICONS, 64, 0));
            
            event.addListener(this.btnScrollDown = new IconButton(this.guiCenterX - 22, this.guiCenterY + 127, new TranslatableComponent("gui.button.krystalsmaterialcompats.scroll_filters_down"), button -> {
                if(startIndex <= filters.size() - 4 - 1) startIndex++;
                this.updateTagButtons();
            }, ICONS, 80, 0));
            
            event.addListener(this.btnEnableAll = new IconButton(this.guiCenterX - 50, this.guiCenterY + 10, new TranslatableComponent("gui.button.krystalsmaterialcompats.enable_filters"), button -> {
                this.filters.forEach(filters -> filters.setEnabled(true));
                this.buttons.forEach(TagButton::updateState);
                Screen screen = Minecraft.getInstance().screen;
                if(screen instanceof CreativeModeInventoryScreen)
                {
                    this.updateItems((CreativeModeInventoryScreen) screen);
                }
            }, ICONS, 96, 0));
            
            event.addListener(this.btnDisableAll = new IconButton(this.guiCenterX - 50, this.guiCenterY + 32, new TranslatableComponent("gui.button.krystalsmaterialcompats.disable_filters"), button -> {
                this.filters.forEach(filters -> filters.setEnabled(false));
                this.buttons.forEach(TagButton::updateState);
                Screen screen = Minecraft.getInstance().screen;
                if(screen instanceof CreativeModeInventoryScreen)
                {
                    this.updateItems((CreativeModeInventoryScreen) screen);
                }
            }, ICONS, 112, 0));
            
            this.btnScrollUp.visible = false;
            this.btnScrollDown.visible = false;
            this.btnEnableAll.visible = false;
            this.btnDisableAll.visible = false;
            
            this.updateTagButtons();
            
            if(creativeScreen.getSelectedTab() == MaterialCompats.itemGroup.getId())
            {
                this.btnScrollUp.visible = true;
                this.btnScrollDown.visible = true;
                this.btnEnableAll.visible = true;
                this.btnDisableAll.visible = true;
                this.viewingFurnitureTab = true;
                this.buttons.forEach(button -> button.visible = true);
                this.updateItems(creativeScreen);
            }
        }
    }
    
    @SubscribeEvent
    public void onScreenClick(ScreenEvent.MouseClickedEvent.Pre event)
    {
        if(event.getButton() != GLFW.GLFW_MOUSE_BUTTON_LEFT)
            return;
        
        if(event.getScreen() instanceof CreativeModeInventoryScreen)
        {
            for(Button button : this.buttons)
            {
                if(button.isMouseOver(event.getMouseX(), event.getMouseY()))
                {
                    if(button.mouseClicked(event.getMouseX(), event.getMouseY(), event.getButton()))
                    {
                        return;
                    }
                }
            }
        }
    }
    
    @SubscribeEvent
    public void onScreenDrawPre(ScreenEvent.DrawScreenEvent.Pre event)
    {
        if(event.getScreen() instanceof CreativeModeInventoryScreen creativeScreen)
        {
            if(creativeScreen.getSelectedTab() == MaterialCompats.itemGroup.getId())
            {
                if(!this.viewingFurnitureTab)
                {
                    this.updateItems(creativeScreen);
                    this.viewingFurnitureTab = true;
                }
            }
            else
            {
                this.viewingFurnitureTab = false;
            }
        }
    }
    
    @SubscribeEvent
    public void onScreenDrawPost(ScreenEvent.DrawScreenEvent.Post event)
    {
        if(event.getScreen() instanceof CreativeModeInventoryScreen creativeScreen)
        {
            this.guiCenterX = creativeScreen.getGuiLeft();
            this.guiCenterY = creativeScreen.getGuiTop();
            
            if(creativeScreen.getSelectedTab() == MaterialCompats.itemGroup.getId())
            {
                this.btnScrollUp.visible = true;
                this.btnScrollDown.visible = true;
                this.btnEnableAll.visible = true;
                this.btnDisableAll.visible = true;
                this.buttons.forEach(button -> button.visible = true);
                
                /* Render buttons */
                this.buttons.forEach(button ->
                {
                    button.render(event.getPoseStack(), event.getMouseX(), event.getMouseY(), event.getPartialTicks());
                });
                
                /* Render tooltips after so it renders above buttons */
                this.buttons.forEach(button ->
                {
                    if(button.isMouseOver(event.getMouseX(), event.getMouseY()))
                    {
                        creativeScreen.renderTooltip(event.getPoseStack(), button.getCategory().getName(), event.getMouseX(), event.getMouseY());
                    }
                });
                
                if(this.btnEnableAll.isMouseOver(event.getMouseX(), event.getMouseY()))
                {
                    creativeScreen.renderTooltip(event.getPoseStack(), this.btnEnableAll.getMessage(), event.getMouseX(), event.getMouseY());
                }
                
                if(this.btnDisableAll.isMouseOver(event.getMouseX(), event.getMouseY()))
                {
                    creativeScreen.renderTooltip(event.getPoseStack(), this.btnDisableAll.getMessage(), event.getMouseX(), event.getMouseY());
                }
            }
            else
            {
                this.btnScrollUp.visible = false;
                this.btnScrollDown.visible = false;
                this.btnEnableAll.visible = false;
                this.btnDisableAll.visible = false;
                this.buttons.forEach(button -> button.visible = false);
            }
        }
    }
    
    private void updateTagButtons()
    {
        final Button.OnPress onPress = button ->
        {
            Screen screen = Minecraft.getInstance().screen;
            if(screen instanceof CreativeModeInventoryScreen creativeScreen)
            {
                this.updateItems(creativeScreen);
            }
        };
        this.buttons.clear();
        for(int i = startIndex; i < startIndex + 4 && i < this.filters.size(); i++)
        {
            TagButton button = new TagButton(this.guiCenterX - 28, this.guiCenterY + 29 * (i - startIndex) + 10, this.filters.get(i), onPress);
            this.buttons.add(button);
        }
        this.btnScrollUp.active = startIndex > 0;
        this.btnScrollDown.active = startIndex <= this.filters.size() - 4 - 1;
    }
    
    private void updateItems(CreativeModeInventoryScreen screen)
    {
        CreativeModeInventoryScreen.ItemPickerMenu menu = screen.getMenu();
        LinkedHashSet<Item> categorisedItems = new LinkedHashSet<>();
        for(TagFilter filter : this.filters)
        {
            if(filter.isEnabled())
            {
                categorisedItems.addAll(filter.getItems());
            }
        }
        
        NonNullList<ItemStack> newItems = NonNullList.create();
        for(Item item : categorisedItems)
        {
            item.fillItemCategory(MaterialCompats.itemGroup, newItems);
        }
        
        menu.items.clear();
        menu.items.addAll(newItems);
        menu.items.sort(Comparator.comparingInt(o -> Item.getId(o.getItem())));
        menu.scrollTo(0);
    }
    
    
    private void compileItems()
    {
        ITagManager<Item> tagManager = ForgeRegistries.ITEMS.tags();
        TagFilter[] filters = new TagFilter[] {
                new TagFilter(AllTags.AllCompatItemTags.aluminum.tag, new ItemStack(KMCItems.sturdy_aluminum_sheet.get())),
                new TagFilter(AllTags.AllCompatItemTags.amethyst_bronze.tag, new ItemStack(KMCItems.sturdy_amethyst_bronze_sheet.get())),
                new TagFilter(AllTags.AllCompatItemTags.arcane_gold.tag, new ItemStack(KMCItems.sturdy_arcane_gold_sheet.get())),
                new TagFilter(AllTags.AllCompatItemTags.brass.tag, new ItemStack(KMCItems.sturdy_brass_sheet.get())),
                new TagFilter(AllTags.AllCompatItemTags.cobalt.tag, new ItemStack(KMCItems.sturdy_cobalt_sheet.get())),
                new TagFilter(AllTags.AllCompatItemTags.constantan.tag, new ItemStack(KMCItems.sturdy_constantan_sheet.get())),
                new TagFilter(AllTags.AllCompatItemTags.electrum.tag, new ItemStack(KMCItems.sturdy_electrum_sheet.get())),
                new TagFilter(AllTags.AllCompatItemTags.enderium.tag, new ItemStack(KMCItems.sturdy_enderium_sheet.get())),
                new TagFilter(AllTags.AllCompatItemTags.hepatizon.tag, new ItemStack(KMCItems.sturdy_hepatizon_sheet.get())),
                new TagFilter(AllTags.AllCompatItemTags.invar.tag, new ItemStack(KMCItems.sturdy_invar_sheet.get())),
                new TagFilter(AllTags.AllCompatItemTags.lead.tag, new ItemStack(KMCItems.sturdy_lead_sheet.get())),
                new TagFilter(AllTags.AllCompatItemTags.lumium.tag, new ItemStack(KMCItems.sturdy_lumium_sheet.get())),
                new TagFilter(AllTags.AllCompatItemTags.manyullyn.tag, new ItemStack(KMCItems.sturdy_manyullyn_sheet.get())),
                new TagFilter(AllTags.AllCompatItemTags.nickel.tag, new ItemStack(KMCItems.sturdy_nickel_sheet.get())),
                new TagFilter(AllTags.AllCompatItemTags.osmium.tag, new ItemStack(KMCItems.sturdy_osmium_sheet.get())),
                new TagFilter(AllTags.AllCompatItemTags.pendorite.tag, new ItemStack(KMCItems.sturdy_pendorite_sheet.get())),
                new TagFilter(AllTags.AllCompatItemTags.queens_slime.tag, new ItemStack(KMCItems.sturdy_queens_slime_sheet.get())),
                new TagFilter(AllTags.AllCompatItemTags.refined_glowstone.tag, new ItemStack(KMCItems.sturdy_refined_glowstone_sheet.get())),
                new TagFilter(AllTags.AllCompatItemTags.refined_obsidian.tag, new ItemStack(KMCItems.sturdy_refined_obsidian_sheet.get())),
                new TagFilter(AllTags.AllCompatItemTags.rose_gold.tag, new ItemStack(KMCItems.sturdy_rose_gold_sheet.get())),
                new TagFilter(AllTags.AllCompatItemTags.signalum.tag, new ItemStack(KMCItems.sturdy_signalum_sheet.get())),
                new TagFilter(AllTags.AllCompatItemTags.silver.tag, new ItemStack(KMCItems.sturdy_silver_sheet.get())),
                new TagFilter(AllTags.AllCompatItemTags.slimesteel.tag, new ItemStack(KMCItems.sturdy_slimesteel_sheet.get())),
                new TagFilter(AllTags.AllCompatItemTags.uranium.tag, new ItemStack(KMCItems.sturdy_uranium_sheet.get())),
                new TagFilter(AllTags.AllCompatItemTags.zinc.tag, new ItemStack(KMCItems.sturdy_zinc_sheet.get())),
        };
        
        ForgeRegistries.ITEMS.getValues().stream()
                .filter(item -> item.getItemCategory() == MaterialCompats.itemGroup)
                .filter(item -> item.getRegistryName().getNamespace().equals(MaterialCompats.ID))
                .forEach(item ->
                {
                    item.builtInRegistryHolder().tags().forEach(tagKey ->
                    {
                        for(TagFilter filter : filters)
                        {
                            if(tagKey == filter.getTag())
                            {
                                filter.add(item);
                            }
                        }
                    });
                });
        
        this.filters = new ArrayList<>();
        this.filters.addAll(Arrays.asList(filters));
    }
    
    /**
     * Author: MrCrayfish
     */
    public static class TagFilter
    {
        public boolean shouldHide(TagKey<Item> tag) {
            ITagManager<Item> tagManager = ForgeRegistries.ITEMS.tags();
            return !tagManager.isKnownTagName(tag) || tagManager.getTag(tag).isEmpty();
        }
        private final List<Item> items = Lists.newArrayList();
        private final TagKey<Item> tag;
        private final TranslatableComponent name;
        private final ItemStack icon;
        private boolean enabled = true;
        
        public TagFilter(TagKey<Item> tag, ItemStack icon)
        {
            this.tag = tag;
            this.name = new TranslatableComponent(String.format("gui.tag_filter.%s.%s", tag.location().getNamespace(), tag.location().getPath().replace("/", ".")));
            this.icon = icon;
        }
        
        public TagKey<Item> getTag()
        {
            return tag;
        }
        
        public ItemStack getIcon()
        {
            return this.icon;
        }
        
        public TranslatableComponent getName()
        {
            return this.name;
        }
        
        public void setEnabled(boolean enabled)
        {
            this.enabled = enabled;
        }
        
        public boolean isEnabled()
        {
            if (shouldHide(tag)) {
                return false;
            }
            return this.enabled;
        }
        
        public void add(Item item)
        {
            this.items.add(item);
        }
        
        public void add(Block block)
        {
            this.items.add(Item.byBlock(block));
        }
        
        public List<Item> getItems()
        {
            return this.items;
        }
    }
}
