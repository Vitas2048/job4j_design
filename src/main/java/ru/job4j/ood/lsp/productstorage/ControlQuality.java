package ru.job4j.ood.lsp.productstorage;

import ru.job4j.ood.lsp.productstorage.store.AbstractStore;

import java.util.List;

public class ControlQuality {

    private List<Food> foods;

    public ControlQuality(List<Food> foods) {
        this.foods = foods;
    }

    public void execute(AbstractStore store) {
        for (Food food : this.foods) {
            store.store(food);
        }
    }
}
