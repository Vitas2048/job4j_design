package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    HashMap<FileProperty, ArrayList<String>> fileProp = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        String n = file.toFile().getName();
        FileProperty cur = new FileProperty(file.toFile().length(), n);
        fileProp.putIfAbsent(cur, new ArrayList<>());
        fileProp.get(cur).add(file.toAbsolutePath().toString());
        return FileVisitResult.CONTINUE;
    }

    public void print() {
        for (FileProperty f : fileProp.keySet()) {
            if (fileProp.get(f).size() > 1) {
                System.out.printf("%s - %s kb %n", f.getName(), f.getSize());
                for (String p: fileProp.get(f)) {
                    System.out.println(p);
                }
            }
        }
    }
}