package com.pouffydev.krystalsmaterialcompats.foundation;

import com.pouffydev.krystalsmaterialcompats.MaterialCompats;
import com.pouffydev.krystalsmaterialcompats.content.item.MissingTagNotifier;
import com.pouffydev.krystalsmaterialcompats.content.item.TagDependentIngredientItem;
import com.pouffydev.krystalsmaterialcompats.foundation.data.AllTags;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;

@SuppressWarnings("unused")
public class KrystalsRegistryHelpers {
    
    private static final KrystalsCompatRegistrate itemRegistrate = MaterialCompats.registrate().creativeModeTab(() -> MaterialCompats.itemGroup);
    public static ItemEntry<SwordItem> sword(String material, Tier tier, int pAttackDamageModifier, float pAttackSpeedModifier) {return itemRegistrate.item(material + "_sword", p -> new SwordItem(tier, pAttackDamageModifier, pAttackSpeedModifier, p)).properties(p->p).model((ctx, p) -> p.withExistingParent(ctx.getName(), "item/handheld").texture("layer0", "item/" + material + "_sword")).register();}
    public static ItemEntry<PickaxeItem> pickaxe(String material, Tier tier, int pAttackDamageModifier, float pAttackSpeedModifier) {return itemRegistrate.item(material + "_pickaxe", p -> new PickaxeItem(tier, pAttackDamageModifier, pAttackSpeedModifier, p)).properties(p->p).model((ctx, p) -> p.withExistingParent(ctx.getName(), "item/handheld").texture("layer0", "item/" + material + "_pickaxe")).register();}
    public static ItemEntry<AxeItem> axe(String material, Tier tier, float pAttackDamageModifier, float pAttackSpeedModifier) {return itemRegistrate.item(material + "_axe", p -> new AxeItem(tier, pAttackDamageModifier, pAttackSpeedModifier, p)).properties(p->p).model((ctx, p) -> p.withExistingParent(ctx.getName(), "item/handheld").texture("layer0", "item/" + material + "_axe")).register();}
    public static ItemEntry<ShovelItem> shovel(String material, Tier tier, float pAttackDamageModifier, float pAttackSpeedModifier) {return itemRegistrate.item(material + "_shovel", p -> new ShovelItem(tier, pAttackDamageModifier, pAttackSpeedModifier, p)).properties(p->p).model((ctx, p) -> p.withExistingParent(ctx.getName(), "item/handheld").texture("layer0", "item/" + material + "_shovel")).register();}
    public static ItemEntry<HoeItem> hoe(String material, Tier tier, int attackDamageBaseline, float attackSpeed) {return itemRegistrate.item(material + "_hoe", p -> new HoeItem(tier, attackDamageBaseline, attackSpeed, p)).properties(p->p).model((ctx, p) -> p.withExistingParent(ctx.getName(), "item/handheld").texture("layer0", "item/" + material + "_hoe")).register();}
    public static ItemEntry<Item> sheet(String material) {return itemRegistrate.item(material + "_sheet", Item::new).properties(p->p).tag(plates(material)).tag(plates()).register();}
    public static ItemEntry<Item> ingot(String material) {return itemRegistrate.item(material + "_ingot", Item::new).properties(p->p).tag(ingots(material)).tag(ingots()).register();}
    public static ItemEntry<Item> nugget(String material) {return itemRegistrate.item(material + "_nugget", Item::new).properties(p->p).tag(nuggets(material)).tag(nuggets()).register();}
    public static ItemEntry<Item> rawOre(String material) {return itemRegistrate.item("raw_" + material, Item::new).properties(p->p).tag(rawMaterials(material)).tag(rawMaterials()).register();}
    public static ItemEntry<Item> sturdySheet(String material) {return itemRegistrate.item("sturdy_" + material + "_sheet", Item::new).properties(p->p).tag(AllTags.forgeItemTag("plates/sturdy/" + material)).tag(AllTags.forgeItemTag("plates/sturdy")).register();}
    public static ItemEntry<Item> reinforcedSheet(String material) {return itemRegistrate.item("reinforced_" + material + "_sheet", Item::new).properties(p->p).tag(AllTags.forgeItemTag("plates/reinforced/" + material)).tag(AllTags.forgeItemTag("plates/reinforced")).register();}
    public static ItemEntry<Item> unprocessedSheet(String material) {return itemRegistrate.item("unprocessed_" + material + "_sheet", Item::new).properties(p->p).register();}
    public static ItemEntry<Item> reprocessedSheet(String material) {return itemRegistrate.item("reprocessed_" + material + "_sheet", Item::new).properties(p->p).register();}
    
