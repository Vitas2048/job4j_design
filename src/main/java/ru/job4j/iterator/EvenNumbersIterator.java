package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {

    private int[] data;
    private int index;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        if (index != data.length) {
            while ((data.length - 1 > index) && (data[index] % 2 != 0)) {
                index++;
            }
            return data[index] % 2 == 0;
        } else {
            return false;
        }
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        } else {
            return data[index++];
        }
    }

}