CREATE TABLE client (
    entity_id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100)
);

CREATE TABLE product (
    entity_id INTEGER PRIMARY KEY AUTO_INCREMENT,
    description VARCHAR(100),
    unit_price NUMERIC(20,2)
);

CREATE TABLE order (
    entity_id INTEGER PRIMARY KEY AUTO_INCREMENT,
    client_id INTEGER REFERENCES CLIENT (ID),
    order_date TIMESTAMP,
    order_total NUMERIC(20,2)
);

CREATE TABLE order_item (
    entity_id INTEGER PRIMARY KEY AUTO_INCREMENT,
    order_id INTEGER REFERENCES ORDER (id),
    item_id INTEGER REFERENCES product (id),
    item_quantity INTEGER
);