package ru.job4j.kiss;

import net.sf.saxon.functions.Minimax;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class MaxMinTest {

    @Test
    public void whenFindMax() {
        MaxMin set = new MaxMin();
        Integer max = set.max(List.of(2, 3, 8, 6, 7), Comparator.naturalOrder());
        Integer res = 8;
        Assert.assertEquals(max, res);
    }

    @Test
    public void whenFindMin() {
        MaxMin set = new MaxMin();
        Integer min = set.min(List.of(2, 3, 8, 1, 6, 7), Comparator.naturalOrder());
        Integer res = 1;
        Assert.assertEquals(min, res);
    }

    @Test
    public void whenNull() {
        MaxMin set = new MaxMin();
        Integer min = set.min(new ArrayList<Integer>(), Comparator.naturalOrder());
        Assert.assertNull(min);
    }
}