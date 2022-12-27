package ru.job4j.io;

import java.io.*;

public final class SaveFile {
    private final File file;

    public SaveFile(File f) {
        file = f;
    }
    public synchronized void saveContent(String content) throws IOException {
        OutputStream o = new FileOutputStream(file);
        for (int i = 0; i < content.length(); i += 1) {
            o.write(content.charAt(i));
        }
        o.close();
    }

}