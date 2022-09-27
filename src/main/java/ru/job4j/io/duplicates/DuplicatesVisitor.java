package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    public long s;
    public String n;

    public DuplicatesVisitor(FileProperty f) {
        this.s = f.getSize();
        this.n = f.getName();
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (file.toFile().getName().equals(n) && file.toFile().length() == s) {
            System.out.printf("%n%s", file.toAbsolutePath());
        }
        return FileVisitResult.CONTINUE;
    }
}