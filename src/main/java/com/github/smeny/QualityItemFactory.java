package com.github.smeny;

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
            default:
                return new QualityItem(item);
        }
    }

}
