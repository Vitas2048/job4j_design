package ru.job4j.ood.isp.menu;


import static java.lang.System.lineSeparator;

public class TreePrint implements MenuPrinter {

    private static final String DELIMITER = "----";

    @Override
    public void print(Menu menu) {
        for (Menu.MenuItemInfo item : menu) {
            int count = item.getNumber().split("\\.").length - 1;
            System.out.print(DELIMITER.repeat(count) + item.getNumber() + item.getName() + lineSeparator());
        }
    }
}
