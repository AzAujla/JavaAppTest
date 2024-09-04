package app;

import java.sql.Statement;
import java.sql.SQLException;

public class Migration {
    public void migrate() {
        try (Statement st = (new Database()).getConn().createStatement()) {
            String[] tables = {
                    "CREATE TABLE IF NOT EXISTS categories(id INTEGER UNIQUE PRIMARY KEY AUTOINCREMENT, name VARCHAR(255));",
                    "CREATE TABLE IF NOT EXISTS items(id INTEGER UNIQUE PRIMARY KEY AUTOINCREMENT, name VARCHAR(255), category_id INTEGER);",
                    "CREATE TABLE IF NOT EXISTS customers(id INTEGER UNIQUE PRIMARY KEY AUTOINCREMENT, name VARCHAR(255), phno BIGINT);",
                    "CREATE TABLE IF NOT EXISTS orders(id INTEGER UNIQUE PRIMARY KEY AUTOINCREMENT, customer_id INTEGER, ordered_at TIMESTAMP);",
                    "CREATE TABLE IF NOT EXISTS order_items(id INTEGER UNIQUE PRIMARY KEY AUTOINCREMENT, order_id INTEGER, item_id INTEGER, quantity INTEGER);"
            };

            boolean result = true;

            for (int i = 0; i < tables.length; i++) {
                try {
                    st.execute(tables[i]);
                } catch (SQLException e) {
                    result = false;
                    System.out.println(e.getMessage());
                }
            }

            if (result) {
                System.out.println("Migrated successfully");
            } else {
                System.out.println("Migration unsuccessful");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
