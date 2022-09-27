package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DuplicatesFinder {
    public static void main(String[] args) throws IOException {
        FileProperty fp = new FileProperty(11, "easy1.txt");
        System.out.printf("%n%s - %d bytes", fp.getName(), fp.getSize());
        Files.walkFileTree(Path.of("C:\\Projects\\job4j_design\\duplicates"), new DuplicatesVisitor(fp));
    }
}