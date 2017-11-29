package be.jeremy.gildedrose.updater.quality;

import be.jeremy.gildedrose.Item;

import static be.jeremy.gildedrose.ItemConstants.SULFURAS;

class SulfurasQualityUpdater implements ItemQualityUpdater {

    public void updateQuality(Item item) {
        if (!item.name.equals(SULFURAS)) {
            throw new IllegalArgumentException("Item is not a Sulfuras!!!");
        }
        // Nothing to do...
    }
}
