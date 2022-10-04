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
        for (String arg : args) {
                validation(arg);
                String[] s = arg.split("=", 2);
                String k = s[0].split("-")[1];
                String v = s[1];
                values.put(k, v);
        }
    }

    public static void validation(String n) {
            if (n.split("=").length < 2) {
                throw new IllegalArgumentException("несоответствие шаблону: -ключ=значение в строке:" + n);
            }
            if (!n.contains("=") || !n.contains("-") || !n.startsWith("-") || n.startsWith("-=")) {
                throw new IllegalArgumentException("несоответствие шаблону: -ключ=значение в строке:" + n);
            }

    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        if (args.length == 0) {
            throw new IllegalArgumentException("Отсутствуют параметры");
        }
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