package ru.job4j.ood.lsp;

public class Pencil {

    void draw() {
        System.out.println("Drawing");
    }

    void erase(EraseInstriment eraseInstriment) {
        if (eraseInstriment.getClass() == Eraser.class) {
            System.out.println("Erased");
        }
    }
}