    public static ItemEntry<TagDependentIngredientItem> compatSheet(CompatMetals metal) {
        String metalName = metal.getName();
        return itemRegistrate
                .item(metalName + "_sheet", props -> new TagDependentIngredientItem(props, ingots(metalName)))
                .tag(plates(metalName))
                .tag(plates())
                .tag(categoryTag(metalName))
                .model(AssetLookup.compatItem("sheet", metalName))
                .register();
    }
    public static ItemEntry<TagDependentIngredientItem> compatMetalRod(CompatMetals metal) {
        String metalName = metal.getName();
        return itemRegistrate
                .item(metalName + "_rod", props -> new TagDependentIngredientItem(props, ingots(metalName)))
                .tag(rods(metalName))
                .tag(rods())
                .tag(categoryTag(metalName))
                .model(AssetLookup.compatItem("rod", metalName))
                .register();
    }
    public static ItemEntry<TagDependentIngredientItem> compatUnprocessedSheet(CompatMetals metal) {
        String metalName = metal.getName();
        return itemRegistrate
                .item("unprocessed_" + metalName + "_sheet", props -> new TagDependentIngredientItem(props, ingots(metalName)))
                .tag(sturdyPlates(metalName))
                .tag(sturdyPlates())
                .tag(categoryTag(metalName))
                .model(AssetLookup.compatItem("unprocessed_sheet", metalName))
                .register();
    }
    public static ItemEntry<TagDependentIngredientItem> compatSturdySheet(CompatMetals metal) {
        String metalName = metal.getName();
        return itemRegistrate
                .item("sturdy_" + metalName + "_sheet", props -> new TagDependentIngredientItem(props, ingots(metalName)))
                .tag(sturdyPlates(metalName))
                .tag(sturdyPlates())
                .tag(categoryTag(metalName))
                .model(AssetLookup.compatItem("sturdy_sheet", metalName))
                .register();
    }
    public static ItemEntry<TagDependentIngredientItem> compatReprocessedSheet(CompatMetals metal) {
        String metalName = metal.getName();
        return itemRegistrate
                .item("reprocessed_" + metalName + "_sheet", props -> new TagDependentIngredientItem(props, ingots(metalName)))
                .tag(sturdyPlates(metalName))
                .tag(sturdyPlates())
                .tag(categoryTag(metalName))
                .model(AssetLookup.compatItem("reprocessed_sheet", metalName))
                .register();
    }
    public static ItemEntry<TagDependentIngredientItem> compatReinforcedSheet(CompatMetals metal) {
        String metalName = metal.getName();
        return itemRegistrate
                .item("reinforced_" + metalName + "_sheet", props -> new TagDependentIngredientItem(props, ingots(metalName)))
                .tag(reinforcedPlates(metalName))
                .tag(reinforcedPlates())
                .tag(categoryTag(metalName))
                .model(AssetLookup.compatItem("reinforced_sheet", metalName))
                .register();
    }
    public static ItemEntry<TagDependentIngredientItem> compatDust(CompatMetals metal) {
        String metalName = metal.getName();
        return itemRegistrate
                .item(metalName + "_dust", props -> new TagDependentIngredientItem(props, ingots(metalName)))
                .tag(dusts(metalName))
                .tag(dusts())
                .tag(categoryTag(metalName))
                .model(AssetLookup.compatItem("dust", metalName))
                .register();
    }
    public static ItemEntry<TagDependentIngredientItem> compatGear(CompatMetals metal) {
        String metalName = metal.getName();
        return itemRegistrate
                .item(metalName + "_gear", props -> new TagDependentIngredientItem(props, ingots(metalName)))
                .tag(gears(metalName))
                .tag(gears())
                .tag(categoryTag(metalName))
                .model(AssetLookup.compatItem("gear", metalName))
                .register();
    }
    public static ItemEntry<TagDependentIngredientItem> compatCoin(CompatMetals metal) {
        String metalName = metal.getName();
        return itemRegistrate
                .item(metalName + "_coin", props -> new TagDependentIngredientItem(props, ingots(metalName)))
                .tag(coins(metalName))
                .tag(coins())
                .tag(categoryTag(metalName))
                .model(AssetLookup.countedFiveTimes("coin", metalName))
                .register();
    }
    public static ItemEntry<TagDependentIngredientItem> compatPlate(CompatMetals metal) {
        String metalName = metal.getName();
        return itemRegistrate
                .item(metalName + "_plate", props -> new TagDependentIngredientItem(props, ingots(metalName)))
                .tag(plates(metalName))
                .tag(plates())
                .tag(categoryTag(metalName))
                .model(AssetLookup.countedFourTimes("plate", metalName))
                .register();
    }
    
