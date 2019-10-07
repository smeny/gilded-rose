package com.github.smeny.gildedrose.items;

import com.github.smeny.gildedrose.Item;
import com.github.smeny.gildedrose.QualityItem;

public class Conjured extends QualityItem {

    public static final String NAME = "Conjured";

    public Conjured(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        super.updateQuality();
        super.updateQuality();
    }

    @Override
    protected void updateQualityWhenSellExpired() {
        super.updateQualityWhenSellExpired();
        super.updateQualityWhenSellExpired();
    }
}
