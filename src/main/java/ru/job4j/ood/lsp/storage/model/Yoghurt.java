package ru.job4j.ood.lsp.storage.model;

import ru.job4j.ood.lsp.storage.money.Money;

import java.time.LocalDate;

public class Yoghurt extends Food {
    public Yoghurt(String name, LocalDate expiryDate, LocalDate createDate, Money price) {
        super(name, expiryDate, createDate, price);
    }
}
