package ru.job4j.ood.ocp;

import java.util.Date;

public class SystemOut implements Out {
    @Override
    public void print() {
    }

    public void printDate(Date date) {
        System.out.println(date.getTime());
    }

    public void printDateAfter(Date date) {
        System.out.println(date.after(date));
    }
}
