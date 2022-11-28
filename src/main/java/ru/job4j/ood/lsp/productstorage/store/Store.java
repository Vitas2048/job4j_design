package ru.job4j.ood.lsp.productstorage.store;

import ru.job4j.ood.lsp.productstorage.Food;

import java.util.List;

public interface Store {

    void store(Food food);

    List<Food> get();
}
