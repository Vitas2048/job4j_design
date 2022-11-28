package ru.job4j.ood.lsp;

public class BoxingFighter implements Topfighters {
    @Override
    public int fighterRating(int kiks, int punches) {
        return punches / 2;
    }
}
