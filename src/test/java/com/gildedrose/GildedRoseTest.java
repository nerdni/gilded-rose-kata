package com.gildedrose;

import com.gildedrose.model.Item;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @ParameterizedTest
    @MethodSource("withSulfuras")
    void testWhenSulfuras(Item initialItem, int expectedSellIn, int expectedQuality) {
        GildedRose.updateItemsAfterDay(List.of(initialItem));

        assertEquals(expectedSellIn, initialItem.sellIn);
        assertEquals(expectedQuality, initialItem.quality);
    }

    @ParameterizedTest
    @MethodSource("withRegularItems")
    void testWhenRegularItems(Item initialItem, int expectedSellIn, int expectedQuality) {
        GildedRose.updateItemsAfterDay(List.of(initialItem));

        assertEquals(expectedSellIn, initialItem.sellIn);
        assertEquals(expectedQuality, initialItem.quality);
    }

    @ParameterizedTest
    @MethodSource("withAgedBrie")
    void testWhenAgedBrie(Item initialItem, int expectedSellIn, int expectedQuality) {
        GildedRose.updateItemsAfterDay(List.of(initialItem));

        assertEquals(expectedSellIn, initialItem.sellIn);
        assertEquals(expectedQuality, initialItem.quality);
    }

    @ParameterizedTest
    @MethodSource("withBackStageTickets")
    void testWhenBackStageTickets(Item initialItem, int expectedSellIn, int expectedQuality) {
        GildedRose.updateItemsAfterDay(List.of(initialItem));

        assertEquals(expectedSellIn, initialItem.sellIn);
        assertEquals(expectedQuality, initialItem.quality);
    }

    @ParameterizedTest
    @MethodSource("withConjuredItems")
    void testWhenConjuredItems(Item initialItem, int expectedSellIn, int expectedQuality) {
        GildedRose.updateItemsAfterDay(List.of(initialItem));

        assertEquals(expectedSellIn, initialItem.sellIn);
        assertEquals(expectedQuality, initialItem.quality);
    }

    private static Stream<Arguments> withAgedBrie() {
        String agedBrie = "Aged Brie";
        return Stream.of(
                Arguments.of(new Item(agedBrie, 10, 0), 9, 1),
                Arguments.of(new Item(agedBrie, 10, 50), 9, 50),
                Arguments.of(new Item(agedBrie, 0, 49), -1, 50),
                Arguments.of(new Item(agedBrie, 0, 10), -1, 12),
                Arguments.of(new Item(agedBrie, 0, 0), -1, 2)
        );
    }

    private static Stream<Arguments> withRegularItems() {
        String regularItem = "Regular item";
        return Stream.of(
                Arguments.of(new Item(regularItem, 10, 0), 9, 0),
                Arguments.of(new Item(regularItem, 10, 10), 9, 9),
                Arguments.of(new Item(regularItem, 0, 10), -1, 8),
                Arguments.of(new Item(regularItem, 0, 0), -1, 0),
                Arguments.of(new Item(regularItem, -1, 1), -2, 0)

        );
    }

    private static Stream<Arguments> withConjuredItems() {
        String regularItem = "Conjured item";
        return Stream.of(
                Arguments.of(new Item(regularItem, 10, 0), 9, 0),
                Arguments.of(new Item(regularItem, 10, 10), 9, 8),
                Arguments.of(new Item(regularItem, 0, 10), -1, 6),
                Arguments.of(new Item(regularItem, 0, 0), -1, 0),
                Arguments.of(new Item(regularItem, -1, 1), -2, 0)
        );
    }

    private static Stream<Arguments> withSulfuras() {
        String sulfuras = "Sulfuras, Hand of Ragnaros";
        return Stream.of(
                Arguments.of(new Item(sulfuras, 0, 80), 0, 80),
                Arguments.of(new Item(sulfuras, 0, 80), 0, 80),
                Arguments.of(new Item(sulfuras, 10, 80), 10, 80)
        );
    }

    private static Stream<Arguments> withBackStageTickets() {
        String backstageTickets = "Backstage passes to a TAFKAL80ETC concert";

        return Stream.of(
                Arguments.of(new Item(backstageTickets, 0, 10), -1, 0),
                Arguments.of(new Item(backstageTickets, 20, 50), 19, 50),
                //10 before concert quality+2
                Arguments.of(new Item(backstageTickets, 10, 0), 9, 2),
                Arguments.of(new Item(backstageTickets, 10, 49), 9, 50),
                //5 before concert quality+3
                Arguments.of(new Item(backstageTickets, 5, 0), 4, 3)
        );
    }
}
