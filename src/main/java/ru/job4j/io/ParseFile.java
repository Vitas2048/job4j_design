package ru.job4j.io;

import java.io.*;
import java.util.Objects;
import java.util.function.Predicate;

public final class ParseFile {
    private final File file;

    public ParseFile(File f) {
        file = f;
    }

    public synchronized String getContentIf(Predicate<Character> filter) throws IOException {
        String output = "";
        try (InputStream i = new FileInputStream(file)) {
            int data;
            while ((data = i.read()) != -1) {
                if (filter.test((char) data)) {
                    output = String.format("%s%s", output, (char) data);
                }
            }
        }
        return output;
    }

    public synchronized String getContent() throws IOException {
        return getContentIf(data -> true);
    }

    public synchronized String getContentWithoutUnicode() throws IOException {
        Predicate<Character> withoutUnicode = i -> (i < 0x80);
        return getContentIf(withoutUnicode);
    }
}