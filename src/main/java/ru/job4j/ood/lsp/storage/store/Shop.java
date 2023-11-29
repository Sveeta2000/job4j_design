package ru.job4j.ood.lsp.storage.store;

import ru.job4j.ood.lsp.storage.control.DateController;
import ru.job4j.ood.lsp.storage.model.Food;

public class Shop extends AbstractStore {
    DateController controller = new DateController();

    @Override
    public boolean checkState(Food food) {
        int lifeLivedPercent = controller.countRemainingShelfLifePercentage(food.getCreateDate(), food.getExpiryDate());
        boolean result = false;
        if (lifeLivedPercent >= 75 && lifeLivedPercent < 100) {
            food.setDiscount(20);
        }
        if (lifeLivedPercent > 25 && lifeLivedPercent < 100) {
            result = true;
        }
        return result;
    }
}
