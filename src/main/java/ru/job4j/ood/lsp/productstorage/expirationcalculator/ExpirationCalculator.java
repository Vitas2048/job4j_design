package ru.job4j.ood.lsp.productstorage.expirationcalculator;

public interface ExpirationCalculator<T> {
    double calculateInPercent(T startDate, T endDate);
}
