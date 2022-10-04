package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public static void validation(ArgsName argsName) {
        if (argsName.get("d").startsWith(".")) {
            throw new IllegalArgumentException("It's need to be file extension");
        }
        if (argsName.get("e").endsWith(".zip")) {
            throw new IllegalArgumentException("It's need to be zip extension");
        }
        File file = new File(argsName.get("d"));
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
    }

    public void packFiles(List<Path> sources, String target) {
            try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
                for (Path p:sources) {
                    zip.putNextEntry(new ZipEntry(p.toString()));
                    try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(p.toString()))) {
                        zip.write(out.readAllBytes());
                    }
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 3) {
            throw new IllegalArgumentException("Root folder is null. Usage  ROOT_FOLDER.");
        }
        ArgsName argsName =  ArgsName.of(args);
        validation(argsName);
        List<Path> sources = Search.search(Paths.get(argsName.get("d")), s -> !s.toFile().getName().endsWith(argsName.get("e")));
        Zip zip = new Zip();
        zip.packFiles(sources, argsName.get("o"));
        zip.packSingleFile(
                new File("./pom.xml"),
                new File("./pom.zip")
        );
    }
}