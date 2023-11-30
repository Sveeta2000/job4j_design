package ru.job4j.ood.lsp.storage.model;

import ru.job4j.ood.lsp.storage.money.Money;

import java.time.LocalDate;

public abstract class Food {
    protected String name;
    protected LocalDate expiryDate;
    protected LocalDate createDate;
    /**
     * поле price содержит цену в минимальной единице измерения для валюты и саму валюту.
     * Для рублей - это копейки.
     */
    protected Money price;
    /**
     * поле содержит скидку в процентах
     */
    protected int discount;

    protected double productLife;

    public Food(String name, LocalDate expiryDate, LocalDate createDate, Money price) {
        this.name = name;
        this.expiryDate = expiryDate;
        this.createDate = createDate;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public Money getPrice() {
        return price;
    }

    public void setPrice(Money price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;

        this.price.setAmount(this.price.getAmount() - (this.price.getAmount() * discount / 100));
    }

    public double getProductLife() {
        return productLife;
    }

    public void setProductLife(double productLife) {
        this.productLife = productLife;
    }
}
