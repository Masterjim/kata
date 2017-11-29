package be.jeremy.gildedrose.updater.quality;

import org.junit.Test;

import static be.jeremy.gildedrose.ItemConstants.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ItemQualityUpdaterFactoryTest {

    private static final String FOO = "foo";

    private ItemQualityUpdaterFactory itemQualityUpdaterFactory = new ItemQualityUpdaterFactory();

    @Test
    public void shouldReturnAnAgedBrieQualityUpdater(){
        assertThat(itemQualityUpdaterFactory.getQualityUpdater(AGED_BRIE))
                .isInstanceOf(AgedBrieQualityUpdater.class);
    }

    @Test
    public void shouldReturnABackstageQualityUpdater(){
        assertThat(itemQualityUpdaterFactory.getQualityUpdater(BACKSTAGE))
                .isInstanceOf(BackstageQualityUpdater.class);
    }

    @Test
    public void shouldReturnASulfurasQualityUpdater(){
        assertThat(itemQualityUpdaterFactory.getQualityUpdater(SULFURAS))
                .isInstanceOf(SulfurasQualityUpdater.class);
    }

    @Test
    public void shouldReturnAConjuredQualityUpdater(){
        assertThat(itemQualityUpdaterFactory.getQualityUpdater(CONJURED))
                .isInstanceOf(ConjuredQualityUpdater.class);
    }

    @Test
    public void shouldReturnAMiscellaneousQualityUpdater() {
        assertThat(itemQualityUpdaterFactory.getQualityUpdater(FOO))
                .isInstanceOf(MiscellaneousItemQualityUpdater.class);
    }
}