package ru.job4j.ood.lsp.productstorage.store;

import ru.job4j.ood.lsp.productstorage.Food;
import ru.job4j.ood.lsp.productstorage.expirationcalculator.ExpirationCalculator;

public class Warehouse extends AbstractStore {

    private ExpirationCalculator calculator;

    public Warehouse(ExpirationCalculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public boolean ifCondition(Food food) {
        var calculateInPercent = calculator.calculateInPercent(food.getCreateDate(), food.getExpiryDate());
        return calculateInPercent <= Shop.FRESH;
    }
}
