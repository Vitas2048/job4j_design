package ru.job4j.ood.lsp.productstorage;

import java.util.ArrayList;
import java.util.List;

public class FoodStore {
    private List<Food> foods;

    public FoodStore() {
        foods = new ArrayList<>();
    }

    public void add(Food food) {
        foods.add(food);
    }

    public List<Food> getFoods() {
        return foods;
    }
}
