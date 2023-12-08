package ru.job4j.ood.lsp.storage.control;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.lsp.storage.model.Food;
import ru.job4j.ood.lsp.storage.model.Milk;
import ru.job4j.ood.lsp.storage.model.Yoghurt;
import ru.job4j.ood.lsp.storage.money.Money;
import ru.job4j.ood.lsp.storage.store.Shop;
import ru.job4j.ood.lsp.storage.store.Store;
import ru.job4j.ood.lsp.storage.store.Trash;
import ru.job4j.ood.lsp.storage.store.Warehouse;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

class ControlQualityTest {

    @Test
    void whenResortThenMovesToStoreFromWarehouse() {
        ControlQuality controlQuality = new ControlQuality();
        Store warehouse = new Warehouse();
        controlQuality.addStore(warehouse);
        Store shop = new Shop();
        controlQuality.addStore(shop);
        LocalDate created = LocalDate.now().minusDays(2);
        LocalDate expire = LocalDate.now().plusDays(8);
        LocalDate today = LocalDate.now();
        Food milk = new Milk("Milk", expire, created, new Money(100, "RUB"));
        assertThat(controlQuality.checkQuality(milk, today)).isTrue();
        LocalDate newDay = today.plusDays(5);
        controlQuality.resort(newDay);
        assertThat(warehouse.findAll()).isEmpty();
        assertThat(shop.findAll()).contains(milk);
    }

    @Test
    void whenResortThenMovesToTrashFromStore() {
        ControlQuality controlQuality = new ControlQuality();
        Store shop = new Shop();
        controlQuality.addStore(shop);
        Store trash = new Trash();
        controlQuality.addStore(trash);
        LocalDate created = LocalDate.now().minusDays(2);
        LocalDate expire = LocalDate.now().plusDays(3);
        LocalDate today = LocalDate.now();
        Food yoghurt = new Yoghurt("Danone", expire, created, new Money(50, "RUB"));
        assertThat(controlQuality.checkQuality(yoghurt, today)).isTrue();
        LocalDate newDay = today.plusDays(4);
        controlQuality.resort(newDay);
        assertThat(shop.findAll()).isEmpty();
        assertThat(trash.findAll()).contains(yoghurt);
    }

    @Test
    void whenAddFreshThenGoesToWarehouse() {
        ControlQuality controlQuality = new ControlQuality();
        controlQuality.addStore(new Warehouse());
        LocalDate created = LocalDate.now().minusDays(1);
        LocalDate expire = LocalDate.now().plusDays(10);
        LocalDate today = LocalDate.now();
        Food milk = new Milk("Milk", expire, created, new Money(100, "RUB"));
        Food yoghurt = new Yoghurt("Danone", expire, LocalDate.now(), new Money(50, "RUB"));
        assertThat(controlQuality.checkQuality(milk, today)).isTrue();
        assertThat(controlQuality.checkQuality(yoghurt, today)).isTrue();
    }

    @Test
    void whenAddMediumThenGoesToShop() {
        ControlQuality controlQuality = new ControlQuality();
        controlQuality.addStore(new Shop());
        LocalDate created = LocalDate.now().minusDays(3);
        LocalDate expire = LocalDate.now().plusDays(7);
        LocalDate today = LocalDate.now();
        Food milk = new Milk("Milk", expire, created, new Money(100, "RUB"));
        assertThat(controlQuality.checkQuality(milk, today)).isTrue();
    }

    @Test
    void whenAddExpiredThenGoesToTrash() {
        ControlQuality controlQuality = new ControlQuality();
        controlQuality.addStore(new Trash());
        LocalDate created = LocalDate.now().minusDays(10);
        LocalDate expire = LocalDate.now().minusDays(1);
        LocalDate today = LocalDate.now();
        Food milk = new Milk("Milk", expire, created, new Money(100, "RUB"));
        Food yoghurt = new Yoghurt("Danone", LocalDate.now(), created, new Money(50, "RUB"));
        assertThat(controlQuality.checkQuality(milk, today)).isTrue();
        assertThat(controlQuality.checkQuality(yoghurt, today)).isTrue();
    }

    @Test
    void whenAddFreshAndNoWarehouseThenFalse() {
        ControlQuality controlQuality = new ControlQuality();
        controlQuality.addStore(new Trash());
        controlQuality.addStore(new Shop());
        LocalDate created = LocalDate.now().minusDays(1);
        LocalDate expire = LocalDate.now().plusDays(10);
        LocalDate today = LocalDate.now();
        Food milk = new Milk("Milk", expire, created, new Money(100, "RUB"));
        Food yoghurt = new Yoghurt("Danone", expire, LocalDate.now(), new Money(50, "RUB"));
        assertThat(controlQuality.checkQuality(milk, today)).isFalse();
        assertThat(controlQuality.checkQuality(yoghurt, today)).isFalse();
    }

    @Test
    void whenAddMediumAndNoShopThenFalse() {
        ControlQuality controlQuality = new ControlQuality();
        controlQuality.addStore(new Warehouse());
        controlQuality.addStore(new Trash());
        LocalDate created = LocalDate.now().minusDays(3);
        LocalDate expire = LocalDate.now().plusDays(7);
        LocalDate today = LocalDate.now();
        Food milk = new Milk("Milk", expire, created, new Money(100, "RUB"));
        assertThat(controlQuality.checkQuality(milk, today)).isFalse();
    }

    @Test
    void whenAddExpiredAndNoTrashThenFalse() {
        ControlQuality controlQuality = new ControlQuality();
        controlQuality.addStore(new Warehouse());
        controlQuality.addStore(new Shop());
        LocalDate created = LocalDate.now().minusDays(10);
        LocalDate expire = LocalDate.now().minusDays(1);
        LocalDate today = LocalDate.now();
        Food milk = new Milk("Milk", expire, created, new Money(100, "RUB"));
        Food yoghurt = new Yoghurt("Danone", LocalDate.now(), created, new Money(50, "RUB"));
        assertThat(controlQuality.checkQuality(milk, today)).isFalse();
        assertThat(controlQuality.checkQuality(yoghurt, today)).isFalse();
    }

}