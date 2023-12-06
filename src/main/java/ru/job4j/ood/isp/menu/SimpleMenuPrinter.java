package ru.job4j.ood.isp.menu;

public class SimpleMenuPrinter implements MenuPrinter {
    @Override
    public void print(Menu menu) {
        for (Menu.MenuItemInfo info : menu) {
            System.out.println("-".repeat(info.getNumber().length()) + info.getNumber() + info.getName());
        }
    }
}
