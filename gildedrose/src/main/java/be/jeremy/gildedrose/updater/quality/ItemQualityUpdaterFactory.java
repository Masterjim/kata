package be.jeremy.gildedrose.updater.quality;

import static be.jeremy.gildedrose.ItemConstants.*;

public class ItemQualityUpdaterFactory {

    public ItemQualityUpdater getQualityUpdater(String type) {
        if (type.equals(AGED_BRIE)) {
            return new AgedBrieQualityUpdater();
        } else if (type.equals(SULFURAS)) {
            return new SulfurasQualityUpdater();
        } else if (type.equals(BACKSTAGE)) {
            return new BackstageQualityUpdater();
        } else if (type.equals(CONJURED)) {
            return new ConjuredQualityUpdater();
        }else {
            return new MiscellaneousItemQualityUpdater();
        }
    }
}
