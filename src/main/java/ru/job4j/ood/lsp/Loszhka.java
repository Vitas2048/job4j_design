package ru.job4j.ood.lsp;

public class Loszhka {

    public int capacity;

    public Loszhka(int capacity) {
        this.capacity = capacity;
    }

    public void estSoup(int yeomkost) {
        if (yeomkost < 0) {
            throw new IllegalArgumentException("Invalid yemkost");
        }
        if (yeomkost < capacity) {
            throw new IllegalArgumentException("ne udobno est sup");
        }
    }
}
