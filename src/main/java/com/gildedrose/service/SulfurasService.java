package com.gildedrose.service;

import com.gildedrose.model.Item;
import com.gildedrose.model.ItemTypeEnum;

public class SulfurasService implements ItemsService {

    @Override
    public void updateQuality(Item item) {
    }

    @Override
    public void updateSellIn(Item item) {
    }

    @Override
    public boolean isApplicable(Item item) {
        return ItemTypeEnum.SULFURAS.getName().equals(item.name);
    }


}
