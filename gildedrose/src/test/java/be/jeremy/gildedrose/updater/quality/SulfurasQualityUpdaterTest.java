package be.jeremy.gildedrose.updater.quality;

import be.jeremy.gildedrose.Item;
import org.junit.Test;

import static be.jeremy.gildedrose.ItemBuilder.anItem;
import static be.jeremy.gildedrose.ItemConstants.LEGENDARY_QUALITY;
import static be.jeremy.gildedrose.ItemConstants.SULFURAS;
import static org.assertj.core.api.Assertions.assertThat;

public class SulfurasQualityUpdaterTest {

    private static final String FOO = "foo";

    private SulfurasQualityUpdater itemQualityUpdater = new SulfurasQualityUpdater();

    @Test
    public void shouldNotIncreaseQuality_whenUpdateQualityOfASulfurasWithQualitySetToLegendary() {
        Item anItem = anItem()
                .withName(SULFURAS)
                .withQuality(LEGENDARY_QUALITY)
                .withSellIn(0)
                .build();

        itemQualityUpdater.updateQuality(anItem);

        assertThat(anItem.name).isEqualTo(SULFURAS);
        assertThat(anItem.sellIn).isEqualTo(0);
        assertThat(anItem.quality).isEqualTo(LEGENDARY_QUALITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentException_whenUpdateQualityOfAnUnknownItem() {
        Item anItem = anItem()
                .withName(FOO)
                .build();

        itemQualityUpdater.updateQuality(anItem);

    }
}