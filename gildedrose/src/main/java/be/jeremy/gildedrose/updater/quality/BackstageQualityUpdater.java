package be.jeremy.gildedrose.updater.quality;

import be.jeremy.gildedrose.Item;

import static be.jeremy.gildedrose.ItemConstants.*;

class BackstageQualityUpdater implements ItemQualityUpdater {

    public void updateQuality(Item item) {
        if (!item.name.equals(BACKSTAGE)) {
            throw new IllegalArgumentException("Item is not an Backstage!!!");
        }
        if (item.quality < NORMAL_MAX_QUALITY) {
            if (item.sellIn > TEN_DAYS) {
                item.quality = getIncreasedQualityOrMaxByStep(item.quality, 1);
            } else if (item.sellIn > FIVE_DAYS) {
                item.quality = getIncreasedQualityOrMaxByStep(item.quality, 2);
            } else if (item.sellIn > 0) {
                item.quality = getIncreasedQualityOrMaxByStep(item.quality, 3);
            } else
                item.quality = 0;
        }
    }

    private int getIncreasedQualityOrMaxByStep(int quality, int i) {
        int newQuality = quality + i;
        return newQuality < NORMAL_MAX_QUALITY ? newQuality : NORMAL_MAX_QUALITY ;
    }
}
