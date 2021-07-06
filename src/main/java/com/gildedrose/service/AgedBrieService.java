package com.gildedrose.service;

import com.gildedrose.model.Item;
import com.gildedrose.model.ItemTypeEnum;

public class AgedBrieService implements ItemsService {

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
        return ItemTypeEnum.AGED_BRIE.getName().equals(item.name);
    }

    private int calculateQualityForTomorrow(Item item, int addToQuality) {
        int finalQuality = item.quality + addToQuality;
        return Math.min(finalQuality, 50);
    }
}
