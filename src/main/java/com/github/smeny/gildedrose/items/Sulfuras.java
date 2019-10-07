package com.github.smeny.gildedrose.items;

import com.github.smeny.gildedrose.Item;
import com.github.smeny.gildedrose.QualityItem;

public class Sulfuras extends QualityItem {

    public static final String NAME = "Sulfuras, Hand of Ragnaros";
    public static final int QUALITY = 80;

    public Sulfuras(Item item) {
        super(item);
        setQuality(QUALITY);
    }

    @Override
    protected void updateQuality() {
        // Sulfuras: Do nothing
    }

    @Override
    protected void decreaseSellInDays() {
        // Sulfuras: Do nothing
    }

    @Override
    protected void updateQualityWhenSellExpired() {
        // Sulfuras: Do nothing
    }
}
