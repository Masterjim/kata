package be.jeremy.gildedrose.updater.quality;

import be.jeremy.gildedrose.Item;

class ConjuredQualityUpdater implements ItemQualityUpdater {

    public void updateQuality(Item item) {
        if (item.quality > 0) {
            if (item.sellIn > 0) {
                item.quality = getDecreasedQualityOrMin(item.quality, 2);
            } else {
                item.quality = getDecreasedQualityOrMin(item.quality, 4);
            }
        }
    }

    private int getDecreasedQualityOrMin(int quality, int i) {
        int newQuality = quality - i;
        return newQuality > 0 ? newQuality : 0;
    }

}
