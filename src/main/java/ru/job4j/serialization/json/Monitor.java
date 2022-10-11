package ru.job4j.serialization.json;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Monitor {
    public boolean isGamesupport() {
        return gamesupport;
    }

    public int getFrequency() {
        return frequency;
    }

    public String getCompany() {
        return company;
    }

    public Contact getContact() {
        return contact;
    }

    public String[] getShops() {
        return shops;
    }

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
        JSONObject jsonContact = new JSONObject("{\"phone\":\"88005553535\"}");
        List<String> list = new ArrayList<>();
        list.add("DNS");
        list.add("MVIDEO");
        JSONArray jsonshops = new JSONArray(list);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("gamesupport", monitor.isGamesupport());
        jsonObject.put("frequency", monitor.getFrequency());
        jsonObject.put("company", monitor.getCompany());
        jsonObject.put("contact", jsonContact);
        jsonObject.put("shops", jsonshops);
        System.out.println(jsonObject);
        System.out.println(new JSONObject(monitor));
    }
}
