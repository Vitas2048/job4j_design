package ru.job4j.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchFiles extends SimpleFileVisitor {

    private final Predicate<Path> condition;
    private List<Path> paths = new ArrayList<>();

    public SearchFiles(Predicate<Path> p) {
        this.condition = p;
    }

    public List<Path> getPaths() {
        return paths;
    }

    @Override
    public FileVisitResult visitFile(Object file, BasicFileAttributes attrs) throws IOException {
        if (condition.test((Path) file)) {
            paths.add((Path) file);
        }
        return FileVisitResult.CONTINUE;
    }
}
