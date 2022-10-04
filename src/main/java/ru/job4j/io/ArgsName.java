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
                if (validation(arg)) {
                    String[] s = arg.split("=", 2);
                    String k = s[0].split("-")[1];
                    String v = s[1];
                    values.put(k, v);
                }
        }
    }

    public static boolean validation(String n) {
        if (!n.startsWith("-") || !n.contains("=")) {
            throw new IllegalArgumentException(
                    String.format("несоответствие шаблону: -ключ=значение в строке:%s", n));
        }
        if (n.startsWith("-=")) {
            throw new IllegalArgumentException(
                    String.format("нет ключа в строке:%s", n));
        }
        if (n.indexOf("=") == n.length() - 1) {
            throw new IllegalArgumentException(
                    String.format("нет значения в строке:%s", n));
        }
        return true;
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