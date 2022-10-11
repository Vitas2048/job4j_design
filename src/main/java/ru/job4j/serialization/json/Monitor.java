package ru.job4j.serialization.json;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class Monitor {
    private final boolean gamesupport;
    private final int frequency;
    private final String company;
    private final Contact contact;
    private final String[] shops;

    public Monitor(boolean gamesupport, int frequency, String company, Contact contact, String[] shops) {
        this.gamesupport = gamesupport;
        this.frequency = frequency;
        this.company = company;
        this.contact = contact;
        this.shops = shops;
    }

    @Override
    public String toString() {
        return "monitor{"
                + "gamesupprot: " + gamesupport
                + ", frequency: " + frequency
                + ", company: " + company
                + ", contact: " + contact.toString()
                + ", shops: " + Arrays.toString(shops);
    }

    public static void main(String[] args) {
        final Monitor monitor = new Monitor(true, 144, "Asus", new Contact("88005553535"), new String[] {"DNS", "MVIDEO"});
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(monitor));
        final String monitorJson =
                "{"
                + "\"gamesupport\":false,"
                + "\"frequency\":75,"
                + "\"company\":Acer,"
                + "\"contact\":"
                + "{"
                + "\"phone\":\"5553535\""
                + "},"
                + "\"shops\":"
                + "[\"Eldorado\", \"XCOM\"]"
                + "}";
        final Monitor monitor1 = gson.fromJson(monitorJson, Monitor.class);
        System.out.println(monitor1.toString());
    }
}