    public static ItemEntry<MissingTagNotifier> missingTagNotifier(CompatMetals metal) {
        String metalName = metal.getName();
        String capitalizedMetalName = metal.getCapitalizedName(metalName);
        return itemRegistrate
                .item(metalName + "_tag_notifier", props -> new MissingTagNotifier(props, ingots(metalName)))
                .tag(categoryTag(metalName))
                .model(AssetLookup.tagNotifier())
                .lang(capitalizedMetalName + " Is Missing It's Required Tag")
                .register();
    }
    
    public static ItemEntry<TagDependentIngredientItem> compatSheet(CompatMetals metal, String lang) {
        String metalName = metal.getName();
        return itemRegistrate
                .item(metalName + "_sheet", props -> new TagDependentIngredientItem(props, ingots(metalName)))
                .tag(plates(metalName))
                .tag(plates())
                .tag(categoryTag(metalName))
                .model(AssetLookup.compatItem("sheet", metalName))
                .lang(lang + " Sheet")
                .register();
    }
    public static ItemEntry<TagDependentIngredientItem> compatMetalRod(CompatMetals metal, String lang) {
        String metalName = metal.getName();
        return itemRegistrate
                .item(metalName + "_rod", props -> new TagDependentIngredientItem(props, ingots(metalName)))
                .tag(rods(metalName))
                .tag(rods())
                .tag(categoryTag(metalName))
                .model(AssetLookup.compatItem("rod", metalName))
                .lang(lang + " Rod")
                .register();
    }
    public static ItemEntry<TagDependentIngredientItem> compatUnprocessedSheet(CompatMetals metal, String lang) {
        String metalName = metal.getName();
        return itemRegistrate
                .item("unprocessed_" + metalName + "_sheet", props -> new TagDependentIngredientItem(props, ingots(metalName)))
                .tag(sturdyPlates(metalName))
                .tag(sturdyPlates())
                .tag(categoryTag(metalName))
                .model(AssetLookup.compatItem("unprocessed_sheet", metalName))
                .lang("Unprocessed " + lang + " Sheet")
                .register();
    }
    public static ItemEntry<TagDependentIngredientItem> compatSturdySheet(CompatMetals metal, String lang) {
        String metalName = metal.getName();
        return itemRegistrate
                .item("sturdy_" + metalName + "_sheet", props -> new TagDependentIngredientItem(props, ingots(metalName)))
                .tag(sturdyPlates(metalName))
                .tag(sturdyPlates())
                .tag(categoryTag(metalName))
                .model(AssetLookup.compatItem("sturdy_sheet", metalName))
                .lang("Sturdy " + lang + " Sheet")
                .register();
    }
    public static ItemEntry<TagDependentIngredientItem> compatReprocessedSheet(CompatMetals metal, String lang) {
        String metalName = metal.getName();
        return itemRegistrate
                .item("reprocessed_" + metalName + "_sheet", props -> new TagDependentIngredientItem(props, ingots(metalName)))
                .tag(sturdyPlates(metalName))
                .tag(sturdyPlates())
                .tag(categoryTag(metalName))
                .model(AssetLookup.compatItem("reprocessed_sheet", metalName))
                .lang("Reprocessed " + lang + " Sheet")
                .register();
    }
    public static ItemEntry<TagDependentIngredientItem> compatReinforcedSheet(CompatMetals metal, String lang) {
        String metalName = metal.getName();
        return itemRegistrate
                .item("reinforced_" + metalName + "_sheet", props -> new TagDependentIngredientItem(props, ingots(metalName)))
                .tag(reinforcedPlates(metalName))
                .tag(reinforcedPlates())
                .tag(categoryTag(metalName))
                .model(AssetLookup.compatItem("reinforced_sheet", metalName))
                .lang("Reinforced " + lang + " Sheet")
                .register();
    }
    public static ItemEntry<TagDependentIngredientItem> compatDust(CompatMetals metal, String lang) {
        String metalName = metal.getName();
        return itemRegistrate
                .item(metalName + "_dust", props -> new TagDependentIngredientItem(props, ingots(metalName)))
                .tag(dusts(metalName))
                .tag(dusts())
                .tag(categoryTag(metalName))
                .model(AssetLookup.compatItem("dust", metalName))
                .lang(lang + " Dust")
                .register();
    }
    public static ItemEntry<TagDependentIngredientItem> compatGear(CompatMetals metal, String lang) {
        String metalName = metal.getName();
        return itemRegistrate
                .item(metalName + "_gear", props -> new TagDependentIngredientItem(props, ingots(metalName)))
                .tag(gears(metalName))
                .tag(gears())
                .tag(categoryTag(metalName))
                .model(AssetLookup.compatItem("gear", metalName))
                .lang(lang + " Gear")
                .register();
    }
    public static ItemEntry<TagDependentIngredientItem> compatCoin(CompatMetals metal, String lang) {
        String metalName = metal.getName();
        return itemRegistrate
                .item(metalName + "_coin", props -> new TagDependentIngredientItem(props, ingots(metalName)))
                .tag(coins(metalName))
                .tag(coins())
                .tag(categoryTag(metalName))
                .model(AssetLookup.countedFiveTimes("coin", metalName))
                .lang(lang + " Coin")
                .register();
    }
    public static ItemEntry<TagDependentIngredientItem> compatPlate(CompatMetals metal, String lang) {
        String metalName = metal.getName();
        return itemRegistrate
                .item(metalName + "_plate", props -> new TagDependentIngredientItem(props, ingots(metalName)))
                .tag(plates(metalName))
                .tag(plates())
                .tag(categoryTag(metalName))
                .model(AssetLookup.countedFourTimes("plate", metalName))
                .lang(lang + " Plate")
                .register();
    }
    
