package ru.job4j.ood.isp.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


class ConsoleMenuPrinterTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream(32);

    public static final ActionDelegate STUB_ACTION = System.out::println;

    @Test
    public void whenAddAndPrintThenPrint() {
        System.setOut(new PrintStream(output));
        var print = new ConsoleMenuPrinter();
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Сходить в магазин", STUB_ACTION);
        menu.add(Menu.ROOT, "Покормить собаку", STUB_ACTION);
        menu.add(Menu.ROOT, "Убраться дома", STUB_ACTION);
        menu.add("Убраться дома", "Пропылесосить", STUB_ACTION);
        menu.add("Убраться дома", "Помыть полы", STUB_ACTION);
        menu.add("Сходить в магазин", "Купить продукты", STUB_ACTION);
        menu.add("Купить продукты", "Купить хлеб", STUB_ACTION);
        menu.add("Купить продукты", "Купить молоко", STUB_ACTION);
        String expected = """
                1.Сходить в магазин
                ----1.1.Купить продукты
                --------1.1.1.Купить хлеб
                --------1.1.2.Купить молоко
                2.Покормить собаку
                3.Убраться дома
                ----3.1.Пропылесосить
                ----3.2.Помыть полы""".indent(0);
        print.print(menu);
        Assertions.assertEquals(expected, output.toString());
        System.setOut(null);
    }
}