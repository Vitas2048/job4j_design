package ru.job4j.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.List;
import java.util.regex.Pattern;

public class FindFile {

    public static List<Path> findName(String param, String path) throws IOException  {
        Path start = Path.of(path);
        return Search.search(start, p -> p.toFile().getName().equals(param));
    }

    public static List<Path> findMask(String param, String path) throws IOException {
        Path start = Path.of(path);
        param = String.format("glob:%s",  param);
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher(param);
        return Search.search(start, p -> matcher.matches(p.toFile().toPath()));
    }

    public static List<Path> findRegex(String param, String path) throws IOException {
        Path start = Path.of(path);
        Pattern pattern = Pattern.compile(param);
        return Search.search(start, p -> pattern.matcher(p.toFile().toPath().toString()).find());
    }

    public static List<Path> finaly(String type, String param, String path) throws IOException {
        if ("mask".equals(type)) {
            return findMask(param, path);
        }
        if ("regex".equals(type)) {
            return findRegex(param, path);
        }
        if ("name".equals(type)) {
            return findName(param, path);
        }
        return null;
    }

    public static void validation(String[] n) {
        ArgsName arg = ArgsName.of(n);
        String path = arg.get("d");
        String param = arg.get("n");
        String type = arg.get("t");
        String res = arg.get("o");
        File file = new File(path);
        File filer = new File(res);
        if (n.length != 4) {
            throw new IllegalArgumentException("Введите 4 параметра");
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", path));
        }
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", path));
        }
        if (!filer.isFile()) {
            throw new IllegalArgumentException(String.format("Not File %s", res));
        }
        if (!"mask".equals(type) && !"regex".equals(type) && !"name".equals(type)) {
            throw new IllegalArgumentException((String.format("введите параметры поиска - %s", type)));
        }
        if ("name".equals(type) && !param.contains(".")) {
            throw new IllegalArgumentException((String.format("для нахождения по имени нужно указать расширение - %s", param)));
        }
        if ("mask".equals(type) && !param.contains("?") && !param.contains("*") && !param.contains(".")) {
            throw new IllegalArgumentException((String.format("для нахождения по маске должны быть символы '*', '?', '.'  - %s", param)));
        }


    }

    public static void main(String[] args) throws IOException {
        List<Path> list;
        validation(args);
        ArgsName arg = ArgsName.of(args);
        String path = arg.get("d");
        String param = arg.get("n");
        String type = arg.get("t");
        String res = arg.get("o");
        list = finaly(type, param, path);
        try (FileOutputStream out = new FileOutputStream(res)) {
            for (Path p:list) {
                out.write((p.toString()).getBytes());
                out.write(System.lineSeparator().getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
