package ru.job4j.ood.lsp.storage.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.storage.model.Food;
import ru.job4j.ood.lsp.storage.model.Milk;
import ru.job4j.ood.lsp.storage.money.Money;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

class WarehouseTest {

    Warehouse warehouse = new Warehouse();

    @Test
    void whenLessThan25ThenTrue() {
        LocalDate created = LocalDate.now().minusDays(1);
        LocalDate expire = LocalDate.now().plusDays(7);
        Food milk = new Milk("Milk", expire, created, new Money(100, "RUB"));
        assertThat(warehouse.checkState(milk)).isTrue();
    }

    @Test
    void whenMoreThan25ThenFalse() {
        LocalDate created = LocalDate.now().minusDays(3);
        LocalDate expire = LocalDate.now().plusDays(1);
        Food milk = new Milk("Milk", expire, created, new Money(100, "RUB"));
        assertThat(warehouse.checkState(milk)).isFalse();
    }

}