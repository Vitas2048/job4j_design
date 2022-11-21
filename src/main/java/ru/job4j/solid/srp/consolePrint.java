package ru.job4j.solid.srp;

import java.io.FileOutputStream;

public class consolePrint implements Print {

    @Override
    public void print() {
        SpeedDistTime speed = new SpeedDistTime();
        System.out.println(speed);
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
}
