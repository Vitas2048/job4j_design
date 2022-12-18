package ru.job4j.ood.isp.menu;

import java.util.Scanner;

public class TODOApp {

    public static final ActionDelegate STUB_ACTION = System.out::println;

    public static final int ADD_ROOT = 1;

    public static final int ADD_CHILD = 2;

    public static final int SHOW = 3;

    public static final int FINISH = 4;

    public static final String MENU = """
            Введите 1, для для добавления в пункт меню.
            Введите 2, для добавления подпункта в пункт меню
            Введите 3, Вывести меню на экран
            Введите 4, Выйти из программы
            """;

    public static final String SELECT = "Введите число";

    public static final String SELECTPARENT = "Введите пункт";

    public static final String SELECTCHILD = "Введите подпункт";

    public static final String WRONG = "Неправильно введены данные";

    public static final String EXIT = "Конец работы";

    private static void start(Menu menu, Scanner scanner1, MenuPrinter print) {
        boolean run = true;
        while (run) {
            System.out.println(MENU);
            System.out.println(SELECT);
            int userChoice = Integer.parseInt(scanner1.nextLine());
            if (ADD_ROOT == userChoice) {
                System.out.println(SELECTPARENT);
                var addParent = scanner1.nextLine();
                menu.add(Menu.ROOT, addParent, STUB_ACTION);
            } else if (ADD_CHILD == userChoice) {
                System.out.println(SELECTPARENT);
                var addParent = scanner1.nextLine();
                System.out.println(SELECTCHILD);
                var addChild = scanner1.nextLine();
                menu.add(addParent, addChild, STUB_ACTION);
            } else if (SHOW == userChoice) {
                print.print(menu);
            } else if (FINISH == userChoice) {
                System.out.println(EXIT);
                run = false;
            }
        }
    }

    public static void main(String[] args) {
        ConsoleMenuPrinter print = new ConsoleMenuPrinter();
        Menu menu = new SimpleMenu();
        Scanner scanner = new Scanner(System.in);
        start(menu, scanner, print);

    }
}
