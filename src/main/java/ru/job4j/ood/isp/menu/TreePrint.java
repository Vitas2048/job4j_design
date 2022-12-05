package ru.job4j.ood.isp.menu;

import java.util.regex.Pattern;

public class TreePrint implements MenuPrinter {

    @Override
    public void print(Menu menu) {
        var iterator = menu.iterator();
        while (iterator.hasNext()) {
            var next = iterator.next();
            var s = new StringBuilder();
            var p = Pattern.compile("\\.");
            var m = p.matcher(next.getNumber());
            while (m.find()) {
                s.append("----");
            }
            System.out.printf(s + next.getNumber() + next.getName() + "\n");
        }
    }
}
