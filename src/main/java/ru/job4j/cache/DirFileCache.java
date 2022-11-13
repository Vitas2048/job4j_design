package ru.job4j.cache;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ref.WeakReference;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        String rsl = "";
        try (BufferedReader in = new BufferedReader(new FileReader(cachingDir.concat(key)))) {
            for (String s = in.readLine(); s != null; s = in.readLine()) {
                String s1 = String.format("%s%n", s);
                rsl = String.format("%s%s", rsl, s1);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return rsl;
    }
}