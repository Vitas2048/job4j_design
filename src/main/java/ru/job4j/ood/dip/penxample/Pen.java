package ru.job4j.ood.dip.penxample;

import org.apache.log4j.Logger;

public abstract class Pen {

    final Logger LOGGER = Logger.getLogger("Shop logger");
    abstract void draw();
}
