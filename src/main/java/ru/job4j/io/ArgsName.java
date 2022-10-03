package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        String s = values.get(key);
        if (s == null) {
            throw new IllegalArgumentException();
        }
        return s;
    }

    private void parse(String[] args) {
        validation(args);
        for (String arg : args) {
                String[] s = arg.split("=");
                String k = s[0].split("-")[1];
                String v = s[1];
                if (s.length > 2) {
                    v = v.concat("=");
                    for (int j = 2; j < s.length; j++) {
                       v = v.concat(s[j]).concat("=");
                    }
                }
                values.put(k, v);
        }
    }

    public static void validation(String[] n) {
        if (n.length == 0) {
            throw new IllegalArgumentException("несоответствие шаблону: -ключ=значение");
        }
        for (String s:n) {
            if (!s.contains("=") || !s.contains("-") || !s.startsWith("-") || s.startsWith("-=")) {
                throw new IllegalArgumentException("несоответствие шаблону: -ключ=значение в строке:" + s);
            }
        }
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}