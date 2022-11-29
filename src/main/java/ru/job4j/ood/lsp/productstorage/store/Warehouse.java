package ru.job4j.ood.lsp.productstorage.store;

import ru.job4j.ood.lsp.productstorage.Food;
import ru.job4j.ood.lsp.productstorage.expirationcalculator.ExpirationCalculator;

public class Warehouse extends AbstractStore {

    private ExpirationCalculator calculator;

    public Warehouse(ExpirationCalculator calculator) {
        this.calculator = calculator;
    }

    @Override
    boolean ifCondition(Food food) {
        return getPercent(food) <= Shop.FRESH;
    }

    public double getPercent(Food food) {
        return calculator.calculateInPercent(food.getCreateDate().toLocalDate(), food.getExpiryDate().toLocalDate());
    }
}
