package be.jeremy.gildedrose.updater;

import be.jeremy.gildedrose.Item;
import be.jeremy.gildedrose.updater.ItemUpdater;
import be.jeremy.gildedrose.updater.quality.ItemQualityUpdater;
import be.jeremy.gildedrose.updater.quality.ItemQualityUpdaterFactory;
import be.jeremy.gildedrose.updater.sellin.ItemSellInUpdater;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static be.jeremy.gildedrose.ItemBuilder.anItem;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ItemUpdaterTest {

    private static final String FOO = "foo";

    @Mock
    private ItemQualityUpdaterFactory itemQualityUpdaterFactory;
    @Mock
    private ItemQualityUpdater itemQualityUpdater;
    @Mock
    private ItemSellInUpdater itemSellInUpdater;

    private Item item;

    private ItemUpdater itemUpdater;

    @Before
    public void setUp() {
        item = anItem()
                .withName(FOO)
                .build();

        when(itemQualityUpdaterFactory.getQualityUpdater(FOO)).thenReturn(itemQualityUpdater);

        itemUpdater = new ItemUpdater(itemQualityUpdaterFactory, itemSellInUpdater);
    }

    @Test
    public void shouldUpdateQualityAndSellIn() {
        itemUpdater.update(item);

        verify(itemQualityUpdater).updateQuality(item);
        verify(itemSellInUpdater).updateSellIn(item);
        verifyNoMoreInteractions(itemQualityUpdater, itemSellInUpdater);
    }
}