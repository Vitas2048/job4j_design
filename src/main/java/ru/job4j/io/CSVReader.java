package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
        validation(argsName);
        String sep = argsName.get("delimiter");
        String path = argsName.get("out");
        ArrayList<String> filter = new ArrayList<>();
        ArrayList<String> res = new ArrayList<>();
        HashMap<String, Integer> col = new HashMap<>();
        var scanner = new Scanner(argsName.get("filter")).useDelimiter(",");
        while (scanner.hasNext()) {
            filter.add(scanner.next());
        }
        try (BufferedReader in = new BufferedReader(new FileReader(argsName.get("path")))) {
            String line;
            while ((line = in.readLine()) != null) {
                int i = 0;
                String string = "";
                for (String s:filter) {
                var scanner1 = new Scanner(line).useDelimiter(sep);
                while (scanner1.hasNext()) {
                    i++;
                    String scan = scanner1.next();
                        if (scan.equals(s)) {
                            col.put(s, i);
                        }
                        if (col.get(s) != null && i == col.get(s)) {
                            string = String.format("%s%s%s", string, scan, sep);
                        }
                    }
                }
                string = string.substring(0, string.length() - 1);
                res.add(string);
            }
            try (FileOutputStream out = new FileOutputStream(path)) {
                for (String s: res) {
                    if ("stdout".equals(path)) {
                        System.out.println(s);
                    } else {
                        out.write(s.getBytes());
                        out.write(System.lineSeparator().getBytes());
                    }
                }
                }  catch (Exception e) {
                    e.printStackTrace();
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void validation(ArgsName argsName) {
        if (argsName.get("delimiter").length() != 1) {
            throw new IllegalArgumentException(
                    String.format("необходимо ввести разделитель в строке %s", argsName.get("delimiter")));
        }
        if (!"stdout".equals(argsName.get("out")) && !(argsName.get("out")).endsWith(".csv")) {
            throw new IllegalArgumentException(
                    String.format("необходимо ввести stdout для вывода на консоль или путь к файлу в строке %s",
                            argsName.get("out")));
        }
        if (argsName.get("filter").contains(", ")) {
            throw new IllegalArgumentException(
                    String.format("необходимо ввести фильтры строго через запятую %s", argsName.get("filter")));
        }
        if (!Paths.get(argsName.get("path")).toFile().isFile() && !argsName.get("path").endsWith(".csv")) {
            throw new IllegalArgumentException(
                    String.format("необходимо ввести путь к файлу формата csv %s", argsName.get("path")));
        }
    }

    public static void main(String[] args) throws Exception {
        ArgsName name = ArgsName.of(args);
        handle(name);
    }
}
