package ru.job4j.ood.ocp;

import java.util.Date;

public class SystemOut implements Out {

    private Ferrarri ferrarri;

    public SystemOut(Ferrarri ferrarri) {
        this.ferrarri = ferrarri;
    }

    @Override
    public void print() {
    }
}
