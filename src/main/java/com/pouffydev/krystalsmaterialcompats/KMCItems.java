package com.pouffydev.krystalsmaterialcompats;

import com.pouffydev.krystalsmaterialcompats.content.item.MissingTagNotifier;
import com.pouffydev.krystalsmaterialcompats.content.item.TagDependentIngredientItem;
import com.pouffydev.krystalsmaterialcompats.foundation.CompatMetals;
import com.pouffydev.krystalsmaterialcompats.foundation.data.AllTags;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

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
    static CompatMetals st = CompatMetals.steel;
    static CompatMetals sb = CompatMetals.strong_bronze;
    static CompatMetals ti = CompatMetals.tin;
    static CompatMetals ur = CompatMetals.uranium;
    static CompatMetals zn = CompatMetals.zinc;
    
    //For groupByCategory
    static TagKey<Item> industrial = AllTags.AllCompatItemTags.industrial.tag;
    static TagKey<Item> interdimensional = AllTags.AllCompatItemTags.interdimensional.tag;
    static TagKey<Item> magic = AllTags.AllCompatItemTags.magic.tag;
    static TagKey<Item> blacksmithing = AllTags.AllCompatItemTags.blacksmithing.tag;
    
    //For groupByDimension
    static TagKey<Item> overworld = AllTags.AllCompatItemTags.overworld.tag;
    static TagKey<Item> nether = AllTags.AllCompatItemTags.nether.tag;
    static TagKey<Item> end = AllTags.AllCompatItemTags.end.tag;
    static TagKey<Item> space = AllTags.AllCompatItemTags.space.tag;
    static TagKey<Item> betweenlands = AllTags.AllCompatItemTags.betweenlands.tag;
    static TagKey<Item> undergarden = AllTags.AllCompatItemTags.undergarden.tag;
    
    
    //compatSheets
    public static final ItemEntry<TagDependentIngredientItem>
            aluminum_sheet = compatSheet(al, industrial, overworld),
            amethyst_bronze_sheet = compatSheet(ab, blacksmithing, overworld),
            arcane_gold_sheet = compatSheet(ag, magic, overworld),
            brass_sheet = compatSheet(br, industrial, overworld),
            cobalt_sheet = compatSheet(cb, blacksmithing, nether),
            constantan_sheet = compatSheet(co, industrial, overworld),
            electrum_sheet = compatSheet(el, industrial, overworld),
            enderium_sheet = compatSheet(en, industrial, end),
            hepatizon_sheet = compatSheet(he, blacksmithing, nether),
            invar_sheet = compatSheet(iv, industrial, overworld),
            lead_sheet = compatSheet(le, industrial, overworld),
            lumium_sheet = compatSheet(lu, industrial, overworld),
            manyullyn_sheet = compatSheet(ma, blacksmithing, nether),
            nickel_sheet = compatSheet(ni, industrial, overworld),
            osmium_sheet = compatSheet(os, industrial, overworld),
            pendorite_sheet = compatSheet(pd, blacksmithing, overworld),
            queens_slime_sheet = compatSheet(qs, "Queen's Slime", blacksmithing, overworld),
            refined_glowstone_sheet = compatSheet(rgs, industrial, nether),
            refined_obsidian_sheet = compatSheet(rb, industrial, nether),
            rose_gold_sheet = compatSheet(rg, blacksmithing, overworld),
            signalum_sheet = compatSheet(si, industrial, overworld),
            silver_sheet = compatSheet(sil, industrial, overworld),
            slimesteel_sheet = compatSheet(sl, blacksmithing, overworld),
            steel_sheet = compatSheet(st, blacksmithing, overworld),
            strong_bronze_sheet = compatSheet(sb, blacksmithing, overworld),
            tin_sheet = compatSheet(ti, industrial, overworld),
            uranium_sheet = compatSheet(ur, industrial, overworld),
            zinc_sheet = compatSheet(zn, industrial, overworld)
                    ;
    
    //compatRods
    public static final ItemEntry<TagDependentIngredientItem>
            aluminum_rod = compatMetalRod(al, industrial, overworld),
            amethyst_bronze_rod = compatMetalRod(ab, blacksmithing, overworld), 
            arcane_gold_rod = compatMetalRod(ag, magic, overworld),
            brass_rod = compatMetalRod(br,  industrial, overworld),
            cobalt_rod = compatMetalRod(cb, blacksmithing, nether),
            constantan_rod = compatMetalRod(co, industrial, overworld),
            electrum_rod = compatMetalRod(el, industrial, overworld),
            enderium_rod = compatMetalRod(en, industrial, end),
            hepatizon_rod = compatMetalRod(he, blacksmithing, nether),
            invar_rod = compatMetalRod(iv, industrial, overworld),
            lead_rod = compatMetalRod(le, industrial, overworld),
            lumium_rod = compatMetalRod(lu, industrial, overworld),
            manyullyn_rod = compatMetalRod(ma, blacksmithing, nether),
            nickel_rod = compatMetalRod(ni, industrial, overworld),
            osmium_rod = compatMetalRod(os, industrial, overworld),
            pendorite_rod = compatMetalRod(pd, blacksmithing, overworld),
            queens_slime_rod = compatMetalRod(qs, "Queen's Slime", blacksmithing, overworld),
            refined_glowstone_rod = compatMetalRod(rgs, industrial, nether),
            refined_obsidian_rod = compatMetalRod(rb, industrial, nether),
            rose_gold_rod = compatMetalRod(rg, blacksmithing, overworld),
            signalum_rod = compatMetalRod(si, industrial, overworld),
            silver_rod = compatMetalRod(sil, industrial, overworld),
            slimesteel_rod = compatMetalRod(sl, blacksmithing, overworld),
            steel_rod = compatMetalRod(st, blacksmithing, overworld),
            strong_bronze_rod = compatMetalRod(sb, blacksmithing, overworld),
            tin_rod = compatMetalRod(ti, industrial, overworld),
            uranium_rod = compatMetalRod(ur, industrial, overworld),
            zinc_rod = compatMetalRod(zn, industrial, overworld)
                    ;
    
    //compatUnprocessedSheets
    public static final ItemEntry<TagDependentIngredientItem>
            unprocessed_aluminum_sheet = compatUnprocessedSheet(al, industrial, overworld),
            unprocessed_amethyst_bronze_sheet = compatUnprocessedSheet(ab, blacksmithing, overworld),
            unprocessed_arcane_gold_sheet = compatUnprocessedSheet(ag, magic, overworld),
            unprocessed_brass_sheet = compatUnprocessedSheet(br, industrial, overworld),
            unprocessed_cobalt_sheet = compatUnprocessedSheet(cb, blacksmithing, nether),
            unprocessed_constantan_sheet = compatUnprocessedSheet(co, industrial, overworld),
            unprocessed_electrum_sheet = compatUnprocessedSheet(el, industrial, overworld),
            unprocessed_enderium_sheet = compatUnprocessedSheet(en, industrial, end),
            unprocessed_hepatizon_sheet = compatUnprocessedSheet(he, blacksmithing, nether),
            unprocessed_invar_sheet = compatUnprocessedSheet(iv, industrial, overworld),
            unprocessed_lead_sheet = compatUnprocessedSheet(le, industrial, overworld),
            unprocessed_lumium_sheet = compatUnprocessedSheet(lu, industrial, overworld),
            unprocessed_manyullyn_sheet = compatUnprocessedSheet(ma, blacksmithing, nether),
            unprocessed_nickel_sheet = compatUnprocessedSheet(ni, industrial, overworld),
            unprocessed_osmium_sheet = compatUnprocessedSheet(os, industrial, overworld),
            unprocessed_pendorite_sheet = compatUnprocessedSheet(pd, blacksmithing, overworld),
            unprocessed_queens_slime_sheet = compatUnprocessedSheet(qs, "Queen's Slime", blacksmithing, overworld),
            unprocessed_refined_glowstone_sheet = compatUnprocessedSheet(rgs, industrial, nether),
            unprocessed_refined_obsidian_sheet = compatUnprocessedSheet(rb, industrial, nether),
            unprocessed_rose_gold_sheet = compatUnprocessedSheet(rg, blacksmithing, overworld),
            unprocessed_signalum_sheet = compatUnprocessedSheet(si, industrial, overworld),
            unprocessed_silver_sheet = compatUnprocessedSheet(sil, industrial, overworld),
            unprocessed_slimesteel_sheet = compatUnprocessedSheet(sl, blacksmithing, overworld),
            unprocessed_steel_sheet = compatUnprocessedSheet(st, blacksmithing, overworld),
            unprocessed_strong_bronze_sheet = compatUnprocessedSheet(sb, blacksmithing, overworld),
            unprocessed_tin_sheet = compatUnprocessedSheet(ti, industrial, overworld),
            unprocessed_uranium_sheet = compatUnprocessedSheet(ur, industrial, overworld),
            unprocessed_zinc_sheet = compatUnprocessedSheet(zn, industrial, overworld)
                    ;
    
    //compatSturdySheets
    public static final ItemEntry<TagDependentIngredientItem>
            sturdy_aluminum_sheet = compatSturdySheet(al, industrial, overworld),
            sturdy_amethyst_bronze_sheet = compatSturdySheet(ab, blacksmithing, overworld),
            sturdy_arcane_gold_sheet = compatSturdySheet(ag, magic, overworld),
            sturdy_brass_sheet = compatSturdySheet(br, industrial, overworld),
            sturdy_cobalt_sheet = compatSturdySheet(cb, blacksmithing, nether),
            sturdy_constantan_sheet = compatSturdySheet(co, industrial, overworld),
            sturdy_electrum_sheet = compatSturdySheet(el, industrial, overworld),
            sturdy_enderium_sheet = compatSturdySheet(en, industrial, end),
            sturdy_hepatizon_sheet = compatSturdySheet(he, blacksmithing, nether),
            sturdy_invar_sheet = compatSturdySheet(iv, industrial, overworld),
            sturdy_lead_sheet = compatSturdySheet(le, industrial, overworld),
            sturdy_lumium_sheet = compatSturdySheet(lu, industrial, overworld),
            sturdy_manyullyn_sheet = compatSturdySheet(ma, blacksmithing, nether),
            sturdy_nickel_sheet = compatSturdySheet(ni, industrial, overworld),
            sturdy_osmium_sheet = compatSturdySheet(os, industrial, overworld),
            sturdy_pendorite_sheet = compatSturdySheet(pd, blacksmithing, overworld),
            sturdy_queens_slime_sheet = compatSturdySheet(qs, "Queen's Slime", blacksmithing, overworld),
            sturdy_refined_glowstone_sheet = compatSturdySheet(rgs, industrial, nether),
            sturdy_refined_obsidian_sheet = compatSturdySheet(rb, industrial, nether),
            sturdy_rose_gold_sheet = compatSturdySheet(rg, blacksmithing, overworld),
            sturdy_signalum_sheet = compatSturdySheet(si, industrial, overworld),
            sturdy_silver_sheet = compatSturdySheet(sil, industrial, overworld),
            sturdy_slimesteel_sheet = compatSturdySheet(sl, blacksmithing, overworld),
            sturdy_steel_sheet = compatSturdySheet(st, blacksmithing, overworld),
            sturdy_strong_bronze_sheet = compatSturdySheet(sb, blacksmithing, overworld),
            sturdy_tin_sheet = compatSturdySheet(ti, industrial, overworld),
            sturdy_uranium_sheet = compatSturdySheet(ur, industrial, overworld),
            sturdy_zinc_sheet = compatSturdySheet(zn, industrial, overworld)
                    ;
    
    //compatReprocessedSheets
    public static final ItemEntry<TagDependentIngredientItem>
            reprocessed_aluminum_sheet = compatReprocessedSheet(al, industrial, overworld),
            reprocessed_amethyst_bronze_sheet = compatReprocessedSheet(ab, blacksmithing, overworld),
            reprocessed_arcane_gold_sheet = compatReprocessedSheet(ag, magic, overworld),
            reprocessed_brass_sheet = compatReprocessedSheet(br, industrial, overworld),
            reprocessed_cobalt_sheet = compatReprocessedSheet(cb, blacksmithing, nether),
            reprocessed_constantan_sheet = compatReprocessedSheet(co, industrial, overworld),
            reprocessed_electrum_sheet = compatReprocessedSheet(el, industrial, overworld),
            reprocessed_enderium_sheet = compatReprocessedSheet(en, industrial, end),
            reprocessed_hepatizon_sheet = compatReprocessedSheet(he, blacksmithing, nether),
            reprocessed_invar_sheet = compatReprocessedSheet(iv, industrial, overworld),
            reprocessed_lead_sheet = compatReprocessedSheet(le, industrial, overworld),
            reprocessed_lumium_sheet = compatReprocessedSheet(lu, industrial, overworld),
            reprocessed_manyullyn_sheet = compatReprocessedSheet(ma, blacksmithing, nether),
            reprocessed_nickel_sheet = compatReprocessedSheet(ni, industrial, overworld),
            reprocessed_osmium_sheet = compatReprocessedSheet(os, industrial, overworld),
            reprocessed_pendorite_sheet = compatReprocessedSheet(pd, blacksmithing, overworld),
            reprocessed_queens_slime_sheet = compatReprocessedSheet(qs, "Queen's Slime", blacksmithing, overworld),
            reprocessed_refined_glowstone_sheet = compatReprocessedSheet(rgs, industrial, nether),
            reprocessed_refined_obsidian_sheet = compatReprocessedSheet(rb, industrial, nether),
            reprocessed_rose_gold_sheet = compatReprocessedSheet(rg, blacksmithing, overworld),
            reprocessed_signalum_sheet = compatReprocessedSheet(si, industrial, overworld),
            reprocessed_silver_sheet = compatReprocessedSheet(sil, industrial, overworld),
            reprocessed_slimesteel_sheet = compatReprocessedSheet(sl, blacksmithing, overworld),
            reprocessed_steel_sheet = compatReprocessedSheet(st, blacksmithing, overworld),
            reprocessed_strong_bronze_sheet = compatReprocessedSheet(sb, blacksmithing, overworld),
            reprocessed_tin_sheet = compatReprocessedSheet(ti, industrial, overworld),
            reprocessed_uranium_sheet = compatReprocessedSheet(ur, industrial, overworld),
            reprocessed_zinc_sheet = compatReprocessedSheet(zn, industrial, overworld)
                    ;
    
    
    //compatReinforcedSheets
    public static final ItemEntry<TagDependentIngredientItem>
            reinforced_aluminum_sheet = compatReinforcedSheet(al, industrial, overworld),
            reinforced_amethyst_bronze_sheet = compatReinforcedSheet(ab, blacksmithing, overworld),
            reinforced_arcane_gold_sheet = compatReinforcedSheet(ag, magic, overworld),
            reinforced_brass_sheet = compatReinforcedSheet(br, industrial, overworld),
            reinforced_cobalt_sheet = compatReinforcedSheet(cb, blacksmithing, nether),
            reinforced_constantan_sheet = compatReinforcedSheet(co, industrial, overworld),
            reinforced_electrum_sheet = compatReinforcedSheet(el, industrial, overworld),
            reinforced_enderium_sheet = compatReinforcedSheet(en, industrial, end),
            reinforced_hepatizon_sheet = compatReinforcedSheet(he, blacksmithing, nether),
            reinforced_invar_sheet = compatReinforcedSheet(iv, industrial, overworld),
            reinforced_lead_sheet = compatReinforcedSheet(le, industrial, overworld),
            reinforced_lumium_sheet = compatReinforcedSheet(lu, industrial, overworld),
            reinforced_manyullyn_sheet = compatReinforcedSheet(ma, blacksmithing, nether),
            reinforced_nickel_sheet = compatReinforcedSheet(ni, industrial, overworld),
            reinforced_osmium_sheet = compatReinforcedSheet(os, industrial, overworld),
            reinforced_pendorite_sheet = compatReinforcedSheet(pd, blacksmithing, overworld),
            reinforced_queens_slime_sheet = compatReinforcedSheet(qs, "Queen's Slime", blacksmithing, overworld),
            reinforced_refined_glowstone_sheet = compatReinforcedSheet(rgs, industrial, nether),
            reinforced_refined_obsidian_sheet = compatReinforcedSheet(rb, industrial, nether),
            reinforced_rose_gold_sheet = compatReinforcedSheet(rg, blacksmithing, overworld),
            reinforced_signalum_sheet = compatReinforcedSheet(si, industrial, overworld),
            reinforced_silver_sheet = compatReinforcedSheet(sil, industrial, overworld),
            reinforced_slimesteel_sheet = compatReinforcedSheet(sl, blacksmithing, overworld),
            reinforced_steel_sheet = compatReinforcedSheet(st, blacksmithing, overworld),
            reinforced_strong_bronze_sheet = compatReinforcedSheet(sb, blacksmithing, overworld),
            reinforced_tin_sheet = compatReinforcedSheet(ti, industrial, overworld),
            reinforced_uranium_sheet = compatReinforcedSheet(ur, industrial, overworld),
            reinforced_zinc_sheet = compatReinforcedSheet(zn, industrial, overworld)
                    ;
    
            ;
    
    //compatDusts
    public static final ItemEntry<TagDependentIngredientItem>
            aluminum_dust = compatDust(al, industrial, overworld),
            amethyst_bronze_dust = compatDust(ab, blacksmithing, overworld),
            arcane_gold_dust = compatDust(ag, magic, overworld),
            brass_dust = compatDust(br, industrial, overworld),
            cobalt_dust = compatDust(cb, blacksmithing, nether),
            constantan_dust = compatDust(co, industrial, overworld),
            electrum_dust = compatDust(el, industrial, overworld),
            enderium_dust = compatDust(en, industrial, end),
            hepatizon_dust = compatDust(he, blacksmithing, nether),
            invar_dust = compatDust(iv, industrial, overworld),
            lead_dust = compatDust(le, industrial, overworld),
            lumium_dust = compatDust(lu, industrial, overworld),
            manyullyn_dust = compatDust(ma, blacksmithing, nether),
            nickel_dust = compatDust(ni, industrial, overworld),
            osmium_dust = compatDust(os, industrial, overworld),
            pendorite_dust = compatDust(pd, blacksmithing, overworld),
            queens_slime_dust = compatDust(qs, "Queen's Slime", blacksmithing, overworld),
            refined_glowstone_dust = compatDust(rgs, industrial, nether),
            refined_obsidian_dust = compatDust(rb, industrial, nether),
            rose_gold_dust = compatDust(rg, blacksmithing, overworld),
            signalum_dust = compatDust(si, industrial, overworld),
            silver_dust = compatDust(sil, industrial, overworld),
            slimesteel_dust = compatDust(sl, blacksmithing, overworld),
            steel_dust = compatDust(st, blacksmithing, overworld),
            strong_bronze_dust = compatDust(sb, blacksmithing, overworld),
            tin_dust = compatDust(ti, industrial, overworld),
            uranium_dust = compatDust(ur, industrial, overworld),
            zinc_dust = compatDust(zn, industrial, overworld)
                    ;
    
    //compatGears
    public static final ItemEntry<TagDependentIngredientItem>
            aluminum_gear = compatGear(al, industrial, overworld),
            amethyst_bronze_gear = compatGear(ab, blacksmithing, overworld),
            arcane_gold_gear = compatGear(ag, magic, overworld),
            brass_gear = compatGear(br, industrial, overworld),
            cobalt_gear = compatGear(cb, blacksmithing, nether),
            constantan_gear = compatGear(co, industrial, overworld),
            electrum_gear = compatGear(el, industrial, overworld),
            enderium_gear = compatGear(en, industrial, end),
            hepatizon_gear = compatGear(he, blacksmithing, nether),
            invar_gear = compatGear(iv, industrial, overworld),
            lead_gear = compatGear(le, industrial, overworld),
            lumium_gear = compatGear(lu, industrial, overworld),
            manyullyn_gear = compatGear(ma, blacksmithing, nether),
            nickel_gear = compatGear(ni, industrial, overworld),
            osmium_gear = compatGear(os, industrial, overworld),
            pendorite_gear = compatGear(pd, blacksmithing, overworld),
            queens_slime_gear = compatGear(qs, "Queen's Slime", blacksmithing, overworld),
            refined_glowstone_gear = compatGear(rgs, industrial, nether),
            refined_obsidian_gear = compatGear(rb, industrial, nether),
            rose_gold_gear = compatGear(rg, blacksmithing, overworld),
            signalum_gear = compatGear(si, industrial, overworld),
            silver_gear = compatGear(sil, industrial, overworld),
            slimesteel_gear = compatGear(sl, blacksmithing, overworld),
            steel_gear = compatGear(st, blacksmithing, overworld),
            strong_bronze_gear = compatGear(sb, blacksmithing, overworld),
            tin_gear = compatGear(ti, industrial, overworld),
            uranium_gear = compatGear(ur, industrial, overworld),
            zinc_gear = compatGear(zn, industrial, overworld)
                    ;
    
    public static final ItemEntry<TagDependentIngredientItem>
            aluminum_coin = compatCoin(al, industrial, overworld),
            amethyst_bronze_coin = compatCoin(ab, blacksmithing, overworld),
            arcane_gold_coin = compatCoin(ag, magic, overworld),
            brass_coin = compatCoin(br, industrial, overworld),
            cobalt_coin = compatCoin(cb, blacksmithing, nether),
            //constantan_coin = compatCoin(co, industrial, overworld),
            electrum_coin = compatCoin(el, industrial, overworld),
            //enderium_coin = compatCoin(en, industrial, end),
            hepatizon_coin = compatCoin(he, blacksmithing, nether),
            //invar_coin = compatCoin(iv, industrial, overworld),
            lead_coin = compatCoin(le, industrial, overworld),
            //lumium_coin = compatCoin(lu, industrial, overworld),
            manyullyn_coin = compatCoin(ma, blacksmithing, nether),
            nickel_coin = compatCoin(ni, industrial, overworld),
            osmium_coin = compatCoin(os, industrial, overworld),
            pendorite_coin = compatCoin(pd, blacksmithing, overworld),
            queens_slime_coin = compatCoin(qs, "Queen's Slime", blacksmithing, overworld),
            refined_glowstone_coin = compatCoin(rgs, industrial, nether),
            refined_obsidian_coin = compatCoin(rb, industrial, nether),
            rose_gold_coin = compatCoin(rg, blacksmithing, overworld),
            //signalum_coin = compatCoin(si, industrial, overworld),
            silver_coin = compatCoin(sil, industrial, overworld),
            slimesteel_coin = compatCoin(sl, blacksmithing, overworld),
            steel_coin = compatCoin(st, blacksmithing, overworld),
            strong_bronze_coin = compatCoin(sb, blacksmithing, overworld),
            tin_coin = compatCoin(ti, industrial, overworld),
            uranium_coin = compatCoin(ur, industrial, overworld),
            zinc_coin = compatCoin(zn, industrial, overworld)
                    ;
    
    public static final ItemEntry<TagDependentIngredientItem>
            aluminum_plate = compatPlate(al, industrial, overworld),
            amethyst_bronze_plate = compatPlate(ab, blacksmithing, overworld),
            arcane_gold_plate = compatPlate(ag, magic, overworld),
            brass_plate = compatPlate(br, industrial, overworld),
            cobalt_plate = compatPlate(cb, blacksmithing, nether),
            //constantan_plate = compatPlate(co, industrial, overworld),
            electrum_plate = compatPlate(el, industrial, overworld),
            //enderium_plate = compatPlate(en, industrial, end),
            hepatizon_plate = compatPlate(he, blacksmithing, nether),
            //invar_plate = compatPlate(iv, industrial, overworld),
            lead_plate = compatPlate(le, industrial, overworld),
            //lumium_plate = compatPlate(lu, industrial, overworld),
            manyullyn_plate = compatPlate(ma, blacksmithing, nether),
            nickel_plate = compatPlate(ni, industrial, overworld),
            osmium_plate = compatPlate(os, industrial, overworld),
            pendorite_plate = compatPlate(pd, blacksmithing, overworld),
            queens_slime_plate = compatPlate(qs, "Queen's Slime", blacksmithing, overworld),
            refined_glowstone_plate = compatPlate(rgs, industrial, nether),
            refined_obsidian_plate = compatPlate(rb, industrial, nether),
            rose_gold_plate = compatPlate(rg, blacksmithing, overworld),
            //signalum_plate = compatPlate(si, industrial, overworld),
            silver_plate = compatPlate(sil, industrial, overworld),
            slimesteel_plate = compatPlate(sl, blacksmithing, overworld),
            steel_plate = compatPlate(st, blacksmithing, overworld),
            strong_bronze_plate = compatPlate(sb, blacksmithing, overworld),
            tin_plate = compatPlate(ti, industrial, overworld),
            uranium_plate = compatPlate(ur, industrial, overworld),
            zinc_plate = compatPlate(zn, industrial, overworld)
                    ;
    
    
    public static final ItemEntry<MissingTagNotifier>
            aluminum_ingot = missingTagNotifier(al, industrial, overworld),
            amethyst_bronze_ingot = missingTagNotifier(ab, blacksmithing, overworld),
            arcane_gold_ingot = missingTagNotifier(ag, magic, overworld),
            brass_ingot = missingTagNotifier(br, industrial, overworld),
            cobalt_ingot = missingTagNotifier(cb, blacksmithing, nether),
            constantan_ingot = missingTagNotifier(co, industrial, overworld),
            electrum_ingot = missingTagNotifier(el, industrial, overworld),
            enderium_ingot = missingTagNotifier(en, industrial, end),
            hepatizon_ingot = missingTagNotifier(he, blacksmithing, nether),
            invar_ingot = missingTagNotifier(iv, industrial, overworld),
            lead_ingot = missingTagNotifier(le, industrial, overworld),
            lumium_ingot = missingTagNotifier(lu, industrial, overworld),
            manyullyn_ingot = missingTagNotifier(ma, blacksmithing, nether),
            nickel_ingot = missingTagNotifier(ni, industrial, overworld),
            osmium_ingot = missingTagNotifier(os, industrial, overworld),
            pendorite_ingot = missingTagNotifier(pd, blacksmithing, overworld),
            queens_slime_ingot = missingTagNotifier(qs, "Queen's Slime", blacksmithing, overworld),
            refined_glowstone_ingot = missingTagNotifier(rgs, industrial, nether),
            refined_obsidian_ingot = missingTagNotifier(rb, industrial, nether),
            rose_gold_ingot = missingTagNotifier(rg, blacksmithing, overworld),
            signalum_ingot = missingTagNotifier(si, industrial, overworld),
            silver_ingot = missingTagNotifier(sil, industrial, overworld),
            slimesteel_ingot = missingTagNotifier(sl, blacksmithing, overworld),
            steel_ingot = missingTagNotifier(st, blacksmithing, overworld),
            strong_bronze_ingot = missingTagNotifier(sb, blacksmithing, overworld),
            tin_ingot = missingTagNotifier(ti, industrial, overworld),
            uranium_ingot = missingTagNotifier(ur, industrial, overworld),
            zinc_ingot = missingTagNotifier(zn, industrial, overworld)
                    ;
    
    public static void register() {
    }
}
