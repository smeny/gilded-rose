package com.github.smeny;

class AgedBrie extends QualityItem {

    static final String NAME = "Aged Brie";

    AgedBrie(Item item) {
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
