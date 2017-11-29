Feature: GildedRose

    Scenario: Update quality of some items
        Given an item list for Gilded Rose
            | name                                      | sellIn | quality |
            | +5 Dexterity Vest                         |     10 |      20 |
            | Aged Brie                                 |      2 |       0 |
            | Aged Brie                                 |     10 |      50 |
            | Aged Brie                                 |      0 |      49|
            | Sulfuras, Hand of Ragnaros                |      0 |      80 |
            | Sulfuras, Hand of Ragnaros                |     -1 |      80 |
            | Backstage passes to a TAFKAL80ETC concert |     15 |      20 |
            | Backstage passes to a TAFKAL80ETC concert |     10 |      49 |
            | Backstage passes to a TAFKAL80ETC concert |      5 |      49 |
            | Backstage passes to a TAFKAL80ETC concert |      3 |      50 |
            | Conjured Mana Cake                        |      3 |       6 |
            | Conjured Mana Cake                        |      0 |       2 |
        When the items is updated after one day
        Then I should see the following list of items
            | name                                      | sellIn | quality |
            | +5 Dexterity Vest                         |      9 |      19 |
            | Aged Brie                                 |      1 |       1 |
            | Aged Brie                                 |      9 |      50 |
            | Aged Brie                                 |     -1 |      50 |
            | Sulfuras, Hand of Ragnaros                |      0 |      80 |
            | Sulfuras, Hand of Ragnaros                |     -1 |      80 |
            | Backstage passes to a TAFKAL80ETC concert |     14 |      21 |
            | Backstage passes to a TAFKAL80ETC concert |      9 |      50 |
            | Backstage passes to a TAFKAL80ETC concert |      4 |      50 |
            | Backstage passes to a TAFKAL80ETC concert |      2 |      50 |
            | Conjured Mana Cake                        |      2 |       4 |
            | Conjured Mana Cake                        |     -1 |       0 |
