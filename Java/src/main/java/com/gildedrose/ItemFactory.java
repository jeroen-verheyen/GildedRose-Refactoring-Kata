package com.gildedrose;

import com.gildedrose.item.AgedBrieItem;
import com.gildedrose.item.BackstageItem;
import com.gildedrose.item.ConjuredItem;
import com.gildedrose.item.DefaultItem;
import com.gildedrose.item.ItemI;
import com.gildedrose.item.SulfurasItem;
import org.apache.commons.lang3.StringUtils;

public class ItemFactory {

    public ItemI getItem(Item item) {
        if (StringUtils.equals(item.name, GildenRoseConstants.AGED_BRIE)) {
            return new AgedBrieItem(item);
        }

        // seems more logical to do it based on what the name starts with, rather thn an equals; idk
        if (StringUtils.startsWith(item.name, GildenRoseConstants.CONJURED_PREFIX)) {
            return new ConjuredItem(item);
        }

        if (StringUtils.startsWith(item.name, GildenRoseConstants.BACKSTAGE_PASS)) {
            return new BackstageItem(item);
        }

        if (StringUtils.startsWith(item.name, GildenRoseConstants.SULFURAS)) {
            return new SulfurasItem(item);
        }

        return new DefaultItem(item);

//        switch (item.name) {
//            case GildenRoseConstants.AGED_BRIE:
//                return new AgedBrieItem(item);
//            case GildenRoseConstants.BACKSTAGE_PASS:
//                return new BackstageItem(item);
//            case GildenRoseConstants.SULFURAS:
//                return new SulfurasItem(item);
//            case GildenRoseConstants.CONJURED_PREFIX:
//                return new ConjuredItem(item);
//            default:
//                return new DefaultItem(item);
//        }
    }
}
