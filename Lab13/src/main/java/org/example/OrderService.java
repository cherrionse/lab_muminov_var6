package org.example;

import java.sql.*;

public class OrderService {
    private String dbUrl;
    private String user;
    private String password;

    // Конструктор, принимающий тип базы данных (postgres или h2)
    public OrderService(String dbType) {
        if ("postgres".equalsIgnoreCase(dbType)) {
            this.dbUrl = "jdbc:postgresql://localhost:5432/postgres";
            this.user = "postgres";
            this.password = "123";
        } else if ("h2".equalsIgnoreCase(dbType)) {
            this.dbUrl = "jdbc:h2:tcp://localhost/~/shop;AUTO_SERVER=TRUE";
            this.user = "sa";
            this.password = "";
        } else {
            throw new IllegalArgumentException("Неизвестный тип базы данных: " + dbType);
        }
    }

    public void addProduct(String name, String description, double price) {
        String query = "INSERT INTO product (name, description, price) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(dbUrl, user, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, description);
            stmt.setDouble(3, price);
            stmt.executeUpdate();
            System.out.println("Продукт добавлен успешно.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addOrder(Timestamp orderDate) {
        String query = "INSERT INTO orders (order_date) VALUES (?)";
        try (Connection conn = DriverManager.getConnection(dbUrl, user, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setTimestamp(1, orderDate);
            stmt.executeUpdate();
            System.out.println("Заказ добавлен успешно.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void linkOrderWithProduct(int orderId, int productId, int quantity) {
        String query = "INSERT INTO orderproduct (order_id, product_id, quantity) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(dbUrl, user, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, orderId);
            stmt.setInt(2, productId);
            stmt.setInt(3, quantity);
            stmt.executeUpdate();
            System.out.println("Связь между заказом и продуктом успешно создана.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getOrderDetails(int orderId) {
        String query = """
            SELECT o.id AS order_id, o.order_date, p.name AS product_name, op.quantity, p.price
            FROM orders o
            JOIN orderproduct op ON o.id = op.order_id
            JOIN product p ON op.product_id = p.id
            WHERE o.id = ?
        """;

        try (Connection conn = DriverManager.getConnection(dbUrl, user, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, orderId);

            try (ResultSet rs = stmt.executeQuery()) {
                System.out.println("Детали заказа с ID: " + orderId);
                System.out.println("----------------------------------------------------");
                System.out.printf("%-10s%-20s%-10s%-10s%-10s%n", "Order ID", "Product Name", "Quantity", "Price", "Order Date");
                System.out.println("----------------------------------------------------");

                boolean found = false;
                while (rs.next()) {
                    found = true;
                    String orderDate = rs.getTimestamp("order_date").toString();
                    String productName = rs.getString("product_name");
                    int quantity = rs.getInt("quantity");
                    double price = rs.getDouble("price");

                    System.out.printf("%-10d%-20s%-10d%-10.2f%-10s%n", orderId, productName, quantity, price, orderDate);
                }

                if (!found) {
                    System.out.println("Заказ с указанным ID не найден.");
                }

            }
        } catch (SQLException e) {
            System.out.println("Ошибка при получении данных о заказе: " + e.getMessage());
        }
    }
}
