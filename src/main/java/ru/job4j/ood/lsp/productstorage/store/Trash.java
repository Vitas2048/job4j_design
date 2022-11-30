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
    public boolean ifCondition(Food food) {
        var calculateInPercent = calculator.calculateInPercent(food.getCreateDate(), food.getExpiryDate());
        return calculateInPercent >= Shop.EXPIRED;
    }
}
