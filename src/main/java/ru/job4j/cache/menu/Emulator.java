package ru.job4j.cache.menu;

import ru.job4j.cache.DirFileCache;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Emulator {

    public static final String MENU = """
                Введите 0, чтобы указать директорию.
                Введите 1, загрузить файл в кэш.
                Введите 2, вывести кэш на экран.
                Введите 3, чтобы закончить.
                """;

    public static final int SET_DIRECTORY = 0;

    public static final int INSERT_CACHE = 1;

    public static final int SHOW_CACHE = 2;

    public static final int EXIT = 3;

    public static DirFileCache setDir(String s) {
        return new DirFileCache(s);
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        DirFileCache dir = null;
        boolean run = true;
        String source;
        while (run) {
            System.out.println(MENU);
            int userChoice = Integer.parseInt(scanner.nextLine());
            if (SET_DIRECTORY == userChoice) {
                System.out.println("Укажите директорию");
                source = scanner.nextLine();
                dir = new DirFileCache(source);
            } else if (INSERT_CACHE == userChoice) {
                System.out.println("Укажите имя файла, с которого будут считаны данные");
                String fileName = scanner.nextLine();
                dir.get(fileName);
            } else if (SHOW_CACHE == userChoice) {
                System.out.println("Укажите файл, данные которого вывести на экране");
                String file = scanner.nextLine();
                System.out.println(dir.get(file));
            } else if (EXIT == userChoice) {
                System.out.println("Завершение программы...");
                run = false;
            }
        }
    }
}
