package ru.job4j.ood.isp.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class SimpleMenuTest {

    public static final ActionDelegate STUB_ACTION = System.out::println;

    @Test
    public void whenAddThenReturnSame() {
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Сходить в магазин", STUB_ACTION);
        menu.add(Menu.ROOT, "Покормить собаку", STUB_ACTION);
        menu.add("Сходить в магазин", "Купить продукты", STUB_ACTION);
        menu.add("Купить продукты", "Купить хлеб", STUB_ACTION);
        menu.add("Купить продукты", "Купить молоко", STUB_ACTION);
        assertThat(new Menu.MenuItemInfo("Сходить в магазин",
                List.of("Купить продукты"), STUB_ACTION, "1."))
                .isEqualTo(menu.select("Сходить в магазин").get());
        assertThat(new Menu.MenuItemInfo(
                "Купить продукты",
                List.of("Купить хлеб", "Купить молоко"), STUB_ACTION, "1.1."))
                .isEqualTo(menu.select("Купить продукты").get());
        assertThat(new Menu.MenuItemInfo(
                "Покормить собаку", List.of(), STUB_ACTION, "2."))
                .isEqualTo(menu.select("Покормить собаку").get());
    }




    @Test
    public void whenAddEqualsSelect() {
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Spider man", STUB_ACTION);
        menu.add("Spider man", "Spider", STUB_ACTION);
        menu.add("Spider man", "Man", STUB_ACTION);
        menu.add(Menu.ROOT, "Iron man", STUB_ACTION);
        menu.add("Iron man", "Iron", STUB_ACTION);
        menu.add("Iron man", "Man2", STUB_ACTION);
        menu.add(Menu.ROOT, "Batman", STUB_ACTION);
        menu.add("Batman", "Bat", STUB_ACTION);
        menu.add("Batman", "Man1", STUB_ACTION);
        assertThat(new Menu.MenuItemInfo("Spider man",
                List.of("Spider", "Man"), STUB_ACTION, "1."))
                .isEqualTo(menu.select("Spider man").get());
        assertThat(new Menu.MenuItemInfo("Batman",
                List.of("Bat", "Man1"), STUB_ACTION, "3."))
                .isEqualTo(menu.select("Batman").get());
        assertThat(new Menu.MenuItemInfo("Iron man",
                List.of("Iron", "Man2"), STUB_ACTION, "2."))
                .isEqualTo(menu.select("Iron man").get());
    }
}