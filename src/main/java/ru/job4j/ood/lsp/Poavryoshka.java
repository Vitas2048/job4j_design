package ru.job4j.ood.lsp;

public class Poavryoshka extends Loszhka {

    public Poavryoshka(int capacity) {
        super(capacity);
    }


    public void estSoup(int yeomkost) {
        if (yeomkost < 0) {
            throw new IllegalArgumentException("Invalid yemkost");
        }
        if (yeomkost + 50 < capacity) {
            throw new IllegalArgumentException("ne udobno est sup");
        }
    }
}
