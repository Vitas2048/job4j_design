package ru.job4j.ood.dip.penxample;

public class BluePen extends Pen {
    @Override
    public void draw() {
        LOGGER.trace("Drown blue line");
    }
}
