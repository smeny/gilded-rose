package com.github.smeny.gildedrose.items;

import com.github.smeny.gildedrose.Item;
import com.github.smeny.gildedrose.QualityItem;

public class BackstagePass extends QualityItem {

    public static final String NAME = "Backstage passes to a TAFKAL80ETC concert";

    public BackstagePass(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        increaseItemQualityIfUnderMaximum();
        if (itemSellIn() < 11) {
            increaseItemQualityIfUnderMaximum();
        }

        if (itemSellIn() < 6) {
            increaseItemQualityIfUnderMaximum();
        }
    }

    @Override
    protected void updateQualityWhenSellExpired() {
        setQuality(0);
    }
}
