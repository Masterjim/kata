package be.jeremy.gildedrose.updater.quality;

import be.jeremy.gildedrose.Item;
import org.junit.Test;

import static be.jeremy.gildedrose.ItemBuilder.anItem;
import static be.jeremy.gildedrose.ItemConstants.*;
import static org.assertj.core.api.Assertions.assertThat;

public class BackstageQualityUpdaterTest {

    private static final int QUALITY = 10;
    private static final int SELL_IN = 12;
    private static final String FOO = "foo";
    private static final int NEAR_MAX_QUALITY = 49;

    private BackstageQualityUpdater itemQualityUpdater = new BackstageQualityUpdater();

    @Test
    public void shouldIncrementQuality_whenUpdateQualityOfBackstage() {
        Item anItem = anItem()
                .withName(BACKSTAGE)
                .withQuality(QUALITY)
                .withSellIn(SELL_IN)
                .build();

        itemQualityUpdater.updateQuality(anItem);

        assertThat(anItem.name).isEqualTo(BACKSTAGE);
        assertThat(anItem.sellIn).isEqualTo(SELL_IN);
        assertThat(anItem.quality).isEqualTo(QUALITY + 1);
    }

    @Test
    public void shouldNotIncrementQuality_whenUpdateQualityOfBackstageWithQualitySetToMax() {
        Item anItem = anItem()
                .withName(BACKSTAGE)
                .withQuality(NORMAL_MAX_QUALITY)
                .withSellIn(SELL_IN)
                .build();

        itemQualityUpdater.updateQuality(anItem);

        assertThat(anItem.name).isEqualTo(BACKSTAGE);
        assertThat(anItem.sellIn).isEqualTo(SELL_IN);
        assertThat(anItem.quality).isEqualTo(NORMAL_MAX_QUALITY);
    }

    @Test
    public void shouldIncreaseByTwoQuality_whenUpdateQualityOfABackstageWithSellInBetweenSixAndTenDays() {
        Item anItem = anItem()
                .withName(BACKSTAGE)
                .withQuality(QUALITY)
                .withSellIn(TEN_DAYS)
                .build();

        itemQualityUpdater.updateQuality(anItem);

        assertThat(anItem.name).isEqualTo(BACKSTAGE);
        assertThat(anItem.sellIn).isEqualTo(TEN_DAYS);
        assertThat(anItem.quality).isEqualTo(QUALITY + 2);
    }

    @Test
    public void shouldIncreaseByTwoButNoHigherThanMax_whenUpdateQualityOfABackstageWithSellInBetweenSixAndTenDays() {
        Item anItem = anItem()
                .withName(BACKSTAGE)
                .withQuality(NEAR_MAX_QUALITY)
                .withSellIn(TEN_DAYS)
                .build();

        itemQualityUpdater.updateQuality(anItem);

        assertThat(anItem.name).isEqualTo(BACKSTAGE);
        assertThat(anItem.sellIn).isEqualTo(TEN_DAYS);
        assertThat(anItem.quality).isEqualTo(NORMAL_MAX_QUALITY);
    }

    @Test
    public void shouldIncreaseByThreeQuality_whenUpdateQualityOfABackstageWithSellInBetweenOneAndFiveDays() {
        Item anItem = anItem()
                .withName(BACKSTAGE)
                .withQuality(QUALITY)
                .withSellIn(FIVE_DAYS)
                .build();

        itemQualityUpdater.updateQuality(anItem);

        assertThat(anItem.name).isEqualTo(BACKSTAGE);
        assertThat(anItem.sellIn).isEqualTo(FIVE_DAYS);
        assertThat(anItem.quality).isEqualTo(QUALITY + 3);
    }

    @Test
    public void shouldIncreaseByThreeButNoHigherThanMax_whenUpdateQualityOfABackstageWithSellInBetweenOneAndFiveDays() {
        Item anItem = anItem()
                .withName(BACKSTAGE)
                .withQuality(NEAR_MAX_QUALITY)
                .withSellIn(FIVE_DAYS)
                .build();

        itemQualityUpdater.updateQuality(anItem);

        assertThat(anItem.name).isEqualTo(BACKSTAGE);
        assertThat(anItem.sellIn).isEqualTo(FIVE_DAYS);
        assertThat(anItem.quality).isEqualTo(NORMAL_MAX_QUALITY);
    }

    @Test
    public void shouldSetQualityToZero_whenUpdateQualityOfBackstageWithSellInLessThanOrEqualToZeroDays() {
        Item anItem = anItem()
                .withName(BACKSTAGE)
                .withQuality(QUALITY)
                .withSellIn(0)
                .build();

        itemQualityUpdater.updateQuality(anItem);

        assertThat(anItem.name).isEqualTo(BACKSTAGE);
        assertThat(anItem.quality).isEqualTo(0);
        assertThat(anItem.sellIn).isEqualTo(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentException_whenUpdateQualityOfAnUnknownItem() {
        Item anItem = anItem()
                .withName(FOO)
                .build();

        itemQualityUpdater.updateQuality(anItem);

    }
}