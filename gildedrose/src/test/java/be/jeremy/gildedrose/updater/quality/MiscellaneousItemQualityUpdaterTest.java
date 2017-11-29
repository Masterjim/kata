package be.jeremy.gildedrose.updater.quality;

import be.jeremy.gildedrose.Item;
import org.junit.Test;

import static be.jeremy.gildedrose.ItemBuilder.anItem;
import static org.assertj.core.api.Assertions.assertThat;

public class MiscellaneousItemQualityUpdaterTest {

    private static final String FOO = "foo";
    private static final int QUALITY = 12;
    private static final int SELL_IN = 10;
    private static final int NEAR_MIN_QUALITY = 1;

    private MiscellaneousItemQualityUpdater itemQualityUpdater = new MiscellaneousItemQualityUpdater();

    @Test
    public void shouldDecrementQuality_whenUpdateQualityOfAnItem() {
        Item anItem = anItem()
                .withName(FOO)
                .withQuality(QUALITY)
                .withSellIn(SELL_IN)
                .build();

        itemQualityUpdater.updateQuality(anItem);

        assertThat(anItem.name).isEqualTo(FOO);
        assertThat(anItem.sellIn).isEqualTo(SELL_IN);
        assertThat(anItem.quality).isEqualTo(QUALITY - 1);
    }

    @Test
    public void shouldNotDecrementQuality_whenUpdateQualityOfAnItemWithQualitySetToZero() {
        Item anItem = anItem()
                .withName(FOO)
                .withQuality(0)
                .withSellIn(SELL_IN)
                .build();

        itemQualityUpdater.updateQuality(anItem);

        assertThat(anItem.name).isEqualTo(FOO);
        assertThat(anItem.sellIn).isEqualTo(SELL_IN);
        assertThat(anItem.quality).isEqualTo(0);
    }

    @Test
    public void shouldDecreaseQualityByTwo_whenUpdateQualityOfAnItemWithPassedSellIn() {
        Item anItem = anItem()
                .withName(FOO)
                .withQuality(QUALITY)
                .withSellIn(0)
                .build();

        itemQualityUpdater.updateQuality(anItem);

        assertThat(anItem.name).isEqualTo(FOO);
        assertThat(anItem.sellIn).isEqualTo(0);
        assertThat(anItem.quality).isEqualTo(QUALITY - 2);
    }

    @Test
    public void shouldDecreaseQualityButNotLowerThanZero_whenUpdateQualityOfAnItemWithPassedSellIn() {
        Item anItem = anItem()
                .withName(FOO)
                .withQuality(NEAR_MIN_QUALITY)
                .withSellIn(0)
                .build();

        itemQualityUpdater.updateQuality(anItem);

        assertThat(anItem.name).isEqualTo(FOO);
        assertThat(anItem.sellIn).isEqualTo(0);
        assertThat(anItem.quality).isEqualTo(0);
    }
}