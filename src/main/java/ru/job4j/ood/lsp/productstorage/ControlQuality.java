package ru.job4j.ood.lsp.productstorage;

import ru.job4j.ood.lsp.productstorage.store.AbstractStore;
import ru.job4j.ood.lsp.productstorage.store.Store;

import java.util.ArrayList;
import java.util.List;

public class ControlQuality {

    private List<AbstractStore> stores;

    public ControlQuality(List<AbstractStore> stores) {
        this.stores = stores;
    }

    public void execute(List<Food> foods) {
        List<Food> foods1 = new ArrayList<>(foods);
        for (Store store : this.stores) {
            for (Food food : foods1) {
                if (store.add(food)) {
                    foods1.remove(food);
                    break;
                }
            }
            }
        }

    public void resort() {
        List<Food> foods = new ArrayList<>();
        for (AbstractStore store : this.stores) {
            foods.addAll(store.get());
            store.clear();
        }
        execute(foods);
    }
}
