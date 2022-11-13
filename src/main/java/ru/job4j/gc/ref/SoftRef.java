package ru.job4j.gc.ref;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;


public class SoftRef {

    public static String example(int i)  {
        int j = 0;
        SoftReference<String> softR;
        String w = null;
        try (BufferedReader in = new BufferedReader(new FileReader("input.txt"))) {
            for (String s = in.readLine(); s != null; s = in.readLine()) {
                j++;
                if (j == i) {
                    softR = new SoftReference<>(s);
                    w = softR.get();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return w;
    }

    public static void example1() {
        List<String> list = new ArrayList<>();
        WeakReference<String> weakR = new WeakReference<>("Hello");
        for (int i = 0; i < 1000; i++) {
            String s = weakR.get();
            list.add(s);
            System.out.println(list.get(i));
        }
    }
}