    public static ItemEntry<MissingTagNotifier> missingTagNotifier(CompatMetals metal, String lang) {
        String metalName = metal.getName();
        return itemRegistrate
                .item(metalName + "_tag_notifier", props -> new MissingTagNotifier(props, ingots(metalName)))
                .tag(categoryTag(metalName))
                .model(AssetLookup.tagNotifier())
                .lang(lang + " Is Missing It's Required Tag")
                .register();
    }
    
    //TagKey<Item> categoryTag, TagKey<Item> dimensionTag
public static ItemEntry<TagDependentIngredientItem> compatSheet(CompatMetals metal, TagKey<Item> categoryTag, TagKey<Item> dimensionTag) {
        String metalName = metal.getName();
        return itemRegistrate
                .item(metalName + "_sheet", props -> new TagDependentIngredientItem(props, ingots(metalName)))
                .tag(plates(metalName))
                .tag(plates())
                .tag(categoryTag)
                .tag(dimensionTag)
                .model(AssetLookup.compatItem("sheet", metalName))
                .register();
    }
public static ItemEntry<TagDependentIngredientItem> compatMetalRod(CompatMetals metal, TagKey<Item> categoryTag, TagKey<Item> dimensionTag) {
        String metalName = metal.getName();
        return itemRegistrate
                .item(metalName + "_rod", props -> new TagDependentIngredientItem(props, ingots(metalName)))
                .tag(rods(metalName))
                .tag(rods())
                .tag(categoryTag)
                .tag(dimensionTag)
                .model(AssetLookup.compatItem("rod", metalName))
                .register();
    }
public static ItemEntry<TagDependentIngredientItem> compatUnprocessedSheet(CompatMetals metal, TagKey<Item> categoryTag, TagKey<Item> dimensionTag) {
        String metalName = metal.getName();
        return itemRegistrate
                .item("unprocessed_" + metalName + "_sheet", props -> new TagDependentIngredientItem(props, ingots(metalName)))
                .tag(sturdyPlates(metalName))
                .tag(sturdyPlates())
                .tag(categoryTag)
                .tag(dimensionTag)
                .model(AssetLookup.compatItem("unprocessed_sheet", metalName))
                .register();
    }
public static ItemEntry<TagDependentIngredientItem> compatSturdySheet(CompatMetals metal, TagKey<Item> categoryTag, TagKey<Item> dimensionTag) {
        String metalName = metal.getName();
        return itemRegistrate
                .item("sturdy_" + metalName + "_sheet", props -> new TagDependentIngredientItem(props, ingots(metalName)))
                .tag(sturdyPlates(metalName))
                .tag(sturdyPlates())
                .tag(categoryTag)
                .tag(dimensionTag)
                .model(AssetLookup.compatItem("sturdy_sheet", metalName))
                .register();
    }
public static ItemEntry<TagDependentIngredientItem> compatReprocessedSheet(CompatMetals metal, TagKey<Item> categoryTag, TagKey<Item> dimensionTag) {
        String metalName = metal.getName();
        return itemRegistrate
                .item("reprocessed_" + metalName + "_sheet", props -> new TagDependentIngredientItem(props, ingots(metalName)))
                .tag(sturdyPlates(metalName))
                .tag(sturdyPlates())
                .tag(categoryTag)
                .tag(dimensionTag)
                .model(AssetLookup.compatItem("reprocessed_sheet", metalName))
                .register();
    }
public static ItemEntry<TagDependentIngredientItem> compatReinforcedSheet(CompatMetals metal, TagKey<Item> categoryTag, TagKey<Item> dimensionTag) {
        String metalName = metal.getName();
        return itemRegistrate
                .item("reinforced_" + metalName + "_sheet", props -> new TagDependentIngredientItem(props, ingots(metalName)))
                .tag(reinforcedPlates(metalName))
                .tag(reinforcedPlates())
                .tag(categoryTag)
                .tag(dimensionTag)
                .model(AssetLookup.compatItem("reinforced_sheet", metalName))
                .register();
    }
public static ItemEntry<TagDependentIngredientItem> compatDust(CompatMetals metal, TagKey<Item> categoryTag, TagKey<Item> dimensionTag) {
        String metalName = metal.getName();
        return itemRegistrate
                .item(metalName + "_dust", props -> new TagDependentIngredientItem(props, ingots(metalName)))
                .tag(dusts(metalName))
                .tag(dusts())
                .tag(categoryTag)
                .tag(dimensionTag)
                .model(AssetLookup.compatItem("dust", metalName))
                .register();
    }
public static ItemEntry<TagDependentIngredientItem> compatGear(CompatMetals metal, TagKey<Item> categoryTag, TagKey<Item> dimensionTag) {
        String metalName = metal.getName();
        return itemRegistrate
                .item(metalName + "_gear", props -> new TagDependentIngredientItem(props, ingots(metalName)))
                .tag(gears(metalName))
                .tag(gears())
                .tag(categoryTag)
                .tag(dimensionTag)
                .model(AssetLookup.compatItem("gear", metalName))
                .register();
    }
public static ItemEntry<TagDependentIngredientItem> compatCoin(CompatMetals metal, TagKey<Item> categoryTag, TagKey<Item> dimensionTag) {
        String metalName = metal.getName();
        return itemRegistrate
                .item(metalName + "_coin", props -> new TagDependentIngredientItem(props, ingots(metalName)))
                .tag(coins(metalName))
                .tag(coins())
                .tag(categoryTag)
                .tag(dimensionTag)
                .model(AssetLookup.countedFiveTimes("coin", metalName))
                .register();
    }
public static ItemEntry<TagDependentIngredientItem> compatPlate(CompatMetals metal, TagKey<Item> categoryTag, TagKey<Item> dimensionTag) {
        String metalName = metal.getName();
        return itemRegistrate
                .item(metalName + "_plate", props -> new TagDependentIngredientItem(props, ingots(metalName)))
                .tag(plates(metalName))
                .tag(plates())
                .tag(categoryTag)
                .tag(dimensionTag)
                .model(AssetLookup.countedFourTimes("plate", metalName))
                .register();
    }
    
public static ItemEntry<MissingTagNotifier> missingTagNotifier(CompatMetals metal, TagKey<Item> categoryTag, TagKey<Item> dimensionTag) {
        String metalName = metal.getName();
        String capitalizedMetalName = metal.getCapitalizedName(metalName);
        return itemRegistrate
                .item(metalName + "_tag_notifier", props -> new MissingTagNotifier(props, ingots(metalName)))
                .tag(categoryTag)
                .tag(dimensionTag)
                .model(AssetLookup.tagNotifier())
                .lang(capitalizedMetalName + " Is Missing It's Required Tag")
                .register();
    }
    
