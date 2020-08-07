package com.gildedrose.item;

import com.gildedrose.Item;

public class ConjuredItem extends DefaultItem{

    public ConjuredItem(Item item) {
        super(item);
    }

    @Override
    protected int getQualityIncrease() {
        return 2;
    }
}
