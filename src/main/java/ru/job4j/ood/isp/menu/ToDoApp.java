package ru.job4j.ood.isp.menu;

import java.util.Optional;
import java.util.Scanner;

public class ToDoApp {
    private final Menu menu;
    private final Scanner scanner;

    public static final ActionDelegate ACTION = System.out::println;
    public static final int ADD_ELEMENT_TO_ROOT = 1;
    public static final int ADD_ELEMENT_TO_PARENT = 2;
    public static final int CALL_ACTION = 3;
    public static final int PRINT_MENU = 4;
    public static final String MENU = """
                Выберите пункт:
                Введите 1, чтобы добавить пункт меню.
                Введите 2, чтобы добавить подпункт меню.
                Введите 3, чтобы выполнить действие меню.
                Введиту 4, чтобы показать меню.
                Введите любое другое число для выхода.
            """;

    public ToDoApp(Menu menu, Scanner scanner) {
        this.menu = menu;
        this.scanner = scanner;
    }

    public static void main(String[] args) {
        ToDoApp app = new ToDoApp(new SimpleMenu(), new Scanner(System.in));
        MenuPrinter printer = new SimpleMenuPrinter();
        boolean open = true;
        while (open) {
            System.out.println(MENU);
            int choice = Integer.parseInt(app.scanner.nextLine());
            if (ADD_ELEMENT_TO_ROOT == choice) {
                System.out.println("Введите название нового пункта.");
                String point = app.scanner.nextLine();
                app.menu.add(Menu.ROOT, point, ACTION);
            } else if (ADD_ELEMENT_TO_PARENT == choice) {
                System.out.println("Введите название основного пункта.");
                String parent = app.scanner.nextLine();
                System.out.println("Введите название нового подпункта.");
                String point = app.scanner.nextLine();
                app.menu.add(parent, point, ACTION);
            } else if (CALL_ACTION == choice) {
                System.out.println("Введите название пункта меню, которое будет выполнено.");
                String point = app.scanner.nextLine();
                Optional<Menu.MenuItemInfo> itemInfo = app.menu.select(point);
                if (itemInfo.isPresent()) {
                    itemInfo.get().getActionDelegate().delegate();
                } else {
                    System.out.println("Упс. Данный пункт меню не был найден. Попробуйте снова.");
                }
            } else if (PRINT_MENU == choice) {
                printer.print(app.menu);
            } else {
                open = false;
                System.out.println("До свидания!");
            }
        }
    }
}
