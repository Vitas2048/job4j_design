package ru.job4j;

import ru.job4j.io.Config;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Settings {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        Config config = new Config("./src/main/resources/app.properties");
        config.load();
        Class.forName(config.value("class"));
        String url = config.value("url");
        String login = config.value("login");
        String password = config.value("password");
        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        }
    }
}