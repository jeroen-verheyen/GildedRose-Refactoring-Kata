package com.gildedrose.types;

import com.gildedrose.GildenRoseConstants;
import com.gildedrose.Item;
import com.gildedrose.item.AgedBrieItem;
import com.gildedrose.item.GildenRoseItem;

public enum ProductItemType {
    AGED_BRIE(GildenRoseConstants.AGED_BRIE) {
        @Override
        public GildenRoseItem create(Item item) {
            return new AgedBrieItem(item);
        }
    };

    public GildenRoseItem create(Item item) {
        return null;
    }

    private String name;

    ProductItemType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
