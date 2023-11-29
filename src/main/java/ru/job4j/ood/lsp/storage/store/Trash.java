package ru.job4j.ood.lsp.storage.store;

import ru.job4j.ood.lsp.storage.control.DateController;
import ru.job4j.ood.lsp.storage.model.Food;

public class Trash extends AbstractStore {
    DateController controller = new DateController();

    @Override
    public boolean checkState(Food food) {
        return controller.countRemainingShelfLifePercentage(food.getCreateDate(), food.getExpiryDate()) >= 100;
    }
}
