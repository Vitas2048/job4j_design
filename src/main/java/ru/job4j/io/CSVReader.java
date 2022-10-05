package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
        String sep = argsName.get("-delimiter");
        ArrayList<String> filter = new ArrayList<>();
        var scanner = new Scanner(argsName.get("-filter")).useDelimiter(",");
        while (scanner.hasNext()) {
            filter.add(scanner.next());
        }
        try {
            BufferedReader in = new BufferedReader(new FileReader(argsName.get("-path")));
            in.lines().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void validation(String[] n) {

    }
}
