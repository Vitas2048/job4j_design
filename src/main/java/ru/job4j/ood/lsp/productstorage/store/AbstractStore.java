package ru.job4j.ood.lsp.productstorage.store;

import ru.job4j.ood.lsp.productstorage.Food;
import ru.job4j.ood.lsp.productstorage.expirationcalculator.ExpirationCalculator;
import ru.job4j.ood.lsp.productstorage.expirationcalculator.LocalDateExpirationCalculator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class AbstractStore implements Store {

    private List<Food> foods = new ArrayList<>();


    @Override
    public boolean add(Food food) {
        if (ifCondition(food)) {
            foods.add(food);
            return true;
        }
        return false;
    }

    @Override
    public List<Food> get() {
       return new ArrayList<>(foods);
    }

    public void clear() {
        this.foods.clear();
    }

    abstract boolean ifCondition(Food food);
}
