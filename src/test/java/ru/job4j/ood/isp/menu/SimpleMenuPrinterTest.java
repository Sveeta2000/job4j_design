package ru.job4j.ood.isp.menu;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;

class SimpleMenuPrinterTest {
    public static final ActionDelegate STUB_ACTION = System.out::println;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    private final String nextLine = System.lineSeparator();

    @Test
    public void whenPrintThenReturnSame() {
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Сходить в магазин", STUB_ACTION);
        menu.add(Menu.ROOT, "Покормить собаку", STUB_ACTION);
        menu.add("Сходить в магазин", "Купить продукты", STUB_ACTION);
        menu.add("Купить продукты", "Купить хлеб", STUB_ACTION);
        menu.add("Купить продукты", "Купить молоко", STUB_ACTION);
        System.setOut(new PrintStream(outputStreamCaptor));
        String expected = "--1.Сходить в магазин" + nextLine
                          + "----1.1.Купить продукты" + nextLine
                          + "------1.1.1.Купить хлеб" + nextLine
                          + "------1.1.2.Купить молоко" + nextLine
                          + "--2.Покормить собаку";
        new SimpleMenuPrinter().print(menu);
        System.setOut(standardOut);
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo(expected);
    }
}