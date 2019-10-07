package com.github.smeny.gildedrose;

import com.github.smeny.gildedrose.items.AgedBrie;
import com.github.smeny.gildedrose.items.BackstagePass;
import com.github.smeny.gildedrose.items.Conjured;
import com.github.smeny.gildedrose.items.Sulfuras;

class QualityItemFactory {

    private QualityItemFactory() {
    }

    static QualityItem buildQualityItem(Item item) {
        if (AgedBrie.NAME.equals(item.name)) {
            return new AgedBrie(item);
        } else if (Sulfuras.NAME.equals(item.name)) {
            return new Sulfuras(item);
        } else if (BackstagePass.NAME.equals(item.name)) {
            return new BackstagePass(item);
        } else if (item.name.contains(Conjured.NAME)) {
            return new Conjured(item);
        }
        return new QualityItem(item);
    }

}
