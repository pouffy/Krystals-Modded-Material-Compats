package com.pouffydev.krystalsmaterialcompats;

import com.pouffydev.krystalsmaterialcompats.content.item.TagDependentIngredientItem;
import com.pouffydev.krystalsmaterialcompats.foundation.CompatMetals;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.level.ItemLike;

import static com.pouffydev.krystalsmaterialcompats.foundation.KrystalsRegistryHelpers.*;

@SuppressWarnings("unused")
public class KMCItems {
    /**
     * Item Registry Entries for compat items
     */
    static CompatMetals al = CompatMetals.aluminum;
    static CompatMetals ab = CompatMetals.amethyst_bronze;
    static CompatMetals ag = CompatMetals.arcane_gold;
    static CompatMetals br = CompatMetals.brass;
    static CompatMetals cb = CompatMetals.cobalt;
    static CompatMetals co = CompatMetals.constantan;
    static CompatMetals el = CompatMetals.electrum;
    static CompatMetals en = CompatMetals.enderium;
    static CompatMetals he = CompatMetals.hepatizon;
    static CompatMetals iv = CompatMetals.invar;
    static CompatMetals le = CompatMetals.lead;
    static CompatMetals lu = CompatMetals.lumium;
    static CompatMetals ma = CompatMetals.manyullyn;
    static CompatMetals ni = CompatMetals.nickel;
    static CompatMetals os = CompatMetals.osmium;
    static CompatMetals pd = CompatMetals.pendorite;
    static CompatMetals qs = CompatMetals.queens_slime;
    static CompatMetals rgs = CompatMetals.refined_glowstone;
    static CompatMetals rb = CompatMetals.refined_obsidian;
    static CompatMetals rg = CompatMetals.rose_gold;
    static CompatMetals si = CompatMetals.signalum;
    static CompatMetals sil = CompatMetals.silver;
    static CompatMetals sl = CompatMetals.slimesteel;
    static CompatMetals ur = CompatMetals.uranium;
    static CompatMetals zn = CompatMetals.zinc;
    
    //compatSheets
    public static final ItemEntry<TagDependentIngredientItem>
            aluminum_sheet = compatSheet(al),
            amethyst_bronze_sheet = compatSheet(ab),
            arcane_gold_sheet = compatSheet(ag),
            cobalt_sheet = compatSheet(cb),
            constantan_sheet = compatSheet(co),
            electrum_sheet = compatSheet(el),
            enderium_sheet = compatSheet(en),
            hepatizon_sheet = compatSheet(he),
            invar_sheet = compatSheet(iv),
            lead_sheet = compatSheet(le),
            lumium_sheet = compatSheet(lu),
            manyullyn_sheet = compatSheet(ma),
            nickel_sheet = compatSheet(ni),
            osmium_sheet = compatSheet(os),
            pendorite_sheet = compatSheet(pd),
            queens_slime_sheet = compatSheet(qs),
            refined_glowstone_sheet = compatSheet(rgs),
            refined_obsidian_sheet = compatSheet(rb),
            rose_gold_sheet = compatSheet(rg),
            signalum_sheet = compatSheet(si),
            silver_sheet = compatSheet(sil),
            slimesteel_sheet = compatSheet(sl),
            uranium_sheet = compatSheet(ur)
                    ;
    
    //compatRods
    public static final ItemEntry<TagDependentIngredientItem>
            aluminum_rod = compatMetalRod(al),
            amethyst_bronze_rod = compatMetalRod(ab),
            arcane_gold_rod = compatMetalRod(ag),
            brass_rod = compatMetalRod(br),
            cobalt_rod = compatMetalRod(cb),
            constantan_rod = compatMetalRod(co),
            electrum_rod = compatMetalRod(el),
            enderium_rod = compatMetalRod(en),
            hepatizon_rod = compatMetalRod(he),
            invar_rod = compatMetalRod(iv),
            lead_rod = compatMetalRod(le),
            lumium_rod = compatMetalRod(lu),
            manyullyn_rod = compatMetalRod(ma),
            nickel_rod = compatMetalRod(ni),
            osmium_rod = compatMetalRod(os),
            pendorite_rod = compatMetalRod(pd),
            queens_slime_rod = compatMetalRod(qs),
            refined_glowstone_rod = compatMetalRod(rgs),
            refined_obsidian_rod = compatMetalRod(rb),
            rose_gold_rod = compatMetalRod(rg),
            signalum_rod = compatMetalRod(si),
            silver_rod = compatMetalRod(sil),
            slimesteel_rod = compatMetalRod(sl),
            uranium_rod = compatMetalRod(ur),
            zinc_rod = compatMetalRod(zn)
                    ;
    
