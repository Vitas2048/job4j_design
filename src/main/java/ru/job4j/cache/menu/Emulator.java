package ru.job4j.cache.menu;

import ru.job4j.cache.DirFileCache;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Emulator {

    public static DirFileCache setDir(String s) {
        return new DirFileCache(s);
    }

    public static void loadCache(DirFileCache cache, String key, String source) {
        String rsl = "";
        try (BufferedReader in = new BufferedReader(new FileReader(source.concat(key)))) {
            for (String s = in.readLine(); s != null; s = in.readLine()) {
                String s1 = String.format("%s%n", s);
                rsl = String.format("%s%s", rsl, s1);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        cache.put(key, rsl);
    }

    public static String getCache(DirFileCache s, String key) {
        return s.get(key);
    }

    public static void main(String[] args) {
        String source = "./src/main/java/ru/job4j/cache/menu/data/";
        DirFileCache cache = setDir(source);
        loadCache(cache, "Adress.txt", source);
        loadCache(cache, "Names.txt", source);
        System.out.println(getCache(cache, "Names.txt"));
    }
}