    public static ItemEntry<TagDependentIngredientItem> compatSheet(CompatMetals metal, String lang, TagKey<Item> categoryTag, TagKey<Item> dimensionTag) {
        String metalName = metal.getName();
        return itemRegistrate
                .item(metalName + "_sheet", props -> new TagDependentIngredientItem(props, ingots(metalName)))
                .tag(plates(metalName))
                .tag(plates())
                .tag(categoryTag)
                .tag(dimensionTag)
                .model(AssetLookup.compatItem("sheet", metalName))
                .lang(lang + " Sheet")
                .register();
    }
    
    public static ItemEntry<TagDependentIngredientItem> compatMetalRod(CompatMetals metal, String lang, TagKey<Item> categoryTag, TagKey<Item> dimensionTag) {
        String metalName = metal.getName();
        return itemRegistrate
                .item(metalName + "_rod", props -> new TagDependentIngredientItem(props, ingots(metalName)))
                .tag(rods(metalName))
                .tag(rods())
                .tag(categoryTag)
                .tag(dimensionTag)
                .model(AssetLookup.compatItem("rod", metalName))
                .lang(lang + " Rod")
                .register();
    }
    
    public static ItemEntry<TagDependentIngredientItem> compatUnprocessedSheet(CompatMetals metal, String lang, TagKey<Item> categoryTag, TagKey<Item> dimensionTag) {
        String metalName = metal.getName();
        return itemRegistrate
                .item("unprocessed_" + metalName + "_sheet", props -> new TagDependentIngredientItem(props, ingots(metalName)))
                .tag(sturdyPlates(metalName))
                .tag(sturdyPlates())
                .tag(categoryTag)
                .tag(dimensionTag)
                .model(AssetLookup.compatItem("unprocessed_sheet", metalName))
                .lang("Unprocessed " + lang + " Sheet")
                .register();
    }
    
