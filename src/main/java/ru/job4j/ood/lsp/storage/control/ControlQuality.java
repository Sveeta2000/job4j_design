package ru.job4j.ood.lsp.storage.control;

import ru.job4j.ood.lsp.storage.model.Food;
import ru.job4j.ood.lsp.storage.store.Store;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ControlQuality {
    private List<Store> stores = new ArrayList<>();
    private final DateController controller = new DateController();

    public boolean addStore(Store store) {
        return this.stores.add(store);
    }

    public boolean checkQuality(Food food, LocalDate date) {
        boolean isAllocated = false;
        controller.countRemainingShelfLifePercentage(date, food);
        for (Store store : stores) {
            if (store.add(food)) {
                isAllocated = true;
                break;
            }
        }
        return isAllocated;
    }

    public void resort(LocalDate today) {
        List<Food> temp = new ArrayList<>();
        for (Store store : stores) {
            temp.addAll(store.findAll());
            store.findAll().clear();
        }
        temp.forEach(food -> checkQuality(food, today));
    }
}
