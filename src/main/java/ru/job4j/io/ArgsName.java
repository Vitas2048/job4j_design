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
        if (args.length == 0) {
            throw new IllegalArgumentException();
        }
        for (String arg : args) {
            if (arg.contains("=") && arg.contains("-")) {
                String[] s = arg.split("=");
                String k = s[0];
                String v = s[1];
                if (s.length > 2) {
                    v = v.concat("=");
                    for (int j = 2; j < s.length; j++) {
                       v = v.concat(s[j]).concat("=");
                    }
                }
                if (k.startsWith("-")) {
                    k = k.substring(1, k.length());
                    if (k.isEmpty()) {
                        break;
                    }
                }
                values.put(k, v);
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