package com.github.smeny;

class GildedRose {

    static final String BACKSTAGE_PASS_NAME = "Backstage passes to a TAFKAL80ETC concert";
    static final String AGED_BRIE_NAME = "Aged Brie";
    static final String SULFURAS_NAME = "Sulfuras, Hand of Ragnaros";
    static final int SULFURAS_QUALITY = 80;
    static final int ITEM_MINIMUM_QUALITY = 0;
    static final int ITEM_MAXIMUM_QUALITY = 50;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!item.name.equals(AGED_BRIE_NAME) && !item.name.equals(BACKSTAGE_PASS_NAME)) {
                updateCommonItemQuality(item);
            } else {
                if (item.quality < ITEM_MAXIMUM_QUALITY) {
                    item.quality = item.quality + 1;

                    if (item.name.equals(BACKSTAGE_PASS_NAME)) {
                        if (item.sellIn < 11) {
                            increaseItemQualityIfUnderMaximum(item, 1);
                        }

                        if (item.sellIn < 6) {
                            increaseItemQualityIfUnderMaximum(item, 1);
                        }
                    }
                }
            }

            if (!item.name.equals(SULFURAS_NAME)) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals(AGED_BRIE_NAME)) {
                    if (!item.name.equals(BACKSTAGE_PASS_NAME)) {
                        if (item.quality > 0) {
                            if (!item.name.equals(SULFURAS_NAME)) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        item.quality = 0;
                    }
                } else {
                    if (item.quality < ITEM_MAXIMUM_QUALITY) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }

    private void updateCommonItemQuality(Item item) {
        if (item.quality > 0) {
            if (!item.name.equals(SULFURAS_NAME)) {
                item.quality = item.quality - 1;
            }
        }
    }

    private void increaseItemQualityIfUnderMaximum(Item item, int increment) {
        if (item.quality < ITEM_MAXIMUM_QUALITY) {
            item.quality += increment;
        }
    }
    private void decreaseItemQualityIfOverMinimum(Item item, int decrement) {
        if (item.quality > ITEM_MINIMUM_QUALITY) {
            item.quality -= decrement;
        }
    }

}