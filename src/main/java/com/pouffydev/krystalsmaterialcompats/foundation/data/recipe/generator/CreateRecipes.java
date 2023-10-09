package com.pouffydev.krystalsmaterialcompats.foundation.data.recipe.generator;

import com.pouffydev.krystalsmaterialcompats.KMCItems;
import com.pouffydev.krystalsmaterialcompats.foundation.CompatMetals;
import com.pouffydev.krystalsmaterialcompats.foundation.data.recipe.builder.PressingRecipeBuilder;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.pouffydev.krystalsmaterialcompats.foundation.KrystalsRegistryHelpers.ingots;

public class CreateRecipes {
    static String al = CompatMetals.aluminum.getName();
    static String ab = CompatMetals.amethyst_bronze.getName();
    static String ag = CompatMetals.arcane_gold.getName();
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
    static String pd = CompatMetals.pendorite.getName();
    static String qs = CompatMetals.queens_slime.getName();
    static String rg = CompatMetals.rose_gold.getName();
    static String si = CompatMetals.signalum.getName();
    static String sil = CompatMetals.silver.getName();
    static String sl = CompatMetals.slimesteel.getName();
    public CreateRecipes() {
    }
    public static void register(Consumer<FinishedRecipe> consumer) {
        pressing(consumer);
    }
    private static void pressing(Consumer<FinishedRecipe> consumer) {
        PressingRecipeBuilder.createPressing(KMCItems.aluminum_sheet.get(), 1, ingots(al).location().toString()).build(consumer);
        PressingRecipeBuilder.createPressing(KMCItems.amethyst_bronze_sheet.get(), 1, ingots(ab).location().toString()).build(consumer);
        PressingRecipeBuilder.createPressing(KMCItems.arcane_gold_sheet.get(), 1, ingots(ag).location().toString()).build(consumer);
        PressingRecipeBuilder.createPressing(KMCItems.cobalt_sheet.get(), 1, ingots(cb).location().toString()).build(consumer);
        PressingRecipeBuilder.createPressing(KMCItems.constantan_sheet.get(), 1, ingots(co).location().toString()).build(consumer);
        PressingRecipeBuilder.createPressing(KMCItems.electrum_sheet.get(), 1, ingots(el).location().toString()).build(consumer);
        PressingRecipeBuilder.createPressing(KMCItems.enderium_sheet.get(), 1, ingots(en).location().toString()).build(consumer);
        PressingRecipeBuilder.createPressing(KMCItems.hepatizon_sheet.get(), 1, ingots(he).location().toString()).build(consumer);
        PressingRecipeBuilder.createPressing(KMCItems.invar_sheet.get(), 1, ingots(iv).location().toString()).build(consumer);
        PressingRecipeBuilder.createPressing(KMCItems.lead_sheet.get(), 1, ingots(le).location().toString()).build(consumer);
        PressingRecipeBuilder.createPressing(KMCItems.lumium_sheet.get(), 1, ingots(lu).location().toString()).build(consumer);
        PressingRecipeBuilder.createPressing(KMCItems.manyullyn_sheet.get(), 1, ingots(ma).location().toString()).build(consumer);
        PressingRecipeBuilder.createPressing(KMCItems.nickel_sheet.get(), 1, ingots(ni).location().toString()).build(consumer);
        PressingRecipeBuilder.createPressing(KMCItems.pendorite_sheet.get(), 1, ingots(pd).location().toString()).build(consumer);
        PressingRecipeBuilder.createPressing(KMCItems.queens_slime_sheet.get(), 1, ingots(qs).location().toString()).build(consumer);
        PressingRecipeBuilder.createPressing(KMCItems.rose_gold_sheet.get(), 1, ingots(rg).location().toString()).build(consumer);
        PressingRecipeBuilder.createPressing(KMCItems.signalum_sheet.get(), 1, ingots(si).location().toString()).build(consumer);
        PressingRecipeBuilder.createPressing(KMCItems.silver_sheet.get(), 1, ingots(sil).location().toString()).build(consumer);
        PressingRecipeBuilder.createPressing(KMCItems.slimesteel_sheet.get(), 1, ingots(sl).location().toString()).build(consumer);
    
    }
}
