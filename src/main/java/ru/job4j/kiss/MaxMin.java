package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;

public class MaxMin {

    public MaxMin() {
    }

    public <T> T max(List<T> value, Comparator<T> comparator) {
        return finder(value, comparator);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return finder(value, comparator.reversed());
    }

    public <T> T finder(List<T> list, Comparator<T> comparator) {
        if (list.isEmpty()) {
            return null;
        }
        T comp = list.get(0);
        for (T s:list) {
            if (comparator.compare(comp, s) < 0) {
                comp = s;
            }
        }
        return comp;
    }
}