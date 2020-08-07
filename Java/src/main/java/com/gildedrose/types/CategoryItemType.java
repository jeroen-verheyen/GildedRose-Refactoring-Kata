package com.gildedrose.types;

import com.gildedrose.GildenRoseConstants;
import com.gildedrose.Item;
import com.gildedrose.item.BackstageItem;
import com.gildedrose.item.ConjuredItem;
import com.gildedrose.item.GildenRoseItem;
import com.gildedrose.item.SulfurasItem;

public enum CategoryItemType {
    CONJURED_ITEM(GildenRoseConstants.CONJURED_PREFIX) {
        @Override
        public GildenRoseItem create(Item item) {
            return new ConjuredItem(item);
        }
    },

    BACKSTAGE_PASS_ITEM(GildenRoseConstants.BACKSTAGE_PASS) {
        @Override
        public GildenRoseItem create(Item item) {
            return new BackstageItem(item);
        }
    },

    SULFURAS_ITEM(GildenRoseConstants.SULFURAS) {
        @Override
        public GildenRoseItem create(Item item) {
            return new SulfurasItem(item);
        }
    };

    private String categoryPrefix;

    CategoryItemType(String categoryPrefix) {
        this.categoryPrefix = categoryPrefix;
    }

    public String getCategoryPrefix() {
        return categoryPrefix;
    }

    public GildenRoseItem create(Item item) {
        return null;
    }
}
