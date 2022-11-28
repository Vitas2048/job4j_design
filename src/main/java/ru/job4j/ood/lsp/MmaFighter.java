package ru.job4j.ood.lsp;

public class MmaFighter implements Topfighters {
    @Override
    public int fighterRating(int kiks, int punches) {
        if (kiks < 0) {
            throw new IllegalArgumentException("Must be kicks");
        }
        return kiks * punches / 2;
    }
}
