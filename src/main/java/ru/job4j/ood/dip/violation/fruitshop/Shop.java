package ru.job4j.ood.dip.violation.fruitshop;

import java.util.HashMap;
import java.util.Map;

/**
 * Для исправления данных нарушений нужно :
 * 1. Выделить абстрактный Товар, от которого будут наследоваться все возможные товары магазина, включая Фрукты.
 * 2. Заменить поле класса магазина на Map<Good, Integer>, где Good - абстрактный товар.
 * 3. Заменить аргумент конструктора на Map<Good, Integer>.
 * 4. В методе покупки использовать абстрактный Товар в качестве аргумента.
 * 5. В методе поиска возвращать Товар.
 */
public class Shop {
    /**
     * Пример 1. Нарушение принципа DIP в поле класса и в аргументе конструктора.
     * Магазин зависит от конкретной реализации Карты, более того,
     * сама карта также зависит не от абстракции, а от реализации.
     */
    HashMap<Fruit, Integer> shelves;

    public Shop(HashMap<Fruit, Integer> shelves) {
        this.shelves = shelves;
    }

    /**
     * Пример 2. Нарушение принципа DIP в аргументе метода.
     * Если магазин захочет продавать новый тип продукта, то возникнет проблема с методом покупки,
     * так как он зависит от класса Фрукт.
     */
    public void buy(Fruit fruit) {
        System.out.println("You are buying one " + fruit.getName()
                + ". The price is " + fruit.getPrice() + ".");
    }

    /**
     * Пример 3. Нарушение принципа DIP в возвращаемом значении метода.
     * Если магазин захочет продавать новый тип продукта, то возникнет проблема с реализацией поиска других продуктов,
     * так как данный метод возвращает именно Фрукты.
     */
    public Fruit find(String name, int price) {
        Fruit fruit = new Fruit(name, price);
        boolean found = false;
        for (Map.Entry<Fruit, Integer> entry : shelves.entrySet()) {
            if (entry.getKey().equals(fruit)) {
                found = true;
                break;
            }
        }
        return found ? fruit : null;
    }
}
