package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Config {

    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        List<String> list;
        try (BufferedReader in = new BufferedReader(new FileReader(path))) {
            in.lines().filter(p -> !p.startsWith("#") && !p.isEmpty()).forEach(s -> {
                String[] a = s.split("=", 2);
                if (!(a.length == 2) || a[0].isEmpty() || a[1].isEmpty()) {
                        throw new IllegalArgumentException("Не соответствие шаблону - key=value" + s);
                }
                values.put(a[0], a[1]);

            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String value(String key) {
        if (Objects.equals(values.get(key), null)) {
            throw new UnsupportedOperationException("Don't impl this method yet!");
        }
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("app.properties"));
    }
}