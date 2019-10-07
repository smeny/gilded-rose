package com.github.smeny;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class GildedRoseTest {

    private static final String COMMON_ITEM_NAME = "item";

    @Test
    void common_item_with_positive_sell_in_degrades_quality_by_one() {
        int sellInThirtyDays = 30, quality = 20;
        Item commonItem = new Item(COMMON_ITEM_NAME, sellInThirtyDays, quality);
        GildedRose shop = buildGildedRoseShop(commonItem);

        shop.updateQuality();

        assertThat(firstItem(shop).sellIn, is(sellInThirtyDays - 1));
        assertThat(firstItem(shop).quality, is(quality - 1));
    }


    @Test
    void common_item_with_passed_sell_in_degrades_quality_twice_as_fast() {
        int sellInToday = 0, quality = 20;
        Item commonItem = new Item(COMMON_ITEM_NAME, sellInToday, quality);
        GildedRose shop = buildGildedRoseShop(commonItem);

        shop.updateQuality();

        assertThat(firstItem(shop).sellIn, is(sellInToday - 1));
        assertThat(firstItem(shop).quality, is(quality - 2));
    }

    @Test
    void common_item_never_has_negative_quality() {
        int sellInThirtyDays = 30, zeroQuality = 0;
        Item commonItem = new Item(COMMON_ITEM_NAME, sellInThirtyDays, zeroQuality);
        GildedRose shop = buildGildedRoseShop(commonItem);

        shop.updateQuality();

        assertThat(firstItem(shop).sellIn, is(sellInThirtyDays - 1));
        assertThat(firstItem(shop).quality, is(zeroQuality));
    }

    @Test
    void aged_brie_increases_in_quality_by_one() {
        int sellInThirtyDays = 30, quality = 20;
        Item agedBrie = new Item(AgedBrie.NAME, sellInThirtyDays, quality);
        GildedRose shop = buildGildedRoseShop(agedBrie);

        shop.updateQuality();

        assertThat(firstItem(shop).name, is(AgedBrie.NAME));
        assertThat(firstItem(shop).sellIn, is(sellInThirtyDays - 1));
        assertThat(firstItem(shop).quality, is(quality + 1));
    }

    @Test
    void aged_brie_with_passed_sell_in_increases_in_quality_twice_as_fast() {
        int sellInToday = 0, quality = 20;
        Item agedBrie = new Item(AgedBrie.NAME, sellInToday, quality);
        GildedRose shop = buildGildedRoseShop(agedBrie);

        shop.updateQuality();

        assertThat(firstItem(shop).name, is(AgedBrie.NAME));
        assertThat(firstItem(shop).sellIn, is(sellInToday - 1));
        assertThat(firstItem(shop).quality, is(quality + 2));
    }

    @Test
    void aged_brie_quality_is_never_more_than_fifty() {
        int sellInThirtyDays = 30, qualityFifty = 50;
        Item agedBrie = new Item(AgedBrie.NAME, sellInThirtyDays, qualityFifty);
        GildedRose shop = buildGildedRoseShop(agedBrie);

        shop.updateQuality();

        assertThat(firstItem(shop).name, is(AgedBrie.NAME));
        assertThat(firstItem(shop).sellIn, is(sellInThirtyDays - 1));
        assertThat(firstItem(shop).quality, is(qualityFifty));
    }

    @Test
    void sulfuras_never_decreases_sell_in_or_quality() {
        int sellInThirtyDays = 30;
        Item sulfuras = new Item(Sulfuras.NAME, sellInThirtyDays, Sulfuras.QUALITY);
        GildedRose shop = buildGildedRoseShop(sulfuras);

        shop.updateQuality();

        assertThat(firstItem(shop).name, is(Sulfuras.NAME));
        assertThat(firstItem(shop).sellIn, is(sellInThirtyDays));
        assertThat(firstItem(shop).quality, is(Sulfuras.QUALITY));
    }

    @Test
    void backstage_pass_quality_increases_by_two_when_sell_in_ten_days_or_less() {
        int sellInTenDays = 10, quality = 20;
        Item backstagePass = new Item(BackstagePass.NAME, sellInTenDays, quality);
        GildedRose shop = buildGildedRoseShop(backstagePass);

        shop.updateQuality();

        assertThat(firstItem(shop).name, is(BackstagePass.NAME));
        assertThat(firstItem(shop).sellIn, is(sellInTenDays - 1));
        assertThat(firstItem(shop).quality, is(quality + 2));
    }

    @Test
    void backstage_pass_quality_increases_by_three_when_sell_in_five_days_or_less() {
        int sellInFiveDays = 5, quality = 20;
        Item backstagePass = new Item(BackstagePass.NAME, sellInFiveDays, quality);
        GildedRose shop = buildGildedRoseShop(backstagePass);

        shop.updateQuality();

        assertThat(firstItem(shop).name, is(BackstagePass.NAME));
        assertThat(firstItem(shop).sellIn, is(sellInFiveDays - 1));
        assertThat(firstItem(shop).quality, is(quality + 3));
    }

    @Test
    void backstage_pass_quality_decreases_to_zero_when_sell_in_after_concert() {
        int sellInToday = 0, quality = 20, qualityZero = 0;
        Item backstagePass = new Item(BackstagePass.NAME, sellInToday, quality);
        GildedRose shop = buildGildedRoseShop(backstagePass);

        shop.updateQuality();

        assertThat(firstItem(shop).name, is(BackstagePass.NAME));
        assertThat(firstItem(shop).sellIn, is(sellInToday - 1));
        assertThat(firstItem(shop).quality, is(qualityZero));
    }

    @Test
    void conjured_item_degrades_twice_as_fast_with_remaining_sell_in() {
        int sellInThirtyDays = 30, quality = 20;
        Item commonItem = new Item(Conjured.NAME, sellInThirtyDays, quality);
        GildedRose shop = buildGildedRoseShop(commonItem);

        shop.updateQuality();

        assertThat(firstItem(shop).sellIn, is(sellInThirtyDays - 1));
        assertThat(firstItem(shop).quality, is(quality - 2));
    }

    @Test
    void conjured_item_degrades_twice_as_fast_when_item_is_expired() {
        int sellInToday = 0, quality = 20;
        Item commonItem = new Item(Conjured.NAME, sellInToday, quality);
        GildedRose shop = buildGildedRoseShop(commonItem);

        shop.updateQuality();

        assertThat(firstItem(shop).sellIn, is(sellInToday - 1));
        assertThat(firstItem(shop).quality, is(quality - 4));
    }

    private static GildedRose buildGildedRoseShop(Item... items) {
        return new GildedRose(items);
    }

    private static Item firstItem(GildedRose shop) {
        return shop.items[0];
    }
}
