package ru.job4j.ood.lsp.storage.store;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.storage.control.DateController;
import ru.job4j.ood.lsp.storage.model.Food;
import ru.job4j.ood.lsp.storage.model.Milk;
import ru.job4j.ood.lsp.storage.money.Money;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

class TrashTest {
    private Trash trash = new Trash();
    private DateController controller = new DateController();

    @Test
    void whenMoreThan100ThenTrue() {
        LocalDate today = LocalDate.now();
        LocalDate created = LocalDate.now().minusDays(10);
        LocalDate expire = LocalDate.now().minusDays(1);
        Food milk = new Milk("Milk", expire, created, new Money(100, "RUB"));
        controller.countRemainingShelfLifePercentage(today, milk);
        assertThat(trash.checkState(milk)).isTrue();
    }

    @Test
    void whenLessThan100ThenFalse() {
        LocalDate today = LocalDate.now();
        LocalDate created = LocalDate.now().minusDays(9);
        LocalDate expire = LocalDate.now().plusDays(1);
        Food milk = new Milk("Milk", expire, created, new Money(100, "RUB"));
        controller.countRemainingShelfLifePercentage(today, milk);
        assertThat(trash.checkState(milk)).isFalse();
    }
}