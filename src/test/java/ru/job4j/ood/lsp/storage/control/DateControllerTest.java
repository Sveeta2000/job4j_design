package ru.job4j.ood.lsp.storage.control;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.storage.model.Food;
import ru.job4j.ood.lsp.storage.model.Milk;
import ru.job4j.ood.lsp.storage.money.Money;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

class DateControllerTest {
    DateController controller = new DateController();

    @Test
    void whenTodayIsCreateDayThen0() {
        LocalDate today = LocalDate.now();
        LocalDate expiry = LocalDate.now().plusDays(10);
        Food milk = new Milk("Milk", expiry, today, new Money(100, "RUB"));
        controller.countRemainingShelfLifePercentage(today, milk);
        assertThat(milk.getProductLife()).isEqualTo(0);
    }

    @Test
    void whenTodayIsExpiryDayThen100() {
        LocalDate created = LocalDate.now().minusDays(10);
        LocalDate expiry = LocalDate.now();
        Food milk = new Milk("Milk", expiry, created, new Money(100, "RUB"));
        controller.countRemainingShelfLifePercentage(LocalDate.now(), milk);
        assertThat(milk.getProductLife()).isEqualTo(100);
    }

    @Test
    void whenLifeIsLessThan25Percent() {
        LocalDate created = LocalDate.now().minusDays(2);
        LocalDate expiry = LocalDate.now().plusDays(7);
        Food milk = new Milk("Milk", expiry, created, new Money(100, "RUB"));
        controller.countRemainingShelfLifePercentage(LocalDate.now(), milk);
        assertThat(milk.getProductLife()).isCloseTo(22.0, Percentage.withPercentage(5.0));
    }

    @Test
    void whenLifeIsMoreThan25PercentAndLessThan75() {
        LocalDate created = LocalDate.now().minusDays(5);
        LocalDate expiry = LocalDate.now().plusDays(5);
        Food milk = new Milk("Milk", expiry, created, new Money(100, "RUB"));
        controller.countRemainingShelfLifePercentage(LocalDate.now(), milk);
        assertThat(milk.getProductLife()).isEqualTo(50);
    }

    @Test
    void whenLifeIsMoreThan75PercentAndLessThan100() {
        LocalDate created = LocalDate.now().minusDays(8);
        LocalDate expiry = LocalDate.now().plusDays(2);
        Food milk = new Milk("Milk", expiry, created, new Money(100, "RUB"));
        controller.countRemainingShelfLifePercentage(LocalDate.now(), milk);
        assertThat(milk.getProductLife()).isEqualTo(80);
    }
}