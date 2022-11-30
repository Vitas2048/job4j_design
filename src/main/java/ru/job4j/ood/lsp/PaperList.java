package ru.job4j.ood.lsp;

public class PaperList {
    public static void main(String[] args) {
        Pen pen = new Pen();
        Pencil pencil = new Pencil();
        EraseInstriment eraser = new Eraser();
        pencil.draw();
        pencil.erase(eraser);
        pen.draw();
        pen.erase(eraser);
    }
}
