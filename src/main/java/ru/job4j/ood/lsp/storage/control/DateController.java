package ru.job4j.ood.lsp.storage.control;

import ru.job4j.ood.lsp.storage.model.Food;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class DateController {
    public Food countRemainingShelfLifePercentage(LocalDate date, Food food) {
        long totalLife = DAYS.between(food.getExpiryDate(), food.getCreateDate());
        long daysLived = DAYS.between(date, food.getCreateDate());
        food.setProductLife(((double) daysLived / totalLife) * 100);
        return food;
    }
}
