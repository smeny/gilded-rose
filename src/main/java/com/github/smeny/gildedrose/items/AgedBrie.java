package com.github.smeny.gildedrose.items;

import com.github.smeny.gildedrose.Item;
import com.github.smeny.gildedrose.QualityItem;

public class AgedBrie extends QualityItem {

    public static final String NAME = "Aged Brie";

    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        increaseItemQualityIfUnderMaximum();
    }

    @Override
    protected void updateQualityWhenSellExpired() {
        increaseItemQualityIfUnderMaximum();
    }

}
