package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.random;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        boolean b = false;
        boolean f = false;
        List<String> phrases = readPhrases();
        List<String> log = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        while (!b) {
            String phrase = phrases.get((int) (random() * (phrases.size() - 1)));
            String s = in.next();
            log.add(s);
            if (!f || s.equals(CONTINUE) || s.equals(OUT)) {
                switch (s) {
                    case (CONTINUE) -> f = false;
                    case (STOP) -> f = true;
                    case (OUT) -> b = true;
                    default -> {
                        System.out.println(phrase);
                        log.add(phrase);
                    }
                }
            }

        }
        saveLog(log);
    }

    private List<String> readPhrases() {
        List<String> phrases = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(botAnswers))) {
            in.lines().forEach(phrases::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return phrases;
    }

    private void saveLog(List<String> log) {
        try (FileOutputStream out = new FileOutputStream(path)) {
            for (String s:log) {
                out.write((s).getBytes());
                out.write(System.lineSeparator().getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("log.txt", "input.txt");
        cc.run();
    }
}
