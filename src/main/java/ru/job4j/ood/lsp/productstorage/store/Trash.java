package ru.job4j.ood.lsp.productstorage.store;

import ru.job4j.ood.lsp.productstorage.Food;
import ru.job4j.ood.lsp.productstorage.expirationcalculator.ExpirationCalculator;
import ru.job4j.ood.lsp.productstorage.expirationcalculator.LocalDateExpirationCalculator;

public class Trash extends AbstractStore {

    private ExpirationCalculator calculator;

    public Trash(ExpirationCalculator calculator) {
        this.calculator = calculator;
    }

    @Override
    boolean ifCondition(Food food) {
        return getPercent(food) >= Shop.EXPIRED;
    }

    public double getPercent(Food food) {
        return calculator.calculateInPercent(food.getCreateDate().toLocalDate(), food.getExpiryDate().toLocalDate());
    }
}
