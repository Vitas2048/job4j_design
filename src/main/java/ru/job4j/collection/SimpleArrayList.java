package ru.job4j.collection;

import java.util.*;

public class SimpleArrayList<T> implements SimpleList<T> {

    private T[] container;

    private int size;

    private int modCount;

    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    public void expand() {
        int k = 0;
        for (T t : container) {
            if (t == null) k++;
        }
        if (k == 1) container = Arrays.copyOf(container, container.length * 2);
    }

    @Override
    public void add(T value) {
        expand();
        for (int i = 0; i < container.length; i++) {
            if (container[i] == null) {
                size++;
                container[i] = value;
                break;
            }
        }
        modCount++;
    }

    @Override
    public T set(int index, T newValue) {
        Objects.checkIndex(index, container.length - 1);
        T tmp = container[index];
        container[index] = newValue;
        return tmp;
    }

    @Override
    public T remove(int index) {
        Objects.checkIndex(index, container.length - 1);
        T tmp = container[index];
        System.arraycopy(container,index + 1, container, index, container.length - index - 1);
        size--;
        modCount++;
        return tmp;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, container.length - 1);
        return container[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int expectedModCount = modCount;
            int it = 0;

            @Override
            public boolean hasNext() {
                return size - it > 0;
                }

            @Override
            public T next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!iterator().hasNext()) {
                    throw new NoSuchElementException();
            }
                return container[it++];

        }
        };
    }
}