package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        int hash;
        if (Objects.equals(key, null)) {
            hash = 0;
        } else {

            int h = key.hashCode();
            hash = hash(h);
        }
        int i = indexFor(hash);
        if (Objects.equals(table[i], null)) {
            count++;
            modCount++;
            if ((float) count / capacity >= LOAD_FACTOR) {
                expand();
                i = indexFor(hash);
            }
            table[i] = new MapEntry<>(key, value);
            return true;
        }
        return false;
    }

    private int hash(int hashCode) {
        int h;
        return (hashCode == 0) ? 0 : (h = hashCode) ^ (h >>> capacity);
    }

    private int indexFor(int hash) {
        return hash & (table.length - 1);
    }

    private void expand() {
        capacity = 2 * capacity;
        MapEntry<K, V>[] table1 = new MapEntry[capacity];
        for (MapEntry<K, V> kvMapEntry : table) {
            if (!Objects.equals(kvMapEntry, null)) {
                int h = Objects.equals(kvMapEntry.key, null) ? 0 : kvMapEntry.key.hashCode();
                int hash = hash(h);
                int i = indexFor(hash);
                if (Objects.equals(table1[i], null)) {
                    table1[i] = new MapEntry<>(kvMapEntry.key, kvMapEntry.value);
                }
            }
        }
        table = table1;
    }

    @Override
    public V get(K key) {
        if (Objects.equals(key, null)) {
            return table[indexFor(0)].value;
        }
        return table[indexFor(hash(key.hashCode()))] == null ? null : table[indexFor(hash(key.hashCode()))].value;
    }

    @Override
    public boolean remove(K key) {
        int index = Objects.equals(key, null) ? 0 : indexFor(hash(key.hashCode()));
        if (table[index] != null) {
            int keyHash = Objects.equals(key, null) ? 0 : key.hashCode();
            int tableHash = Objects.equals(key, null) ? 0 : table[index].key.hashCode();
            if (tableHash == keyHash) {
                if (Objects.equals(table[index].key,key)) {
                    table[index] = null;
                }
            }
            count--;
            modCount++;
            return true;
        }
        return false;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {

            final int expectedModCount = modCount;
            int j = 0;

            @Override
            public boolean hasNext() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                if (j < table.length && table[j] != null) {
                    return true;
                } else {
                    while (j + 1 < table.length && table[j] == null ) {
                        j++;
                    }
                    return j + 1 <= table.length && table[j] != null ;
                }
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[j++].key;
            }
        };
    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }
}