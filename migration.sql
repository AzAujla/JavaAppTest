CREATE TABLE
    IF NOT EXISTS categories (
        id INTEGER UNIQUE PRIMARY KEY AUTOINCREMENT,
        name VARCHAR(255)
    );

CREATE TABLE
    IF NOT EXISTS items (
        id INTEGER UNIQUE PRIMARY KEY AUTOINCREMENT,
        name VARCHAR(255),
        category_id INTEGER
    );

CREATE TABLE
    IF NOT EXISTS customers (
        id INTEGER UNIQUE PRIMARY KEY AUTOINCREMENT,
        name VARCHAR(255),
        phno BIGINT
    );

CREATE TABLE
    IF NOT EXISTS orders (
        id INTEGER UNIQUE PRIMARY KEY AUTOINCREMENT,
        customer_id INTEGER,
        ordered_at TIMESTAMP
    );

CREATE TABLE
    IF NOT EXISTS order_items (
        id INTEGER UNIQUE PRIMARY KEY AUTOINCREMENT,
        order_id INTEGER,
        item_id INTEGER,
        quantity INTEGER
    );