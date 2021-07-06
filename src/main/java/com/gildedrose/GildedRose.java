package com.gildedrose;

import com.gildedrose.model.Item;
import com.gildedrose.service.ItemsService;

import java.util.List;

class GildedRose {

    public static void updateItemsAfterDay(List<Item> items) {
        for (Item item : items) {
            updateItemFields(item);
        }
    }

    private static void updateItemFields(Item item) {
        ItemsService service = ItemServiceResolver.resolveItemService(item);
        service.updateSellIn(item);
        service.updateQuality(item);
    }
}