    //compatUnprocessedSheets
    public static final ItemEntry<TagDependentIngredientItem>
            unprocessed_aluminum_sheet = compatUnprocessedSheet(al),
            unprocessed_amethyst_bronze_sheet = compatUnprocessedSheet(ab),
            unprocessed_arcane_gold_sheet = compatUnprocessedSheet(ag),
            unprocessed_brass_sheet = compatUnprocessedSheet(br),
            unprocessed_cobalt_sheet = compatUnprocessedSheet(cb),
            unprocessed_constantan_sheet = compatUnprocessedSheet(co),
            unprocessed_electrum_sheet = compatUnprocessedSheet(el),
            unprocessed_enderium_sheet = compatUnprocessedSheet(en),
            unprocessed_hepatizon_sheet = compatUnprocessedSheet(he),
            unprocessed_invar_sheet = compatUnprocessedSheet(iv),
            unprocessed_lead_sheet = compatUnprocessedSheet(le),
            unprocessed_lumium_sheet = compatUnprocessedSheet(lu),
            unprocessed_manyullyn_sheet = compatUnprocessedSheet(ma),
            unprocessed_nickel_sheet = compatUnprocessedSheet(ni),
            unprocessed_osmium_sheet = compatUnprocessedSheet(os),
            unprocessed_pendorite_sheet = compatUnprocessedSheet(pd),
            unprocessed_queens_slime_sheet = compatUnprocessedSheet(qs),
            unprocessed_refined_glowstone_sheet = compatUnprocessedSheet(rgs),
            unprocessed_refined_obsidian_sheet = compatUnprocessedSheet(rb),
            unprocessed_rose_gold_sheet = compatUnprocessedSheet(rg),
            unprocessed_signalum_sheet = compatUnprocessedSheet(si),
            unprocessed_silver_sheet = compatUnprocessedSheet(sil),
            unprocessed_slimesteel_sheet = compatUnprocessedSheet(sl),
            unprocessed_uranium_sheet = compatUnprocessedSheet(ur),
            unprocessed_zinc_sheet = compatUnprocessedSheet(zn)
                    ;
    
    //compatSturdySheets
    public static final ItemEntry<TagDependentIngredientItem>
            sturdy_aluminum_sheet = compatSturdySheet(al),
            sturdy_amethyst_bronze_sheet = compatSturdySheet(ab),
            sturdy_arcane_gold_sheet = compatSturdySheet(ag),
            sturdy_brass_sheet = compatSturdySheet(br),
            sturdy_cobalt_sheet = compatSturdySheet(cb),
            sturdy_constantan_sheet = compatSturdySheet(co),
            sturdy_electrum_sheet = compatSturdySheet(el),
            sturdy_enderium_sheet = compatSturdySheet(en),
            sturdy_hepatizon_sheet = compatSturdySheet(he),
            sturdy_invar_sheet = compatSturdySheet(iv),
            sturdy_lead_sheet = compatSturdySheet(le),
            sturdy_lumium_sheet = compatSturdySheet(lu),
            sturdy_manyullyn_sheet = compatSturdySheet(ma),
            sturdy_nickel_sheet = compatSturdySheet(ni),
            sturdy_osmium_sheet = compatSturdySheet(os),
            sturdy_pendorite_sheet = compatSturdySheet(pd),
            sturdy_queens_slime_sheet = compatSturdySheet(qs),
            sturdy_refined_glowstone_sheet = compatSturdySheet(rgs),
            sturdy_refined_obsidian_sheet = compatSturdySheet(rb),
            sturdy_rose_gold_sheet = compatSturdySheet(rg),
            sturdy_signalum_sheet = compatSturdySheet(si),
            sturdy_silver_sheet = compatSturdySheet(sil),
            sturdy_slimesteel_sheet = compatSturdySheet(sl),
            sturdy_uranium_sheet = compatSturdySheet(ur),
            sturdy_zinc_sheet = compatSturdySheet(zn)
            ;
    
    //compatReprocessedSheets
    public static final ItemEntry<TagDependentIngredientItem>
            reprocessed_aluminum_sheet = compatReprocessedSheet(al),
            reprocessed_amethyst_bronze_sheet = compatReprocessedSheet(ab),
            reprocessed_arcane_gold_sheet = compatReprocessedSheet(ag),
            reprocessed_brass_sheet = compatReprocessedSheet(br),
            reprocessed_cobalt_sheet = compatReprocessedSheet(cb),
            reprocessed_constantan_sheet = compatReprocessedSheet(co),
            reprocessed_electrum_sheet = compatReprocessedSheet(el),
            reprocessed_enderium_sheet = compatReprocessedSheet(en),
            reprocessed_hepatizon_sheet = compatReprocessedSheet(he),
            reprocessed_invar_sheet = compatReprocessedSheet(iv),
            reprocessed_lead_sheet = compatReprocessedSheet(le),
            reprocessed_lumium_sheet = compatReprocessedSheet(lu),
            reprocessed_manyullyn_sheet = compatReprocessedSheet(ma),
            reprocessed_nickel_sheet = compatReprocessedSheet(ni),
            reprocessed_osmium_sheet = compatReprocessedSheet(os),
            reprocessed_pendorite_sheet = compatReprocessedSheet(pd),
            reprocessed_queens_slime_sheet = compatReprocessedSheet(qs),
            reprocessed_refined_glowstone_sheet = compatReprocessedSheet(rgs),
            reprocessed_refined_obsidian_sheet = compatReprocessedSheet(rb),
            reprocessed_rose_gold_sheet = compatReprocessedSheet(rg),
            reprocessed_signalum_sheet = compatReprocessedSheet(si),
            reprocessed_silver_sheet = compatReprocessedSheet(sil),
            reprocessed_slimesteel_sheet = compatReprocessedSheet(sl),
            reprocessed_uranium_sheet = compatReprocessedSheet(ur),
            reprocessed_zinc_sheet = compatReprocessedSheet(zn)
                    ;
    
