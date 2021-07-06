package com.gildedrose.model;

public enum ItemTypeEnum {
    REGULAR_ITEM("Regular item"),
    AGED_BRIE("Aged Brie"),
    SULFURAS("Sulfuras, Hand of Ragnaros"),
    BACKSTAGE_PASSES("Backstage passes to a TAFKAL80ETC concert"),
    CONJURED_ITEM("Conjured item");

    ItemTypeEnum(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }
}
