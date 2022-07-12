package ru.job4j.iterator;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.function.Function;

public class ListUtils {

    public static boolean check(Predicate<ListIterator> s, ListIterator eiterator) {
        return s.test(eiterator);
    }

    public static boolean hnext(ListIterator e) {
        return check(ListIterator::hasNext, e);
    }

    public static boolean fil(Predicate p, ListIterator e) {
        return check(s -> p.test(s.next()), e);
    }

    public static boolean eq(ListIterator e, ListIterator f) {
        return check(s-> s.next().equals(e.next()), f);
    }

    public static <T> void addBefore(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> iterator = list.listIterator(index);
        iterator.add(value);
    }

    public static <T> void addAfter(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> iterator = list.listIterator(index);
        iterator.next();
        iterator.add(value);
    }

    public static <T> void replaceIf(List<T> list, Predicate<T> filter, T value) {
        ListIterator<T> iterator = list.listIterator();
        while (hnext(iterator)) {
            if (fil(filter, iterator)) {
                iterator.set(value);
            }
        }
    }

    public static <T> void removeIf(List<T> list, Predicate<T> filter) {
        ListIterator<T> iterator = list.listIterator();
        while (hnext(iterator)) {
            if (fil(filter, iterator)) {
                iterator.remove();
            }
        }
    }

    public static <T> void removeAll(List<T> list, List<T> elements) {
        ListIterator<T> iterator = list.listIterator();
        ListIterator<T> eIterator = elements.listIterator();
        while (hnext(iterator) && hnext(eIterator)) {
            if (eq(iterator, eIterator)) {
                iterator.remove();
            }
        }
    }
}