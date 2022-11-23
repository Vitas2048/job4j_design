package ru.job4j.ood.ocp;

public class Alphabet {
    public void check(AbstractLet letter) {
        int s;
        if (letter instanceof A) {
            s = 1;
        }
        if (letter instanceof B) {
            s = 2;
        }
        if (letter instanceof C) {
            s = 3;
        }
    }
}
