package ru.job4j.set;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SimpleSetTest {

    @Test
    public void whenAddNonNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.contains(1));
        assertFalse(set.add(1));
    }

    @Test
    public void whenAddNull() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(null));
        assertTrue(set.contains(null));
        assertFalse(set.add(null));
    }

    @Test
    public void whenAddN123() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(1));
        assertTrue(set.add(2));
        assertTrue(set.add(3));
    }

    @Test
    public void whenAddN1233() {
        Set<Integer> set = new SimpleSet<>();
        assertTrue(set.add(3));
        assertTrue(set.add(2));
        assertTrue(set.add(1));
        assertFalse(set.add(3));
    }
}