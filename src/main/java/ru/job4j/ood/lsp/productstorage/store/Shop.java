package ru.job4j.ood.lsp.productstorage.store;

import ru.job4j.ood.lsp.productstorage.Food;
import ru.job4j.ood.lsp.productstorage.expirationcalculator.ExpirationCalculator;

public class Shop extends AbstractStore {

    public static final int EXPIRED = 100;

    public static final int ALMOST_EXPIRED = 75;

    public static final int FRESH = 25;

    private ExpirationCalculator calculator;

    public Shop(ExpirationCalculator calculator) {
        this.calculator = calculator;
    }

    @Override
    boolean ifCondition(Food food) {
        var percent = getPercent(food);
        int price = food.getPrice();
        if (percent < ALMOST_EXPIRED && percent > FRESH) {
            return true;
        }
        if (percent >= ALMOST_EXPIRED && percent < EXPIRED) {
            food.setPrice(price - price * food.getDiscount() / 100);
            return true;
        }
        return false;
    }

    public double getPercent(Food food) {
        return calculator.calculateInPercent(food.getCreateDate().toLocalDate(), food.getExpiryDate().toLocalDate());
    }
}
