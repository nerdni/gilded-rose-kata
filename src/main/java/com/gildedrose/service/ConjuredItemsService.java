package com.gildedrose.service;

import com.gildedrose.model.Item;
import com.gildedrose.model.ItemTypeEnum;

public class ConjuredItemsService implements ItemsService {

    @Override
    public void updateQuality(Item item) {
        if (item.sellIn > 0) {
            item.quality = calculateQualityForTomorrow(item, 2);
        } else {
            item.quality = calculateQualityForTomorrow(item, 4);
        }
    }

    @Override
    public boolean isApplicable(Item item) {
        return ItemTypeEnum.CONJURED_ITEM.getName().equals(item.name);
    }

    private int calculateQualityForTomorrow(Item item, int subtractFromQuality) {
        int finalQuality = item.quality - subtractFromQuality;
        return Math.max(finalQuality, 0);
    }
}
