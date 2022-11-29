package ru.job4j.ood.lsp.productstorage.store;

import ru.job4j.ood.lsp.productstorage.Food;

public class Shop extends AbstractStore {

    private final int EXPIRED = 100;

    private final int ALMOST_EXPIRED = 75;

    private final int FRESH = 25;

    @Override
    boolean ifCondition(Food food) {
        var percent = getPercent(food);
        int price = food.getPrice();
        if (percent > ALMOST_EXPIRED && percent < EXPIRED) {
            food.setPrice(price - price * food.getDiscount() / 100);
            return true;
        } else return percent > FRESH && percent < ALMOST_EXPIRED;
    }
}
