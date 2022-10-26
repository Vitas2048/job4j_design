package ru.job4j.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) throws SQLException, IOException, ClassNotFoundException {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws IOException, ClassNotFoundException, SQLException {
        Properties config = properties;
            String url = config.getProperty("url");
            String login = config.getProperty("login");
            String password = config.getProperty("password");
            Class.forName(config.getProperty("class"));
            connection = DriverManager.getConnection(url, login, password);
        }

    public void createTable(String tableName) throws Exception {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "create table if not exists %s();",
                    tableName
            );
            statement.execute(sql);
        }
    }

    public void dropTable(String tableName) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "drop table %s;",
                    tableName
            );
            statement.execute(sql);
        }
    }

    public void addColumn(String tableName, String columnName, String type) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "alter table %s add column %s %s;",
                    tableName,
                    columnName,
                    type
            );
            statement.execute(sql);
        }
    }

    public void dropColumn(String tableName, String columnName) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "alter table %s drop column %s;",
                    tableName,
                    columnName
            );
            statement.execute(sql);
        }
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "alter table %s rename column %s to %s;",
                    tableName,
                    columnName,
                    newColumnName
            );
            statement.execute(sql);
        }
    }


    public String getTableScheme(String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", tableName, "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {
        Properties config = new Properties();
        try (InputStream in = TableEditor.class.getClassLoader().getResourceAsStream("./app.properties")) {
            config.load(in);
        }
        TableEditor tableEditor = new TableEditor(config);
        tableEditor.createTable("Yamakasi");
        System.out.println(tableEditor.getTableScheme("Yamakasi"));
        tableEditor.addColumn("Yamakasi", "speed", "text");
        System.out.println(tableEditor.getTableScheme("Yamakasi"));
        tableEditor.addColumn("Yamakasi", "jump", "text");
        System.out.println(tableEditor.getTableScheme("Yamakasi"));
        tableEditor.addColumn("Yamakasi", "sex", "text");
        System.out.println(tableEditor.getTableScheme("Yamakasi"));
        tableEditor.renameColumn("Yamakasi", "jump", "endurance");
        System.out.println(tableEditor.getTableScheme("Yamakasi"));
        tableEditor.dropColumn("Yamakasi", "sex");
        System.out.println(tableEditor.getTableScheme("Yamakasi"));
        tableEditor.dropTable("Yamakasi");
        System.out.println(tableEditor.getTableScheme("Yamakasi"));
    }
}