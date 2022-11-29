package ru.job4j.ood.lsp.productstorage.store;

import ru.job4j.ood.lsp.productstorage.Food;

public class Shop extends AbstractStore {

    private final int expired = 100;

    private final int almostExpired = 75;

    private final int fresh = 25;

    @Override
    boolean ifCondition(Food food) {
        var percent = getPercent(food);
        int price = food.getPrice();
        if (percent > almostExpired && percent < expired) {
            food.setPrice(price - price * food.getDiscount() / 100);
            return true;
        } else {
            return percent > fresh && percent < almostExpired;
        }
    }
}
