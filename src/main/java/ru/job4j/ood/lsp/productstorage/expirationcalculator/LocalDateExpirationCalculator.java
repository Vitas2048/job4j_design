package ru.job4j.ood.lsp.productstorage.expirationcalculator;



import java.time.LocalDate;

import java.time.temporal.ChronoUnit;

public class LocalDateExpirationCalculator implements ExpirationCalculator<LocalDate> {
    @Override
    public double calculateInPercent(LocalDate startDate, LocalDate endDate) {
        var now = ChronoUnit.DAYS.between(LocalDate.now(), startDate);
        var expired = ChronoUnit.DAYS.between(endDate, startDate);
        return (double) now * 100 / expired;
    }
}
