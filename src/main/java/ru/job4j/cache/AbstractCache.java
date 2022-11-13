package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {

    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, V value) {
        if (value.equals("fileCache")) {
            cache.put(key, new SoftReference<>(load(key)));
        }
    }

    public V get(K key) {
        return cache.getOrDefault(key, new SoftReference<>(null)).get();
    }

    protected abstract V load(K key);

}