package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void defaultBehavour() {
        List<Item> items = Arrays.asList(
                new Item("foo", 5, 3)
        );
        GildedRose app = getGildedRose(items);

        Item actual = app.getItems()[0];

        assertItem(actual, "foo", 4, 2);
    }

    @Test
    void qualityCantDropUnderZero() {
        List<Item> items = Arrays.asList(
                new Item("foo", 3, 0)
        );
        GildedRose app = getGildedRose(items);

        Item actual = app.getItems()[0];

        assertItem(actual, "foo", 2, 0);
    }

    @Test
    void sellinCanDropUnderZero() {
        List<Item> items = Arrays.asList(
                new Item("foo", 0, 0)
        );
        GildedRose app = getGildedRose(items);

        Item actual = app.getItems()[0];

        assertItem(actual, "foo", -1, 0);
    }

    @Test
    void qualityDegradesFasterOnceSellByDatePassed() {
        List<Item> items = Arrays.asList(
                new Item("foo", 0, 20)
        );
        GildedRose app = getGildedRose(items);

        Item actual = app.getItems()[0];

        assertItem(actual, "foo", -1, 18);
    }

    @Test
    void agedBrieIncreasesInQualityTheOlderItGets() {
        List<Item> items = Arrays.asList(
                new Item(GildenRoseConstants.AGED_BRIE, 10, 20)
        );
        GildedRose app = getGildedRose(items);

        Item actual = app.getItems()[0];

        assertItem(actual, GildenRoseConstants.AGED_BRIE, 9, 21);
    }

    @Test
    void backstagePassesIncreasesInQualityTheOlderItGets() {
        List<Item> items = Arrays.asList(
                new Item(GildenRoseConstants.BACKSTAGE_PASS, 15, 30)
        );
        GildedRose app = getGildedRose(items);

        Item actual = app.getItems()[0];

        assertItem(actual, GildenRoseConstants.BACKSTAGE_PASS, 14, 31);
    }


    @Test
    void backstagePassesIncreasesQualityByTwoWhenSellInIsTenDaysOrLess() {
        List<Item> items = Arrays.asList(
                new Item(GildenRoseConstants.BACKSTAGE_PASS, 10, 30)
        );
        GildedRose app = getGildedRose(items);

        Item actual = app.getItems()[0];

        assertItem(actual, GildenRoseConstants.BACKSTAGE_PASS, 9, 32);
    }

    @Test
    void backstagePassesIncreasesQualityByThreeWhenSellInIsFiveDaysOrLess() {
        List<Item> items = Arrays.asList(
                new Item(GildenRoseConstants.BACKSTAGE_PASS, 5, 30)
        );
        GildedRose app = getGildedRose(items);

        Item actual = app.getItems()[0];

        assertItem(actual, GildenRoseConstants.BACKSTAGE_PASS, 4, 33);
    }

    @Test
    void backstagePassesQualityDropsToZeroAfterConcert() {
        List<Item> items = Arrays.asList(
                new Item(GildenRoseConstants.BACKSTAGE_PASS, 0, 30)
        );
        GildedRose app = getGildedRose(items);

        Item actual = app.getItems()[0];

        assertItem(actual, GildenRoseConstants.BACKSTAGE_PASS, -1, 0);
    }

    @Test
    void backstagePassesQualityDoNotDropToZeroRightBeforeConcert() {
        List<Item> items = Arrays.asList(
                new Item(GildenRoseConstants.BACKSTAGE_PASS, 1, 30)
        );
        GildedRose app = getGildedRose(items);

        Item actual = app.getItems()[0];

        assertItem(actual, GildenRoseConstants.BACKSTAGE_PASS, 0, 33);
    }

    @Test
    void sulfurasDoesNotDecreaseInQuality() {
        List<Item> items = Arrays.asList(
                new Item(GildenRoseConstants.SULFURAS, 10, 40)
        );
        GildedRose app = getGildedRose(items);

        Item actual = app.getItems()[0];

        assertItem(actual, GildenRoseConstants.SULFURAS, 10, 40);
    }

    @Test
    void sulfurasDoesNotDecreaseInQualityAndCanBeHigherThanFifty() {
        List<Item> items = Arrays.asList(
                new Item(GildenRoseConstants.SULFURAS, 10, 80)
        );
        GildedRose app = getGildedRose(items);

        Item actual = app.getItems()[0];

        assertItem(actual, GildenRoseConstants.SULFURAS, 10, 80);
    }

    @Test
    void conjuredItemsDegradeTwiceAsFastInQuality() {
        List<Item> items = Arrays.asList(
                new Item(GildenRoseConstants.CONJURED_PREFIX + "test", 10, 30)
        );
        GildedRose app = getGildedRose(items);

        Item actual = app.getItems()[0];

        assertItem(actual, GildenRoseConstants.CONJURED_PREFIX + "test", 9, 28);
    }


    private GildedRose getGildedRose(List<Item> items) {
        Item[] objects = items.toArray(new Item[0]);

        GildedRose app = new GildedRose(objects);
        app.updateQuality();

        return app;
    }

    private void assertItem(Item actual, String name, int sellin, int quality) {
        assertEquals(name, actual.name);
        assertEquals(sellin, actual.sellIn);
        assertEquals(quality, actual.quality);
    }

}
