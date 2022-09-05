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
        int h = Objects.hashCode(key) ;
        hash = hash(h);
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
        return (hashCode == 0) ? 0 : (hashCode) ^ (hashCode >> capacity);
    }

    private int indexFor(int hash) {
        return hash & (table.length - 1);
    }

    private void expand() {
        capacity = 2 * capacity;
        MapEntry<K, V>[] table1 = new MapEntry[capacity];
        for (MapEntry<K, V> kvMapEntry : table) {
            if (!Objects.equals(kvMapEntry, null)) {
                int h = Objects.hashCode(kvMapEntry.key);
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
        return Objects.equals(key, null) || Objects.equals(key, 0) ?
               Objects.equals(table[indexFor(0)].key, key) ? table[indexFor(0)].value : null :
               table[indexFor(hash(key.hashCode()))] == null ? null : table[indexFor(hash(key.hashCode()))].value;
    }
    @Override
    public boolean remove(K key) {
        int index = indexFor(hash(Objects.hashCode(key)));
        if (table[index] != null) {
            int keyHash = Objects.hashCode(key);
            int tableHash = Objects.hashCode(table[index].key);
            if (tableHash == keyHash) {
                if (Objects.equals(table[index].key, key)) {
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
                while ((table.length - 1 > j) && (table[j] == null)) {
                    j++;
                }
                return j != table.length && table[j] != null;
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