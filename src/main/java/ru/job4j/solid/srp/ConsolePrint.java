package ru.job4j.solid.srp;

import java.io.FileOutputStream;
import java.util.Random;

public class ConsolePrint implements Print {

    @Override
    public void print() {
        SpeedDistTime speed = new SpeedDistTime();
        System.out.println(calculate());
    }

    public void printFile() {
        SpeedDistTime speed = new SpeedDistTime();
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
                out.write(speed.toString().getBytes());
                out.write(System.lineSeparator().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int calculate() {
        return 5 + 5;
    }

    public int generate() {
        Random random = new Random();
        return random.nextInt();
    }
}
