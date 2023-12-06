package com.pouffydev.krystalsmaterialcompats.foundation.data;

import com.pouffydev.krystal_core.foundation.KrystalCoreTags;
import com.pouffydev.krystal_core.foundation.data.lang.KrystalCoreLang;
import com.pouffydev.krystalsmaterialcompats.MaterialCompats;
import com.pouffydev.krystalsmaterialcompats.foundation.CompatMetals;
import com.pouffydev.krystalsmaterialcompats.foundation.Mods;
import com.pouffydev.krystalsmaterialcompats.foundation.data.tag.TagGen;
import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.builders.ItemBuilder;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.registries.ForgeRegistries;

import static com.pouffydev.krystalsmaterialcompats.foundation.data.AllTags.NameSpace.MOD;

public class AllTags {
    static String al = CompatMetals.aluminum.getName();
    static String ab = CompatMetals.amethyst_bronze.getName();
    static String ag = CompatMetals.arcane_gold.getName();
    static String br = CompatMetals.brass.getName();
    static String cb = CompatMetals.cobalt.getName();
    static String co = CompatMetals.constantan.getName();
    static String el = CompatMetals.electrum.getName();
    static String en = CompatMetals.enderium.getName();
    static String he = CompatMetals.hepatizon.getName();
    static String iv = CompatMetals.invar.getName();
    static String le = CompatMetals.lead.getName();
    static String lu = CompatMetals.lumium.getName();
    static String ma = CompatMetals.manyullyn.getName();
    static String ni = CompatMetals.nickel.getName();
    static String os = CompatMetals.osmium.getName();
    static String pd = CompatMetals.pendorite.getName();
    static String qs = CompatMetals.queens_slime.getName();
    static String rgs = CompatMetals.refined_glowstone.getName();
    static String rb = CompatMetals.refined_obsidian.getName();
    static String rg = CompatMetals.rose_gold.getName();
    static String si = CompatMetals.signalum.getName();
    static String sil = CompatMetals.silver.getName();
    static String sl = CompatMetals.slimesteel.getName();
    static String ur = CompatMetals.uranium.getName();
    static String zn = CompatMetals.zinc.getName();
    
    public static TagKey<Block> forgeBlockTag(String path) {
        return KrystalCoreTags.forgeTag(ForgeRegistries.BLOCKS, path);
    }
    
    
    public static TagKey<Item> forgeItemTag(String path) {
        return KrystalCoreTags.forgeTag(ForgeRegistries.ITEMS, path);
    }
    
    public static TagKey<Fluid> forgeFluidTag(String path) {
        return KrystalCoreTags.forgeTag(ForgeRegistries.FLUIDS, path);
    }
    
    @Deprecated(forRemoval = true)
    public static <T extends Block, P> NonNullFunction<BlockBuilder<T, P>, BlockBuilder<T, P>> axeOrPickaxe() {
        return TagGen.axeOrPickaxe();
    }
    
    @Deprecated(forRemoval = true)
    public static <T extends Block, P> NonNullFunction<BlockBuilder<T, P>, BlockBuilder<T, P>> axeOnly() {
        return TagGen.axeOnly();
    }
    
    @Deprecated(forRemoval = true)
    public static <T extends Block, P> NonNullFunction<BlockBuilder<T, P>, BlockBuilder<T, P>> pickaxeOnly() {
        return TagGen.pickaxeOnly();
    }
    
    @Deprecated(forRemoval = true)
    public static <T extends Block, P> NonNullFunction<BlockBuilder<T, P>, ItemBuilder<BlockItem, BlockBuilder<T, P>>> tagBlockAndItem(
            String... path) {
        return TagGen.tagBlockAndItem(path);
    }
    public enum NameSpace {
        MOD(MaterialCompats.ID, false, true),
        FORGE("forge"),
        TIC("tconstruct"),
        CREATE(Mods.create.getId())
        
        ;
        
        public final String id;
        public final boolean optionalDefault;
        public final boolean alwaysDatagenDefault;
        
        NameSpace(String id) {
            this(id, true, false);
        }
        
        NameSpace(String id, boolean optionalDefault, boolean alwaysDatagenDefault) {
            this.id = id;
            this.optionalDefault = optionalDefault;
            this.alwaysDatagenDefault = alwaysDatagenDefault;
        }
    }
    
    public static enum AllCompatItemTags {
        //Item tag for every supported material
        aluminum(MOD,"category/" + al),
        amethyst_bronze(MOD,"category/" + ab),
        arcane_gold(MOD,"category/" + ag),
        brass(MOD,"category/" + br),
        cobalt(MOD,"category/" + cb),
        constantan(MOD,"category/" + co),
        electrum(MOD,"category/" + el),
        enderium(MOD,"category/" + en),
        hepatizon(MOD,"category/" + he),
        invar(MOD,"category/" + iv),
        lead(MOD,"category/" + le),
        lumium(MOD,"category/" + lu),
        manyullyn(MOD,"category/" + ma),
        nickel(MOD,"category/" + ni),
        osmium(MOD,"category/" + os),
        pendorite(MOD,"category/" + pd),
        queens_slime(MOD,"category/" + qs),
        refined_glowstone(MOD,"category/" + rgs),
        refined_obsidian(MOD,"category/" + rb),
        rose_gold(MOD,"category/" + rg),
        signalum(MOD,"category/" + si),
        silver(MOD,"category/" + sil),
        slimesteel(MOD,"category/" + sl),
        uranium(MOD,"category/" + ur),
        zinc(MOD,"category/" + zn),
        
        
        ;
        
        
        public final TagKey<Item> tag;
        public final boolean alwaysDatagen;
        
        private AllCompatItemTags() {
            this(MOD);
        }
        
        private AllCompatItemTags(NameSpace namespace) {
            this(namespace, namespace.optionalDefault, namespace.alwaysDatagenDefault);
        }
        
        private AllCompatItemTags(NameSpace namespace, String path) {
            this(namespace, path, namespace.optionalDefault, namespace.alwaysDatagenDefault);
        }
        
        private AllCompatItemTags(NameSpace namespace, boolean optional, boolean alwaysDatagen) {
            this(namespace, (String)null, optional, alwaysDatagen);
        }
        
        private AllCompatItemTags(NameSpace namespace, String path, boolean optional, boolean alwaysDatagen) {
            ResourceLocation id = new ResourceLocation(namespace.id, path == null ? KrystalCoreLang.asId(this.name()) : path);
            if (optional) {
                this.tag = KrystalCoreTags.optionalTag(ForgeRegistries.ITEMS, id);
            } else {
                this.tag = ItemTags.create(id);
            }
            
            this.alwaysDatagen = alwaysDatagen;
        }
        
        public boolean matches(Item item) {
            return item.builtInRegistryHolder().is(this.tag);
        }
        
        public boolean matches(ItemStack stack) {
            return stack.is(this.tag);
        }
        
        private static void init() {
        }
    }
}
