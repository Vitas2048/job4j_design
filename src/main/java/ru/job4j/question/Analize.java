package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        Map<Integer, String> prev = new HashMap<>();
        Map<Integer, String> curr = new HashMap<>();
        Info info = new Info(0, 0, 0);
        for (User user : previous) {
            prev.put(user.getId(), user.getName());
        }
        for (User user : current) {
            curr.put(user.getId(), user.getName());
        }
        Set<Integer> prevKeys = prev.keySet();
        Set<Integer> currKeys = curr.keySet();
        info.setChanged((int) currKeys.stream().
                filter(s -> !Objects.equals(prev.get(s), curr.get(s))
                && prev.get(s) != null && curr.get(s) != null).count());
        info.setAdded((int) currKeys.stream().filter(s -> !prevKeys.contains(s)).count());
        info.setDeleted((int) prevKeys.stream().filter(s -> !currKeys.contains(s)).count());
        return info;
    }
}