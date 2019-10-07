package com.github.smeny.gildedrose;

public class QualityItem {

    private static final int ITEM_MINIMUM_QUALITY = 0;
    private static final int ITEM_MAXIMUM_QUALITY = 50;

    private Item item;

    public QualityItem(Item item) {
        this.item = item;
    }

    protected int itemSellIn() {
        return item.sellIn;
    }

    protected void setQuality(int quality) {
        item.quality = quality;
    }

    protected void updateQuality() {
        decreaseItemQualityIfOverMinimum();
    }

    protected void decreaseSellInDays() {
        item.sellIn--;
        if (item.sellIn < 0) {
            updateQualityWhenSellExpired();
        }
    }

    protected void updateQualityWhenSellExpired() {
        decreaseItemQualityIfOverMinimum();
    }

    protected final void increaseItemQualityIfUnderMaximum() {
        if (item.quality < ITEM_MAXIMUM_QUALITY) {
            item.quality++;
        }
    }

    protected final void decreaseItemQualityIfOverMinimum() {
        if (item.quality > ITEM_MINIMUM_QUALITY) {
            item.quality--;
        }
    }

}
