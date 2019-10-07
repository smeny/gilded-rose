package com.github.smeny.gildedrose;

import com.github.smeny.gildedrose.items.AgedBrie;
import com.github.smeny.gildedrose.items.BackstagePass;
import com.github.smeny.gildedrose.items.Conjured;
import com.github.smeny.gildedrose.items.Sulfuras;

class QualityItemFactory {

    private QualityItemFactory() {
    }

    static QualityItem buildQualityItem(Item item) {
        switch (item.name) {
            case AgedBrie.NAME:
                return new AgedBrie(item);
            case Sulfuras.NAME:
                return new Sulfuras(item);
            case BackstagePass.NAME:
                return new BackstagePass(item);
            case Conjured.NAME:
                return new Conjured(item);
            default:
                return new QualityItem(item);
        }
    }

}
