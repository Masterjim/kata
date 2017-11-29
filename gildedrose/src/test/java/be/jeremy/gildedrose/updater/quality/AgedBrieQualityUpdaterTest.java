package be.jeremy.gildedrose.updater.quality;

import be.jeremy.gildedrose.Item;
import org.junit.Test;

import static be.jeremy.gildedrose.ItemBuilder.anItem;
import static be.jeremy.gildedrose.ItemConstants.AGED_BRIE;
import static be.jeremy.gildedrose.ItemConstants.NORMAL_MAX_QUALITY;
import static org.assertj.core.api.Assertions.assertThat;

public class AgedBrieQualityUpdaterTest {

    private static final int QUALITY = 10;
    private static final int SELL_IN = 12;
    private static final String FOO = "foo";
    private static final int NEAR_MAX_QUALITY = 49;

    private AgedBrieQualityUpdater itemQualityUpdater = new AgedBrieQualityUpdater();

    @Test
    public void shoudIncrementQuality_whenUpdateQualityOfAnAgedBrie() {
        Item anItem = anItem()
                .withName(AGED_BRIE)
                .withQuality(QUALITY)
                .withSellIn(SELL_IN)
                .build();

        itemQualityUpdater.updateQuality(anItem);

        assertThat(anItem.name).isEqualTo(AGED_BRIE);
        assertThat(anItem.sellIn).isEqualTo(SELL_IN);
        assertThat(anItem.quality).isEqualTo(QUALITY + 1);
    }

    @Test
    public void shouldIncreaseByTwo_whenUpdateQualityOfAnAgedBrieWithPassedSellIn() {
        Item anItem = anItem()
                .withName(AGED_BRIE)
                .withQuality(QUALITY)
                .withSellIn(0)
                .build();

        itemQualityUpdater.updateQuality(anItem);

        assertThat(anItem.name).isEqualTo(AGED_BRIE);
        assertThat(anItem.sellIn).isEqualTo(0);
        assertThat(anItem.quality).isEqualTo(QUALITY + 2);
    }

    @Test
    public void shouldNotIncreaseQuality_whenUpdateQualityOfAnAgedBrieWithQualitySetToMax() {
        Item anItem = anItem()
                .withName(AGED_BRIE)
                .withQuality(NORMAL_MAX_QUALITY)
                .withSellIn(SELL_IN)
                .build();

        itemQualityUpdater.updateQuality(anItem);

        assertThat(anItem.name).isEqualTo(AGED_BRIE);
        assertThat(anItem.sellIn).isEqualTo(SELL_IN);
        assertThat(anItem.quality).isEqualTo(NORMAL_MAX_QUALITY);
    }

    @Test
    public void shouldIncreaseButNotHigherThanMax_whenUpdateQualityOfAnAgedBrieWithPassedSellIn() {
        Item anItem = anItem()
                .withName(AGED_BRIE)
                .withQuality(NEAR_MAX_QUALITY)
                .withSellIn(0)
                .build();

        itemQualityUpdater.updateQuality(anItem);

        assertThat(anItem.name).isEqualTo(AGED_BRIE);
        assertThat(anItem.sellIn).isEqualTo(0);
        assertThat(anItem.quality).isEqualTo(NORMAL_MAX_QUALITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowAnIllegalArgumentExceptionWhenUpdateQualityOfUnknownItem() {
        Item anItem = anItem()
                .withName(FOO)
                .build();

        itemQualityUpdater.updateQuality(anItem);
    }
}