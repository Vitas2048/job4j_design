package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        boolean rsl = false;
        if (column >= data[row].length && data[row].length != 0) {
            if (data.length > row + 1) {
                row++;
                column = 0;
            }
        }
        while (data[row].length == 0 && row + 1 < data.length) {
            row++;
        }
        if (row + 1 < data.length && data[row + 1].length != 0
                || data.length > row + 1 && data[row].length < column
                || data[row].length != 0) {
            rsl = true;
        }
        return rsl;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[row][column++];
    }
}