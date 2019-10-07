package com.github.smeny;

class QualityItem {

    private static final int ITEM_MINIMUM_QUALITY = 0;
    private static final int ITEM_MAXIMUM_QUALITY = 50;

    Item item;

    QualityItem(Item item) {
        this.item = item;
    }

    void updateQuality() {
        decreaseItemQualityIfOverMinimum();
    }

    void decreaseSellInDays() {
        item.sellIn--;
        if (item.sellIn < 0) {
            updateQualityWhenSellExpired();
        }
    }

    protected void increaseItemQualityIfUnderMaximum() {
        if (item.quality < ITEM_MAXIMUM_QUALITY) {
            item.quality++;
        }
    }

    protected void decreaseItemQualityIfOverMinimum() {
        if (item.quality > ITEM_MINIMUM_QUALITY) {
            item.quality--;
        }
    }

    protected void updateQualityWhenSellExpired() {
        decreaseItemQualityIfOverMinimum();
    }
}
