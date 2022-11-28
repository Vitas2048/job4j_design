package ru.job4j.ood.lsp.productstorage.store;

import ru.job4j.ood.lsp.productstorage.Food;

public class Trash extends AbstractStore {

    @Override
    Food ifCondition(Food food) {
        if (getPercent(food) >= 100) {
            return food;
        }
        return null;
    }
}
