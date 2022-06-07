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
        if (column >= data[row].length) {
            row++;
            column = 0;
        }
        if (data.length > row && data[row].length != 0) {
            rsl = true;
        } else {
            if (row + 1 < data.length) {
                if (data[row + 1].length > column) {
                    rsl = true;
                } else {
                    column = 0;
                    while (data[row].length == 0 && data.length > row + 1) {
                        row++;
                    }
                    if (data[row].length != 0) {
                        rsl = true;
                    }
                }
            }
        }
        return rsl;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        } else if (column + 1 >= data[row].length) {
            return data[row++][column];
            } else {
                    return data[row][column++];
                    }

    }
}