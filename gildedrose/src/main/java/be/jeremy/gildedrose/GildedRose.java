package be.jeremy.gildedrose;

import be.jeremy.gildedrose.updater.ItemUpdater;

class GildedRose {

    Item[] items;

    private ItemUpdater itemUpdater;


    GildedRose(Item[] items, ItemUpdater itemUpdater) {
        this.items = items;
        this.itemUpdater = itemUpdater;
    }

    void update() {
        for (Item item : items) {
            itemUpdater.update(item);
        }
    }
}