package ru.job4j.ood.lsp.productstorage.store;

import ru.job4j.ood.lsp.productstorage.Food;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class AbstractStore implements Store {

    private List<Food> foods = new ArrayList<>();

    @Override
    public void store(Food food) {
        Food resultFood = ifCondition(food);
        if (resultFood != null) {
            foods.add(resultFood);
        }

    }

    @Override
    public List<Food> get() {
       return this.foods;
    }

    public int getPercent(Food food) {
        var created = food.getCreateDate().getTime();
        var expired = food.getExpiryDate().getTime() - created;
        var now = new Date().getTime() - created;
        return (int) (now * 100 / expired);
    }

    abstract Food ifCondition(Food food);
}
