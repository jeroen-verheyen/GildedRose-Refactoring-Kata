package com.gildedrose.item;

import com.gildedrose.Item;

public class BackstageItem extends DefaultItem {

    public BackstageItem(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        if (this.item.sellIn < 0) {
            this.item.quality = 0;
        } else {
            super.updateQuality();
        }
    }

    @Override
    protected int getQualityIncrease() {
        if (this.item.sellIn <= 5) {
            return -3;
        }

        if (this.item.sellIn <= 10) {
            return -2;
        }

        return -1;
    }
}
