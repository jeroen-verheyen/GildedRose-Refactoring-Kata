package com.gildedrose;

import com.gildedrose.item.DefaultItem;
import com.gildedrose.item.GildenRoseItem;
import com.gildedrose.types.ItemCategoryType;
import com.gildedrose.types.ProductItemType;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Optional;

public class ItemFactory {

    public GildenRoseItem getItem(Item item) {

        Optional<ProductItemType> itemType = getItemType(item);
        if (itemType.isPresent()) {
            return itemType.get().create(item);
        }

        Optional<ItemCategoryType> categoryItemType = getCategoryItem(item);
        if (categoryItemType.isPresent()) {
            return categoryItemType.get().create(item);
        }

        return new DefaultItem(item);
    }

    private Optional<ProductItemType> getItemType(Item item) {
        return Arrays.stream(ProductItemType.values())
                .filter(itemCategoryType -> StringUtils.equals(item.name, itemCategoryType.getName()))
                .findFirst();
    }

    private Optional<ItemCategoryType> getCategoryItem(Item item) {
        return Arrays.stream(ItemCategoryType.values())
                .filter(itemCategoryType -> StringUtils.startsWith(item.name, itemCategoryType.getCategoryPrefix()))
                .findFirst();
    }
}
