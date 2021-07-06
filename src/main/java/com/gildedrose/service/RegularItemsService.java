package com.gildedrose.service;

import com.gildedrose.model.Item;
import com.gildedrose.model.ItemTypeEnum;

public class RegularItemsService implements ItemsService {

    @Override
    public void updateQuality(Item item) {
        if (item.sellIn > 0) {
            item.quality = calculateQualityForTomorrow(item, 1);
        } else {
            item.quality = calculateQualityForTomorrow(item, 2);
        }
    }

    @Override
    public boolean isApplicable(Item item) {
        return ItemTypeEnum.REGULAR_ITEM.getName().equals(item.name);
    }

    private int calculateQualityForTomorrow(Item item, int subtractFromQuality) {
        int finalQuality = item.quality - subtractFromQuality;
        return Math.max(finalQuality, 0);
    }
}
