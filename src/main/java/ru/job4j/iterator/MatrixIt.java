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
        if (data.length > 0) {
            if (data[column].length > 0 || row + 1 < data.length) {
                if (row < data.length && column < data[column].length
                        || data[column + 1].length != 0) {
                    rsl = true;
                }
            }
        }
        return rsl;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (column == 0 && row == 0 && data[column].length > 1) {
            return data[row][column++];
        } else {
            while (data[row].length == 0) {
                row++;
            }
            if (column == 0 && row == 0 && row + 1 < data.length) {
                return data[row++][column];
            } else {
                if (column == data[column].length - 1 && row + 1 < data.length) {
                    return data[row++][column];
                } else {
                    return data[row][column++];
                }

            }
        }
    }
}