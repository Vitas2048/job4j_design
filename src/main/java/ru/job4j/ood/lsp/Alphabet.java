package ru.job4j.ood.lsp;


public class Alphabet {
    public void check(AbstractLet letter, AbstractLet letter2) {
        int s;
        if (letter.getClass() == letter2.getClass()) {
            s = 2;
        }
    }
}
