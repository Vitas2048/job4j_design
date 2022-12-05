package ru.job4j.ood.dip.penxample;

import org.apache.log4j.Logger;

public abstract class Pen {

    protected static final Logger LOGGER = Logger.getLogger("logger");
    abstract void draw();
}
