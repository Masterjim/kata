package be.jeremy.gildedrose.updater;

import be.jeremy.gildedrose.Item;
import be.jeremy.gildedrose.updater.quality.ItemQualityUpdater;
import be.jeremy.gildedrose.updater.quality.ItemQualityUpdaterFactory;
import be.jeremy.gildedrose.updater.sellin.ItemSellInUpdater;

public class ItemUpdater {

    private ItemSellInUpdater itemSellInUpdater;
    private ItemQualityUpdaterFactory itemQualityUpdaterFactory;

    public ItemUpdater(ItemQualityUpdaterFactory itemQualityUpdaterFactory, ItemSellInUpdater itemSellInUpdater) {
        this.itemQualityUpdaterFactory = itemQualityUpdaterFactory;
        this.itemSellInUpdater = itemSellInUpdater;
    }

    public void update(Item item) {
        ItemQualityUpdater qualityUpdater = itemQualityUpdaterFactory.getQualityUpdater(item.name);

        qualityUpdater.updateQuality(item);
        itemSellInUpdater.updateSellIn(item);
    }

}
