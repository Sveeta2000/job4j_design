package ru.job4j.ood.lsp.storage.control;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.storage.model.Food;
import ru.job4j.ood.lsp.storage.model.Milk;
import ru.job4j.ood.lsp.storage.model.Yoghurt;
import ru.job4j.ood.lsp.storage.money.Money;
import ru.job4j.ood.lsp.storage.store.Shop;
import ru.job4j.ood.lsp.storage.store.Trash;
import ru.job4j.ood.lsp.storage.store.Warehouse;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

class ControlQualityTest {
    @Test
    void whenAddFreshThenGoesToWarehouse() {
        ControlQuality controlQuality = new ControlQuality();
        controlQuality.addStore(new Warehouse());
        LocalDate created = LocalDate.now().minusDays(1);
        LocalDate expire = LocalDate.now().plusDays(10);
        Food milk = new Milk("Milk", expire, created, new Money(100, "RUB"));
        Food yoghurt = new Yoghurt("Danone", expire, LocalDate.now(), new Money(50, "RUB"));
        assertThat(controlQuality.checkQuality(milk)).isTrue();
        assertThat(controlQuality.checkQuality(yoghurt)).isTrue();
    }

    @Test
    void whenAddMediumThenGoesToShop() {
        ControlQuality controlQuality = new ControlQuality();
        controlQuality.addStore(new Shop());
        LocalDate created = LocalDate.now().minusDays(3);
        LocalDate expire = LocalDate.now().plusDays(7);
        Food milk = new Milk("Milk", expire, created, new Money(100, "RUB"));
        assertThat(controlQuality.checkQuality(milk)).isTrue();
    }

    @Test
    void whenAddExpiredThenGoesToTrash() {
        ControlQuality controlQuality = new ControlQuality();
        controlQuality.addStore(new Trash());
        LocalDate created = LocalDate.now().minusDays(10);
        LocalDate expire = LocalDate.now().minusDays(1);
        Food milk = new Milk("Milk", expire, created, new Money(100, "RUB"));
        Food yoghurt = new Yoghurt("Danone", LocalDate.now(), created, new Money(50, "RUB"));
        assertThat(controlQuality.checkQuality(milk)).isTrue();
        assertThat(controlQuality.checkQuality(yoghurt)).isTrue();
    }

    @Test
    void whenAddFreshAndNoWarehouseThenFalse() {
        ControlQuality controlQuality = new ControlQuality();
        controlQuality.addStore(new Trash());
        controlQuality.addStore(new Shop());
        LocalDate created = LocalDate.now().minusDays(1);
        LocalDate expire = LocalDate.now().plusDays(10);
        Food milk = new Milk("Milk", expire, created, new Money(100, "RUB"));
        Food yoghurt = new Yoghurt("Danone", expire, LocalDate.now(), new Money(50, "RUB"));
        assertThat(controlQuality.checkQuality(milk)).isFalse();
        assertThat(controlQuality.checkQuality(yoghurt)).isFalse();
    }

    @Test
    void whenAddMediumAndNoShopThenFalse() {
        ControlQuality controlQuality = new ControlQuality();
        controlQuality.addStore(new Warehouse());
        controlQuality.addStore(new Trash());
        LocalDate created = LocalDate.now().minusDays(3);
        LocalDate expire = LocalDate.now().plusDays(7);
        Food milk = new Milk("Milk", expire, created, new Money(100, "RUB"));
        assertThat(controlQuality.checkQuality(milk)).isFalse();
    }

    @Test
    void whenAddExpiredAndNoTrashThenFalse() {
        ControlQuality controlQuality = new ControlQuality();
        controlQuality.addStore(new Warehouse());
        controlQuality.addStore(new Shop());
        LocalDate created = LocalDate.now().minusDays(10);
        LocalDate expire = LocalDate.now().minusDays(1);
        Food milk = new Milk("Milk", expire, created, new Money(100, "RUB"));
        Food yoghurt = new Yoghurt("Danone", LocalDate.now(), created, new Money(50, "RUB"));
        assertThat(controlQuality.checkQuality(milk)).isFalse();
        assertThat(controlQuality.checkQuality(yoghurt)).isFalse();
    }

}