    public static ItemEntry<TagDependentIngredientItem> compatSturdySheet(CompatMetals metal, String lang, TagKey<Item> categoryTag, TagKey<Item> dimensionTag) {
        String metalName = metal.getName();
        return itemRegistrate
                .item("sturdy_" + metalName + "_sheet", props -> new TagDependentIngredientItem(props, ingots(metalName)))
                .tag(sturdyPlates(metalName))
                .tag(sturdyPlates())
                .tag(categoryTag)
                .tag(dimensionTag)
                .model(AssetLookup.compatItem("sturdy_sheet", metalName))
                .lang("Sturdy " + lang + " Sheet")
                .register();
    }
    
    public static ItemEntry<TagDependentIngredientItem> compatReprocessedSheet(CompatMetals metal, String lang, TagKey<Item> categoryTag, TagKey<Item> dimensionTag) {
        String metalName = metal.getName();
        return itemRegistrate
                .item("reprocessed_" + metalName + "_sheet", props -> new TagDependentIngredientItem(props, ingots(metalName)))
                .tag(sturdyPlates(metalName))
                .tag(sturdyPlates())
                .tag(categoryTag)
                .tag(dimensionTag)
                .model(AssetLookup.compatItem("reprocessed_sheet", metalName))
                .lang("Reprocessed " + lang + " Sheet")
                .register();
    }
    
