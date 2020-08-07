package com.gildedrose.item;

import com.gildedrose.Item;

public class AgedBrieItem extends DefaultItem {

    public AgedBrieItem(Item item) {
        super(item);
    }

    @Override
    protected int getQualityIncrease() {
        return super.getQualityIncrease() * -1;
    }
}
