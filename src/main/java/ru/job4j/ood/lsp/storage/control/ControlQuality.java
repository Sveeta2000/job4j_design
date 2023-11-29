package ru.job4j.ood.lsp.storage.control;

import ru.job4j.ood.lsp.storage.model.Food;
import ru.job4j.ood.lsp.storage.store.Store;

import java.util.ArrayList;
import java.util.List;

public class ControlQuality {
    List<Store> stores = new ArrayList<>();

    public boolean addStore(Store store) {
        return this.stores.add(store);
    }

    public boolean checkQuality(Food food) {
        boolean isAllocated = false;
        for (Store store : stores) {
            if (store.add(food)) {
                isAllocated = true;
                break;
            }
        }
        return isAllocated;
    }
}
