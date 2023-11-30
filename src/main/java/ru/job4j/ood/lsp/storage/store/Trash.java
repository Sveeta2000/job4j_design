package ru.job4j.ood.lsp.storage.store;

import ru.job4j.ood.lsp.storage.model.Food;

public class Trash extends AbstractStore {

    @Override
    public boolean checkState(Food food) {
        return food.getProductLife() >= TRASH_START_PERCENTAGE;
    }
}
