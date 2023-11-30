package ru.job4j.ood.lsp.storage.store;

import ru.job4j.ood.lsp.storage.model.Food;

public class Warehouse extends AbstractStore {

    @Override
    public boolean checkState(Food food) {
        return food.getProductLife() <= WAREHOUSE_HIGHEST_PERCENTAGE;
    }
}
