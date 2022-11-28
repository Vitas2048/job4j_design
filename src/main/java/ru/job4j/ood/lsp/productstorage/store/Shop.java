package ru.job4j.ood.lsp.productstorage.store;

import ru.job4j.ood.lsp.productstorage.Food;

public class Shop extends AbstractStore {

    @Override
    Food ifCondition(Food food) {
        int percent = getPercent(food);
        int price = food.getPrice();
        if (percent > 25 && percent < 75) {
            food.setPrice(price - price * food.getDiscount() / 100);
            return food;
        }
        return null;
    }
}
