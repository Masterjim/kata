package be.jeremy.gildedrose.updater.quality;

import be.jeremy.gildedrose.Item;

import static be.jeremy.gildedrose.ItemConstants.AGED_BRIE;
import static be.jeremy.gildedrose.ItemConstants.NORMAL_MAX_QUALITY;

class AgedBrieQualityUpdater implements ItemQualityUpdater {

    public void updateQuality(Item item) {
        if (!item.name.equals(AGED_BRIE)) {
            throw new IllegalArgumentException("Item is not an Aged Brie!!!");
        }
        if (item.quality < NORMAL_MAX_QUALITY) {
            if (item.sellIn > 0) {
                item.quality = getIncreasedQualityOrMaxByStep(item.quality, 1);
            } else {
                item.quality = getIncreasedQualityOrMaxByStep(item.quality, 2);
            }
        }
    }

    private int getIncreasedQualityOrMaxByStep(int quality, int i) {
        int newQuality = quality + i;
        return newQuality < NORMAL_MAX_QUALITY ? newQuality : NORMAL_MAX_QUALITY ;
    }
}
