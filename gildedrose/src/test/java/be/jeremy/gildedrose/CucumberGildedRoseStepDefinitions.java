package be.jeremy.gildedrose;

import be.jeremy.gildedrose.updater.ItemUpdater;
import be.jeremy.gildedrose.updater.quality.ItemQualityUpdaterFactory;
import be.jeremy.gildedrose.updater.sellin.ItemSellInUpdater;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CucumberGildedRoseStepDefinitions {

    private GildedRose gildedRose;
    private ItemQualityUpdaterFactory itemUpdaterFactory = new ItemQualityUpdaterFactory();
    private ItemSellInUpdater itemSellInUpdater = new ItemSellInUpdater();
    private ItemUpdater itemUpdater = new ItemUpdater(itemUpdaterFactory, itemSellInUpdater);

    @Given("^an item list for Gilded Rose$")
    public void the_item_list_for_gilded_rose(List<Item> items) {
        gildedRose = new GildedRose(items.toArray(new Item[0]), itemUpdater);
    }

    @When("^the items is updated after one day$")
    public void the_item_list_is_updated() {
        gildedRose.update();
    }

    @Then("^I should see the following list of items$")
    public void the_expected_list_of_items_is(List<Item> items) {
        assertThat(gildedRose.items)
                .usingElementComparatorOnFields("name", "sellIn", "quality")
                .containsOnlyElementsOf(items);
    }
}