    public static ItemEntry<TagDependentIngredientItem> compatReinforcedSheet(CompatMetals metal, String lang, TagKey<Item> categoryTag, TagKey<Item> dimensionTag) {
        String metalName = metal.getName();
        return itemRegistrate
                .item("reinforced_" + metalName + "_sheet", props -> new TagDependentIngredientItem(props, ingots(metalName)))
                .tag(reinforcedPlates(metalName))
                .tag(reinforcedPlates())
                .tag(categoryTag)
                .tag(dimensionTag)
                .model(AssetLookup.compatItem("reinforced_sheet", metalName))
                .lang("Reinforced " + lang + " Sheet")
                .register();
    }
    
    public static ItemEntry<TagDependentIngredientItem> compatDust(CompatMetals metal, String lang, TagKey<Item> categoryTag, TagKey<Item> dimensionTag) {
        String metalName = metal.getName();
        return itemRegistrate
                .item(metalName + "_dust", props -> new TagDependentIngredientItem(props, ingots(metalName)))
                .tag(dusts(metalName))
                .tag(dusts())
                .tag(categoryTag)
                .tag(dimensionTag)
                .model(AssetLookup.compatItem("dust", metalName))
                .lang(lang + " Dust")
                .register();
    }
    
    public static ItemEntry<TagDependentIngredientItem> compatGear(CompatMetals metal, String lang, TagKey<Item> categoryTag, TagKey<Item> dimensionTag) {
        String metalName = metal.getName();
        return itemRegistrate
                .item(metalName + "_gear", props -> new TagDependentIngredientItem(props, ingots(metalName)))
                .tag(gears(metalName))
                .tag(gears())
                .tag(categoryTag)
                .tag(dimensionTag)
                .model(AssetLookup.compatItem("gear", metalName))
                .lang(lang + " Gear")
                .register();
    }
    
    public static ItemEntry<TagDependentIngredientItem> compatCoin(CompatMetals metal, String lang, TagKey<Item> categoryTag, TagKey<Item> dimensionTag) {
        String metalName = metal.getName();
        return itemRegistrate
                .item(metalName + "_coin", props -> new TagDependentIngredientItem(props, ingots(metalName)))
                .tag(coins(metalName))
                .tag(coins())
                .tag(categoryTag)
                .tag(dimensionTag)
                .model(AssetLookup.countedFiveTimes("coin", metalName))
                .lang(lang + " Coin")
                .register();
    }
    
