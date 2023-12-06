package com.pouffydev.krystalsmaterialcompats.foundation;

import com.pouffydev.krystal_core.KrystalCore;
import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateItemModelProvider;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class AssetLookup {
    static ResourceLocation count = new ResourceLocation(KrystalCore.ID, "count");
    public static <T extends Item> NonNullBiConsumer<DataGenContext<Item, T>, RegistrateItemModelProvider> compatItem(String type, String material) {
        return (c, p) -> p.withExistingParent(c.getName(), "item/generated").texture("layer0", p.modLoc("item/" + type + "/" + material));
    }
    public static <T extends Item> NonNullBiConsumer<DataGenContext<Item, T>, RegistrateItemModelProvider> tagNotifier() {
        return (c, p) -> p.withExistingParent(c.getName(), "item/generated").texture("layer0", p.modLoc("item/missing_tag_notifier"));
    }
    public static <T extends Item> NonNullBiConsumer<DataGenContext<Item, T>, RegistrateItemModelProvider> countedFiveTimes(String type, String material) {
        return (c, p) -> p.withExistingParent(c.getName(), "item/generated").texture("layer0", p.modLoc("item/" + type + "/" + "count4/" + material))
                .override()
                .predicate(count, 0.00000f).model(p.withExistingParent("item/" + type + "/" + material +  "_0", "item/generated").texture("layer0", p.modLoc("item/" + type + "/" + "count0/" + material))).end()
                .override()
                .predicate(count, 0.03125f).model(p.withExistingParent("item/" + type + "/" + material +  "_1", "item/generated").texture("layer0", p.modLoc("item/" + type + "/" + "count1/" + material))).end()
                .override()
                .predicate(count, 0.25000f).model(p.withExistingParent("item/" + type + "/" + material +  "_2", "item/generated").texture("layer0", p.modLoc("item/" + type + "/" + "count2/" + material))).end()
                .override()
                .predicate(count, 0.50000f).model(p.withExistingParent("item/" + type + "/" + material +  "_3", "item/generated").texture("layer0", p.modLoc("item/" + type + "/" + "count3/" + material))).end()
                .override()
                .predicate(count, 1.00000f).model(p.withExistingParent("item/" + type + "/" + material +  "_4", "item/generated").texture("layer0", p.modLoc("item/" + type + "/" + "count4/" + material))).end();
    }
    public static <T extends Item> NonNullBiConsumer<DataGenContext<Item, T>, RegistrateItemModelProvider> countedFourTimes(String type, String material) {
        return (c, p) -> p.withExistingParent(c.getName(), "item/generated").texture("layer0", p.modLoc("item/" + type + "/" + "count3/" + material))
                .override()
                .predicate(count, 0.00000f).model(p.withExistingParent("item/" + type + "/" + material +  "_0", "item/generated").texture("layer0", p.modLoc("item/" + type + "/" + "count0/" + material))).end()
                .override()
                .predicate(count, 0.25000f).model(p.withExistingParent("item/" + type + "/" + material +  "_1", "item/generated").texture("layer0", p.modLoc("item/" + type + "/" + "count1/" + material))).end()
                .override()
                .predicate(count, 0.50000f).model(p.withExistingParent("item/" + type + "/" + material +  "_2", "item/generated").texture("layer0", p.modLoc("item/" + type + "/" + "count2/" + material))).end()
                .override()
                .predicate(count, 1.00000f).model(p.withExistingParent("item/" + type + "/" + material +  "_3", "item/generated").texture("layer0", p.modLoc("item/" + type + "/" + "count3/" + material))).end();
    }
}
