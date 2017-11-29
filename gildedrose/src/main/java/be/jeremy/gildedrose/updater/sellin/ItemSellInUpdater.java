package be.jeremy.gildedrose.updater.sellin;

import be.jeremy.gildedrose.Item;

import static be.jeremy.gildedrose.ItemConstants.SULFURAS;

public class ItemSellInUpdater {

    public void updateSellIn(Item item) {
        if (!item.name.equals(SULFURAS)) {
            item.sellIn = item.sellIn - 1;
        }
    }
}
