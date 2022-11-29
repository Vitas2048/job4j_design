package ru.job4j.ood.lsp.productstorage;

import ru.job4j.ood.lsp.productstorage.store.AbstractStore;
import ru.job4j.ood.lsp.productstorage.store.Store;

import java.util.List;

public class ControlQuality {

    private List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    public void execute(Food food) {
        for (Store store : this.stores) {
            if (store.add(food)) {
                break;
            }
        }
    }
}
