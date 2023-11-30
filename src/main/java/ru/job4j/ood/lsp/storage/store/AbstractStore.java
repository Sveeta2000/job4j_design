package ru.job4j.ood.lsp.storage.store;

import ru.job4j.ood.lsp.storage.model.Food;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {
    protected List<Food> foodStore = new ArrayList<>();
    protected final static int DISCOUNT_AMOUNT = 20;
    protected final static int WAREHOUSE_HIGHEST_PERCENTAGE = 25;
    protected final static int SHOP_START_DISCOUNT_PERCENTAGE = 75;
    protected final static int TRASH_START_PERCENTAGE = 100;

    @Override
    public boolean add(Food food) {
        boolean result = false;
        if (checkState(food)) {
            foodStore.add(food);
            result = true;
        }
        return result;
    }

    @Override
    public List<Food> findAll() {
        return foodStore;
    }
}
