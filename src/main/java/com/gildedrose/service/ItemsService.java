package com.gildedrose.service;

import com.gildedrose.model.Item;

public interface ItemsService {
    void updateQuality(Item item);

    default void updateSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    boolean isApplicable(Item item);
}
