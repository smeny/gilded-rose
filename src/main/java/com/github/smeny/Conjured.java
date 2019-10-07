package com.github.smeny;

public class Conjured extends QualityItem {

    static final String NAME = "Conjured";

    Conjured(Item item) {
        super(item);
    }

    @Override
    void updateQuality() {
        super.updateQuality();
        super.updateQuality();
    }

    @Override
    protected void updateQualityWhenSellExpired() {
        super.updateQualityWhenSellExpired();
        super.updateQualityWhenSellExpired();
    }
}