    //compatReinforcedSheets
    public static final ItemEntry<TagDependentIngredientItem>
            reinforced_aluminum_sheet = compatReinforcedSheet(al),
            reinforced_amethyst_bronze_sheet = compatReinforcedSheet(ab),
            reinforced_arcane_gold_sheet = compatReinforcedSheet(ag),
            reinforced_brass_sheet = compatReinforcedSheet(br),
            reinforced_cobalt_sheet = compatReinforcedSheet(cb),
            reinforced_constantan_sheet = compatReinforcedSheet(co),
            reinforced_electrum_sheet = compatReinforcedSheet(el),
            reinforced_enderium_sheet = compatReinforcedSheet(en),
            reinforced_hepatizon_sheet = compatReinforcedSheet(he),
            reinforced_invar_sheet = compatReinforcedSheet(iv),
            reinforced_lead_sheet = compatReinforcedSheet(le),
            reinforced_lumium_sheet = compatReinforcedSheet(lu),
            reinforced_manyullyn_sheet = compatReinforcedSheet(ma),
            reinforced_nickel_sheet = compatReinforcedSheet(ni),
            reinforced_osmium_sheet = compatReinforcedSheet(os),
            reinforced_pendorite_sheet = compatReinforcedSheet(pd),
            reinforced_queens_slime_sheet = compatReinforcedSheet(qs),
            reinforced_refined_glowstone_sheet = compatReinforcedSheet(rgs),
            reinforced_refined_obsidian_sheet = compatReinforcedSheet(rb),
            reinforced_rose_gold_sheet = compatReinforcedSheet(rg),
            reinforced_signalum_sheet = compatReinforcedSheet(si),
            reinforced_silver_sheet = compatReinforcedSheet(sil),
            reinforced_slimesteel_sheet = compatReinforcedSheet(sl),
            reinforced_uranium_sheet = compatReinforcedSheet(ur),
            reinforced_zinc_sheet = compatReinforcedSheet(zn)
                    ;
            ;
    
    //compatDusts
    public static final ItemEntry<TagDependentIngredientItem>
            aluminum_dust = compatDust(al),
            amethyst_bronze_dust = compatDust(ab),
            arcane_gold_dust = compatDust(ag),
            brass_dust = compatDust(br),
            cobalt_dust = compatDust(cb),
            constantan_dust = compatDust(co),
            electrum_dust = compatDust(el),
            enderium_dust = compatDust(en),
            hepatizon_dust = compatDust(he),
            invar_dust = compatDust(iv),
            lead_dust = compatDust(le),
            lumium_dust = compatDust(lu),
            manyullyn_dust = compatDust(ma),
            nickel_dust = compatDust(ni),
            osmium_dust = compatDust(os),
            pendorite_dust = compatDust(pd),
            queens_slime_dust = compatDust(qs),
            refined_glowstone_dust = compatDust(rgs),
            refined_obsidian_dust = compatDust(rb),
            rose_gold_dust = compatDust(rg),
            signalum_dust = compatDust(si),
            silver_dust = compatDust(sil),
            slimesteel_dust = compatDust(sl),
            uranium_dust = compatDust(ur),
            zinc_dust = compatDust(zn)
                    ;
    
    //compatGears
    public static final ItemEntry<TagDependentIngredientItem>
            aluminum_gear = compatGear(al),
            amethyst_bronze_gear = compatGear(ab),
            arcane_gold_gear = compatGear(ag),
            brass_gear = compatGear(br),
            cobalt_gear = compatGear(cb),
            constantan_gear = compatGear(co),
            electrum_gear = compatGear(el),
            enderium_gear = compatGear(en),
            hepatizon_gear = compatGear(he),
            invar_gear = compatGear(iv),
            lead_gear = compatGear(le),
            lumium_gear = compatGear(lu),
            manyullyn_gear = compatGear(ma),
            nickel_gear = compatGear(ni),
            osmium_gear = compatGear(os),
            pendorite_gear = compatGear(pd),
            queens_slime_gear = compatGear(qs),
            refined_glowstone_gear = compatGear(rgs),
            refined_obsidian_gear = compatGear(rb),
            rose_gold_gear = compatGear(rg),
            signalum_gear = compatGear(si),
            silver_gear = compatGear(sil),
            slimesteel_gear = compatGear(sl),
            uranium_gear = compatGear(ur),
            zinc_gear = compatGear(zn)
                    ;
    public static void register() {
    }
}
