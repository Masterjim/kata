package be.jeremy.gildedrose;

import org.junit.Test;

import static be.jeremy.gildedrose.ItemBuilder.anItem;
import static org.assertj.core.api.Assertions.assertThat;

public class ItemBuilderTest {

    private static final String NAME = "name";
    private static final int QUALITY = 10;
    private static final int SELL_IN = 12;

    @Test
    public void build() {
        Item actual = anItem()
                .withName(NAME)
                .withQuality(QUALITY)
                .withSellIn(SELL_IN)
                .build();

        assertThat(actual.name).isEqualTo(NAME);
        assertThat(actual.quality).isEqualTo(QUALITY);
        assertThat(actual.sellIn).isEqualTo(SELL_IN);
    }
}