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
    public boolean ifCondition(Food food) {
        var calculateInPercent = calculator.calculateInPercent(food.getCreateDate(), food.getExpiryDate());
        int price = food.getPrice();
        if (calculateInPercent < ALMOST_EXPIRED && calculateInPercent > FRESH) {
            return true;
        }
        if (calculateInPercent >= ALMOST_EXPIRED && calculateInPercent < EXPIRED) {
            food.setPrice(price - price * food.getDiscount() / 100);
            return true;
        }
        return false;
    }

}
