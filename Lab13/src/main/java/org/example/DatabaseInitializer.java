package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {

    private String dbUrl;
    private String user;
    private String password;

    // Конструктор для выбора базы данных
    public DatabaseInitializer(String dbType) {
        if ("postgres".equalsIgnoreCase(dbType)) {
            this.dbUrl = "jdbc:postgresql://localhost:5432/postgres";
            this.user = "postgres";
            this.password = "123";
        } else if ("h2".equalsIgnoreCase(dbType)) {
            this.dbUrl = "jdbc:h2:tcp://localhost/~/shop;AUTO_SERVER=TRUE";
            this.user = "sa";
            this.password = "";
        } else {
            throw new IllegalArgumentException("Unsupported database type: " + dbType);
        }
    }

    // Метод для создания схемы и таблиц
    public void initializeSchemaAndTables() {
        String createTablesQuery = """
            CREATE TABLE IF NOT EXISTS orders (
                id SERIAL PRIMARY KEY,
                order_date TIMESTAMP NOT NULL
            );

            CREATE TABLE IF NOT EXISTS product (
                id SERIAL PRIMARY KEY,
                name VARCHAR(255) NOT NULL,
                description TEXT,
                price DECIMAL(10, 2) NOT NULL
            );

            CREATE TABLE IF NOT EXISTS orderproduct (
                order_id INT NOT NULL,
                product_id INT NOT NULL,
                quantity INT NOT NULL,
                PRIMARY KEY (order_id, product_id),
                CONSTRAINT fk_order FOREIGN KEY (order_id) REFERENCES orders (id) ON DELETE CASCADE,
                CONSTRAINT fk_product FOREIGN KEY (product_id) REFERENCES product (id) ON DELETE CASCADE
            );
        """;

        try (Connection conn = DriverManager.getConnection(dbUrl, user, password);
             Statement stmt = conn.createStatement()) {
            stmt.execute(createTablesQuery);
            System.out.println("Схема и таблицы успешно созданы в базе данных.");
        } catch (SQLException e) {
            System.err.println("Ошибка при создании схемы и таблиц:");
            e.printStackTrace();
        }
    }

    // Метод для вставки тестовых данных
    public void insertSampleData() {
        String insertDataQuery = """
            INSERT INTO product (name, description, price) 
            VALUES 
            ('Product 1', 'Description of Product 1', 19.99),
            ('Product 2', 'Description of Product 2', 29.99),
            ('Product 3', 'Description of Product 3', 39.99);

            INSERT INTO orders (order_date) 
            VALUES 
            ('2024-12-01 10:00:00'),
            ('2024-12-02 14:30:00'),
            ('2024-12-03 16:45:00');

            INSERT INTO orderproduct (order_id, product_id, quantity) 
            VALUES 
            (1, 1, 2),  -- Order 1 with Product 1, quantity 2
            (1, 2, 1),  -- Order 1 with Product 2, quantity 1
            (2, 3, 5),  -- Order 2 with Product 3, quantity 5
            (3, 1, 3);  -- Order 3 with Product 1, quantity 3
        """;

        try (Connection conn = DriverManager.getConnection(dbUrl, user, password);
             Statement stmt = conn.createStatement()) {
            stmt.execute(insertDataQuery);
            System.out.println("Тестовые данные успешно добавлены в таблицы.");
        } catch (SQLException e) {
            System.err.println("Ошибка при добавлении тестовых данных:");
            e.printStackTrace();
        }
    }

    // Метод для получения соединения с БД
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, user, password);
    }
}
