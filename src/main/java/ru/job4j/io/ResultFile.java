package ru.job4j.io;

import java.io.FileOutputStream;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            out.write("1 x 1 = 1".getBytes());
            out.write(System.lineSeparator().getBytes());
            out.write("1 x 2 = 2".getBytes());
            out.write(System.lineSeparator().getBytes());
            out.write("1 x 3 = 3".getBytes());
            out.write(System.lineSeparator().getBytes());
            out.write("1 x 4 = 4".getBytes());
            out.write(System.lineSeparator().getBytes());
            out.write("1 x 5 = 5".getBytes());
            out.write(System.lineSeparator().getBytes());
            out.write("1 x 6 = 6".getBytes());
            out.write(System.lineSeparator().getBytes());
            out.write("1 x 7 = 7".getBytes());
            out.write(System.lineSeparator().getBytes());
            out.write("1 x 8 = 8".getBytes());
            out.write(System.lineSeparator().getBytes());
            out.write("1 x 9 = 9".getBytes());
            out.write(System.lineSeparator().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}