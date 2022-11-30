package ru.job4j.ood.lsp;

public class Pen extends Pencil {
    @Override
    void erase(EraseInstriment eraseInstriment) {
        System.out.println("Erased");
    }
}
