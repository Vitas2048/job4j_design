package ru.job4j.ood.dip.penxample;

public class RedPen extends Pen {

    @Override
    public void draw() {
        LOGGER.trace("Drown red line");
    }
}
