package ru.job4j.ood.lsp.storage.control;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

class DateControllerTest {
    DateController controller = new DateController();

    @Test
    void whenTodayIsCreateDayThen0() {
        LocalDate today = LocalDate.now();
        LocalDate expiry = LocalDate.now().plusDays(10);
        assertThat(controller.countRemainingShelfLifePercentage(today, expiry)).isEqualTo(0);
    }

    @Test
    void whenTodayIsExpiryDayThen100() {
        LocalDate created = LocalDate.now().minusDays(10);
        LocalDate expiry = LocalDate.now();
        assertThat(controller.countRemainingShelfLifePercentage(created, expiry)).isEqualTo(100);
    }

    @Test
    void whenLifeIsLessThan25Percent() {
        LocalDate created = LocalDate.now().minusDays(2);
        LocalDate expiry = LocalDate.now().plusDays(7);
        assertThat(controller.countRemainingShelfLifePercentage(created, expiry)).isEqualTo(22);
    }

    @Test
    void whenLifeIsMoreThan25PercentAndLessThan75() {
        LocalDate created = LocalDate.now().minusDays(5);
        LocalDate expiry = LocalDate.now().plusDays(5);
        assertThat(controller.countRemainingShelfLifePercentage(created, expiry)).isEqualTo(50);
    }

    @Test
    void whenLifeIsMoreThan75PercentAndLessThan100() {
        LocalDate created = LocalDate.now().minusDays(8);
        LocalDate expiry = LocalDate.now().plusDays(2);
        assertThat(controller.countRemainingShelfLifePercentage(created, expiry)).isEqualTo(80);
    }
}