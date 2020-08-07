package com.gildedrose.item;

import com.gildedrose.Item;

public class DefaultItem implements GildenRoseItem {

    protected final Item item;

    public DefaultItem(Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        updateSellIn();
        updateQuality();
    }

    protected void updateQuality() {
        if (this.item.quality > 0) {
            this.item.quality = this.item.quality - getQualityIncrease();
        }
    }

    protected int getQualityIncrease() {
        if (this.item.sellIn <= 0) {
            return 2;
        }

        return 1;
    }

    protected void updateSellIn() {
        this.item.sellIn--;
    }
}
