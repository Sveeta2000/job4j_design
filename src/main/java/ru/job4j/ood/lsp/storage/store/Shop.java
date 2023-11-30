package ru.job4j.ood.lsp.storage.store;

import ru.job4j.ood.lsp.storage.model.Food;

public class Shop extends AbstractStore {

    @Override
    public boolean checkState(Food food) {
        double lifeLivedPercent = food.getProductLife();
        boolean result = false;
        if (lifeLivedPercent >= SHOP_START_DISCOUNT_PERCENTAGE && lifeLivedPercent < TRASH_START_PERCENTAGE) {
            food.setDiscount(DISCOUNT_AMOUNT);
        }
        if (lifeLivedPercent > WAREHOUSE_HIGHEST_PERCENTAGE && lifeLivedPercent < TRASH_START_PERCENTAGE) {
            result = true;
        }
        return result;
    }
}
