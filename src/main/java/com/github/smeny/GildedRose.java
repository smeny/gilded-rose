package com.github.smeny;

import static com.github.smeny.QualityItemFactory.buildQualityItem;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            QualityItem qualityItem = buildQualityItem(item);
            qualityItem.updateQuality();
            qualityItem.decreaseSellInDays();
        }
    }

}