    public static ItemEntry<TagDependentIngredientItem> compatPlate(CompatMetals metal, String lang, TagKey<Item> categoryTag, TagKey<Item> dimensionTag) {
        String metalName = metal.getName();
        return itemRegistrate
                .item(metalName + "_plate", props -> new TagDependentIngredientItem(props, ingots(metalName)))
                .tag(plates(metalName))
                .tag(plates())
                .tag(categoryTag)
                .tag(dimensionTag)
                .model(AssetLookup.countedFourTimes("plate", metalName))
                .lang(lang + " Plate")
                .register();
    }
    
    public static ItemEntry<MissingTagNotifier> missingTagNotifier(CompatMetals metal, String lang, TagKey<Item> categoryTag, TagKey<Item> dimensionTag) {
        String metalName = metal.getName();
        return itemRegistrate
                .item(metalName + "_tag_notifier", props -> new MissingTagNotifier(props, ingots(metalName)))
                .tag(categoryTag)
                .tag(dimensionTag)
                .model(AssetLookup.tagNotifier())
                .lang(lang + " Is Missing It's Required Tag")
                .register();
    }
    
    /**
     * Pre-Built TagKey's for my items for use in TagGen
     * @see TagKey
     */
    public static TagKey<Item> categoryTag(String material) {
        return AllTags.modItemTag("category/" + material);
    }
    public static TagKey<Item> gems(String material) {
        return AllTags.forgeItemTag("gems/" + material);
    }
    public static TagKey<Item> rawMaterials(String material) {return AllTags.forgeItemTag("raw_materials/" + material);}
    public static TagKey<Item> rods(String material) {
        return AllTags.forgeItemTag("rods/" + material);
    }
    public static TagKey<Item> rods() {
        return AllTags.forgeItemTag("rods");
    }
    public static TagKey<Item> ingots(String material) {
        return AllTags.forgeItemTag("ingots/" + material);
    }
    public static TagKey<Item> dusts(String material) {return AllTags.forgeItemTag("dusts/" + material);}
    public static TagKey<Item> gears(String material) {return AllTags.forgeItemTag("gears/" + material);}
    public static TagKey<Item> nuggets(String material) {
        return AllTags.forgeItemTag("nuggets/" + material);
    }
    public static TagKey<Item> plates(String material) {
        return AllTags.forgeItemTag("plates/" + material);
    }
    public static TagKey<Item> plates() {
        return AllTags.forgeItemTag("plates");
    }
    public static TagKey<Item> sturdyPlates(String material) {return AllTags.forgeItemTag("plates/sturdy/" + material);}
    public static TagKey<Item> sturdyPlates() {
        return AllTags.forgeItemTag("plates/sturdy");
    }
    public static TagKey<Item> reinforcedPlates(String material) {return AllTags.forgeItemTag("plates/reinforced/" + material);}
    public static TagKey<Item> reinforcedPlates() {
        return AllTags.forgeItemTag("plates/reinforced");
    }
    public static TagKey<Item> rawMaterials() {
        return AllTags.forgeItemTag("raw_materials");
    }
    public static TagKey<Item> ingots() {
        return AllTags.forgeItemTag("ingots");
    }
    public static TagKey<Item> dusts() {
        return AllTags.forgeItemTag("dusts");
    }
    public static TagKey<Item> gears() {return AllTags.forgeItemTag("gears");}
    public static TagKey<Item> randomiumBlacklist() {
        return AllTags.modItemTag("randomium", "blacklist");
    }
    public static TagKey<Item> nuggets() {
        return AllTags.forgeItemTag("nuggets");
    }
    public static TagKey<Item> gems() {
        return AllTags.forgeItemTag("gems");
    }
    public static TagKey<Item> coins(){return AllTags.forgeItemTag("coins");}
    public static TagKey<Item> coins(String material){return AllTags.forgeItemTag("coins/" + material);}
}
