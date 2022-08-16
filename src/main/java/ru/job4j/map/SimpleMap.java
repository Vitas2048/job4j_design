package ru.job4j.map;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleMap<?, ?> simpleMap = (SimpleMap<?, ?>) o;
        return capacity == simpleMap.capacity && count == simpleMap.count && modCount == simpleMap.modCount
                && Arrays.equals(table, simpleMap.table);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(capacity, count, modCount);
        result = 31 * result + Arrays.hashCode(table);
        return result;
    }

    @Override
    public boolean put(K key, V value) {
        int h = key.hashCode();
        int hash = hash(h);
        int i = indexFor(hash);
        if (count != 0 && capacity / count >= LOAD_FACTOR) {
            expand();
        }
        if (Objects.equals(table[i], null)) {
            table[i].key = key;
            table[i].value = value;
            count++;
            return true;
        }
        return false;
    }

    private int hash(int hashCode) {
        int h;
        return (hashCode == 0) ? 0 : (h = hashCode) ^ (h >>> 16);
    }

    private int indexFor(int hash) {
        return hash & (table.length - 1);
    }

    private void expand() {
        MapEntry<K, V>[] table1 = new MapEntry[2 * capacity];
        for (int i = 0; i < count; i++) {
            put(table[i].key, table[i].value);
        }
    }

    @Override
    public V get(K key) {
        return table[indexFor(hash(key.hashCode()))].value;
    }

    @Override
    public boolean remove(K key) {
        return false;
    }

    @Override
    public Iterator<K> iterator() {
        return null;
    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }

    public static void main(String[] args) {
         SimpleMap<Integer, String> map = new SimpleMap<>();
         map.put(1, "key1");
        System.out.println(map.get(1));
    }
}