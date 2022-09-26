package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Analizy {
    public void unavailable(String source, String target) {
        List<String> list = new ArrayList<>();
        boolean status = true;
        String l = "";
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            for (String s = in.readLine(); s != null; s = in.readLine()) {
                String p = s.split(" ")[1];
                if (status && (s.contains("500") || s.contains("400"))) {
                    status = false;
                    l = p.concat(";");
                }
                if (!status && (s.contains("300") || s.contains("200"))) {
                    status = true;
                    l = l.concat(p).concat(";");
                    list.add(l);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(target)
                ))) {
                list.forEach(out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
            Analizy analizy = new Analizy();
            analizy.unavailable("./data/source.txt", "./data/target.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}