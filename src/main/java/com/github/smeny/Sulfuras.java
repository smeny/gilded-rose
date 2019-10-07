package com.github.smeny;

class Sulfuras extends QualityItem {
    static final String NAME = "Sulfuras, Hand of Ragnaros";
    static final int QUALITY = 80;

    Sulfuras(Item item) {
        super(item);
        item.quality = QUALITY;
    }

    @Override
    void updateQuality() {
        // Sulfuras: Do nothing
    }

    @Override
    void decreaseSellInDays() {
        // Sulfuras: Do nothing
    }

    @Override
    protected void updateQualityWhenSellExpired() {
        // Sulfuras: Do nothing
    }
}
