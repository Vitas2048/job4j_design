package ru.job4j.solid.srp;

public class SingleExample {
    private static SingleExample instance = null;

    private SingleExample(){
    }

    public static SingleExample getInstance() {
        if (instance == null) {
            instance = new SingleExample();
        }
        return instance;
    }
}
