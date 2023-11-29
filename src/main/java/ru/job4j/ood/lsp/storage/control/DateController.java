package ru.job4j.ood.lsp.storage.control;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class DateController {
    public int countRemainingShelfLifePercentage(LocalDate created, LocalDate expiry) {
        LocalDate today = LocalDate.now();
        long totalLife = DAYS.between(expiry, created);
        long daysLived = DAYS.between(today, created);
        return Math.round(((float) daysLived / totalLife) * 100);
    }
}
