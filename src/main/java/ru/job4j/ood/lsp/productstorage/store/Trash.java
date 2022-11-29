package ru.job4j.ood.lsp.productstorage.store;

import ru.job4j.ood.lsp.productstorage.Food;

public class Trash extends AbstractStore {

    private final int EXPIRED = 100;

    @Override
    boolean ifCondition(Food food) {
        return getPercent(food) >= EXPIRED;
    }
}
