package ru.job4j.ood.dip.penxample;

public class PaperList {
    private Pen pen = new BluePen();

    public PaperList() {
    }

    public static void main(String[] args) {
        PaperList list = new PaperList();
        list.drawOnPaper();
    }

    public void drawOnPaper() {
        this.pen.draw();
    }


}
