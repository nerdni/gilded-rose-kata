package com.gildedrose.service;

import com.gildedrose.model.Item;
import com.gildedrose.model.ItemTypeEnum;

public class TicketsService implements ItemsService {

    @Override
    public void updateQuality(Item item) {
        if (item.sellIn > 0) {
            if (item.sellIn <= 5) {
                item.quality = calculateQualityForTomorrow(item, 3);
            } else if (item.sellIn <= 10) {
                item.quality = calculateQualityForTomorrow(item, 2);
            } else {
                item.quality = calculateQualityForTomorrow(item, 1);
            }
        } else {
            item.quality = 0;
        }
    }

    @Override
    public boolean isApplicable(Item item) {
        return ItemTypeEnum.BACKSTAGE_PASSES.getName().equals(item.name);
    }

    private int calculateQualityForTomorrow(Item item, int increaseQualityBy) {
        int finalQuality = item.quality + increaseQualityBy;
        return Math.min(finalQuality, 50);
    }
}
