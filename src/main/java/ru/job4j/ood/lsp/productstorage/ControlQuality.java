package ru.job4j.ood.lsp.productstorage;

import ru.job4j.ood.lsp.productstorage.store.AbstractStore;
import ru.job4j.ood.lsp.productstorage.store.Store;

import java.util.ArrayList;
import java.util.List;

public class ControlQuality {

    private List<Store> stores;

    private FoodStore foodStore;

    public ControlQuality(List<Store> stores, FoodStore foodStore) {
        this.stores = stores;
        this.foodStore = foodStore;
    }

    public void execute() {
        List<Food> foods = new ArrayList<>(this.foodStore.getFoods());
        for (Store store : this.stores) {
            for (Food food : foods) {
                if (store.add(food)) {
                    foods.remove(food);
                    break;
                }
            }
        }
    }

    public void resort() {
        List<Food> foods = this.foodStore.getFoods();
        for (Store store : this.stores) {
            for (Food food : foods) {
                if (store.add(food)) {
                    foods.remove(food);
                    break;
                }
            }
        }
    }
}
