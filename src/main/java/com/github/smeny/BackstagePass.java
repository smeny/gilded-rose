package com.github.smeny;

class BackstagePass extends QualityItem {

    static final String NAME = "Backstage passes to a TAFKAL80ETC concert";

    BackstagePass(Item item) {
        super(item);
    }

    @Override
    protected void updateQuality() {
        increaseItemQualityIfUnderMaximum();
        if (item.sellIn < 11) {
            increaseItemQualityIfUnderMaximum();
        }

        if (item.sellIn < 6) {
            increaseItemQualityIfUnderMaximum();
        }
    }

    @Override
    protected void updateQualityWhenSellExpired() {
        item.quality = 0;
    }
}
