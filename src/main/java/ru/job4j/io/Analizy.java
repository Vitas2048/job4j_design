package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Analizy {
    public void unavailable(String source, String target) {
        List<String> list = new ArrayList<>();
        boolean status = true;
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            while (in.ready()) {
                if (status && (in.readLine().contains("500") || in.readLine().contains("400"))) {
                    status = false;
                    list.add(in.readLine());
                }
                if (!status && (in.readLine().contains("300") || in.readLine().contains("200"))) {
                    status = true;
                    list.add(in.readLine());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(target)
                ))) {
                list.forEach(s -> out.println(s.split(" ")[1] + ";"));
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