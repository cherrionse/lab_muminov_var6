package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection getConnection() {
        Connection conn = null;
        try {

            Class.forName("org.postgresql.Driver");


            String url = "jdbc:postgresql://localhost:5432/postgres";
            String user = "postgres";
            String password = "123";
            // Устанавливаем соединение
            conn = DriverManager.getConnection(url, user, password);

            // Проверяем успешность подключения
            if (conn == null) {
                System.out.println("Ошибка подключения к базе данных");
            } else {
                System.out.println("Подключение успешно установлено");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}