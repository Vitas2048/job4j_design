package ru.job4j.iterator;

import static org.hamcrest.Matchers.is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.assertThat;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);

        assertThat(input, is(Arrays.asList(1, 2, 3)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);

        assertThat(input, is(Arrays.asList(0, 1, 2, 3)));
    }

    @Test
    public void whenAddAfterMid() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 1, 3);

        assertThat(input, is(Arrays.asList(0, 1, 3, 2)));
    }

    @Test
    public void whenRemoveIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.removeIf(input,  s -> s > 1);
        assertThat(input, is(Arrays.asList(0, 1)));
    }

    @Test
    public void whenRplaceIF() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.replaceIf(input,  s -> s > 0, 2);
        assertThat(input, is(Arrays.asList(0, 2, 2)));
    }

    @Test
    public void whenRemoveAll() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
        List<Integer> elements = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.removeAll(input, elements);
        assertThat(input, is(Arrays.asList(3, 4)));
    }

}