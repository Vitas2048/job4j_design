package ru.job4j.collection;

import java.util.*;

public class SimpleArrayList<T> implements SimpleList<T> {

    private T[] container;

    private int size;

    private int modCount;

    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    private void expand() {
        if (size == 0) {
            container = Arrays.copyOf(container, 2);
        } else if (container.length == size) {
            container = Arrays.copyOf(container, container.length * 2);
        }
    }

    @Override
    public void add(T value) {
        expand();
        container[size++] = value;
        modCount++;
    }

    @Override
    public T set(int index, T newValue) {
        T tmp = get(index);
        container[index] = newValue;
        return tmp;
    }

    @Override
    public T remove(int index) {
        T tmp = get(index);
        System.arraycopy(container, index + 1, container, index, container.length - index - 1);
        container[container.length - 1] = null;
        size--;
        modCount++;
        return tmp;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
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
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return it < size;
                }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
            }
                return container[it++];

        }
        };
    }
}