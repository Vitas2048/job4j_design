package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Analizy {
    public void unavailable(String source, String target) {
        List<String> list = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            list = in.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(target)
                ))) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).contains("400") || list.get(j).contains("500")) {
                    for (int k = j + 1; k < list.size(); k++) {
                        if (list.get(k).contains("200") || list.get(k).contains("300")) {
                            out.println(list.get(j).split(" ")[1] + ";" + list.get(k).split(" ")[1] + ";");
                            j = k + 1;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
            Analizy analizy = new Analizy();
            analizy.unavailable("./data/source.txt", "./data/target.csv");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}