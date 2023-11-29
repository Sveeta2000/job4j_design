package ru.job4j.ood.lsp.storage.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.storage.model.Food;
import ru.job4j.ood.lsp.storage.model.Milk;
import ru.job4j.ood.lsp.storage.money.Money;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

class ShopTest {
    Shop shop = new Shop();

    @Test
    void whenBetween25And75ThenTrueAndNoDiscount() {
        LocalDate created = LocalDate.now().minusDays(3);
        LocalDate expire = LocalDate.now().plusDays(7);
        Food milk = new Milk("Milk", expire, created, new Money(100, "RUB"));
        assertThat(shop.checkState(milk)).isTrue();
        assertThat(milk.getPrice().getAmount()).isEqualTo(100);
        assertThat(milk.getDiscount()).isEqualTo(0);
    }

    @Test
    void whenMoreThan75ThenTrueAndDiscount20Percent() {
        LocalDate created = LocalDate.now().minusDays(8);
        LocalDate expire = LocalDate.now().plusDays(2);
        Food milk = new Milk("Milk", expire, created, new Money(100, "RUB"));
        assertThat(shop.checkState(milk)).isTrue();
        assertThat(milk.getPrice().getAmount()).isEqualTo(80);
        assertThat(milk.getDiscount()).isEqualTo(20);
    }

    @Test
    void whenLessThan25ThenFalse() {
        LocalDate created = LocalDate.now().minusDays(1);
        LocalDate expire = LocalDate.now().plusDays(7);
        Food milk = new Milk("Milk", expire, created, new Money(100, "RUB"));
        assertThat(shop.checkState(milk)).isFalse();
    }

    @Test
    void whenMoreThan100ThenFalse() {
        LocalDate created = LocalDate.now().minusDays(10);
        LocalDate expire = LocalDate.now().minusDays(2);
        Food milk = new Milk("Milk", expire, created, new Money(100, "RUB"));
        assertThat(shop.checkState(milk)).isFalse();
    }
}