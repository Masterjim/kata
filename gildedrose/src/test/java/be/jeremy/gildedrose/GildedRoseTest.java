package be.jeremy.gildedrose;

import be.jeremy.gildedrose.updater.ItemUpdater;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static be.jeremy.gildedrose.ItemBuilder.anItem;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@RunWith(MockitoJUnitRunner.class)
public class GildedRoseTest {

    private Item anItem, anotherItem;

    @Mock
    private ItemUpdater itemUpdater;

    private GildedRose gildedRose;

    @Before
    public void setUp() {
        anItem = anItem().build();
        anotherItem = anItem().build();

        gildedRose = new GildedRose(new Item[] {anItem, anotherItem}, itemUpdater);
    }

    @Test
    public void shouldUpdateItems() {
        gildedRose.update();

        verify(itemUpdater).update(anItem);
        verify(itemUpdater).update(anotherItem);
        verifyNoMoreInteractions(itemUpdater);
    }

}
