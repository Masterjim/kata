package be.jeremy.gildedrose.updater.sellin;

import be.jeremy.gildedrose.Item;
import org.junit.Test;

import static be.jeremy.gildedrose.ItemBuilder.anItem;
import static be.jeremy.gildedrose.ItemConstants.SULFURAS;
import static org.assertj.core.api.Assertions.assertThat;

public class ItemSellInUpdaterTest {

    private static final String FOO = "foo";
    private static final int SELL_IN = 12;
    private static final int QUALITY = 10;

    private ItemSellInUpdater itemSellInUpdater = new ItemSellInUpdater();

    @Test
    public void shouldDecrementSellIn_whenUpdateSellInOfAnItem() {
        Item item = anItem()
                .withName(FOO)
                .withQuality(QUALITY)
                .withSellIn(SELL_IN)
                .build();

        itemSellInUpdater.updateSellIn(item);

        assertThat(item.name).isEqualTo(FOO);
        assertThat(item.quality).isEqualTo(QUALITY);
        assertThat(item.sellIn).isEqualTo(SELL_IN - 1);
    }

    @Test
    public void shouldNotDecreaseSellIn_whenUpdateSellInOfASulfuras() {
        Item item = anItem()
                .withName(SULFURAS)
                .withQuality(QUALITY)
                .withSellIn(SELL_IN)
                .build();

        itemSellInUpdater.updateSellIn(item);

        assertThat(item.name).isEqualTo(SULFURAS);
        assertThat(item.quality).isEqualTo(QUALITY);
        assertThat(item.sellIn).isEqualTo(SELL_IN);
    }

}