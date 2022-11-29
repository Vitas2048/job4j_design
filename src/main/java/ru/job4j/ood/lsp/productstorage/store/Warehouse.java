package ru.job4j.ood.lsp.productstorage.store;

import ru.job4j.ood.lsp.productstorage.Food;

public class Warehouse extends AbstractStore {

    private final int FRESH = 25;

    @Override
    boolean ifCondition(Food food) {
        return getPercent(food) <= FRESH;
    }
}
