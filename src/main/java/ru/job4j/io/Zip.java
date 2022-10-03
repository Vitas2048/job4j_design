package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public static void validation(String[] n) {
        if (n.length != 3) {
            throw new IllegalArgumentException("Root folder is null. Usage  ROOT_FOLDER.");
        }
        if (!n[1].startsWith(".")) {
            throw new IllegalArgumentException("It's need to be file extension");
        }
        if (!n[2].endsWith(".zip")) {
            throw new IllegalArgumentException("It's need to be zip extension");
        }
        File file = new File(n[0]);
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
    }

    public void packFiles(List<Path> sources, Path target) {
            try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(String.valueOf(target))))) {
                for (Path p:sources) {
                    zip.putNextEntry(new ZipEntry(String.valueOf(p)));
                    try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(String.valueOf(p)))) {
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
        ArgsName argsName =  ArgsName.of(args);
        String[] st = new String[3];
        st[0] = argsName.get("d");
        st[1] = argsName.get("e");
        st[2] = argsName.get("o");
        validation(st);
        List<Path> sources = Search.search(Paths.get(argsName.get("d")).toAbsolutePath(), s->!s.toFile().getName().endsWith(argsName.get("e")));
        Path target = Paths.get(argsName.get("o"));
        Zip zip = new Zip();
        zip.packFiles(sources, target);
        zip.packSingleFile(
                new File("./pom.xml"),
                new File("./pom.zip")
        );
    }
}