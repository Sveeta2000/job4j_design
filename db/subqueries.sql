CREATE TABLE customers(
    id serial primary key,
    first_name text,
    last_name text,
    age int,
    country text
);

INSERT INTO customers(first_name, last_name, age, country) VALUES ('Alex', 'Fox', 22, 'Canada'),
('Luigi', 'Monti', 32, 'Italy'), ('Leon', 'Schmidt', 22, 'Germany'),
('Anna', 'Ivanova', 25, 'Russia'), ('Aysel', 'Kaplan', 29, 'Turkey');

SELECT first_name, last_name, age, country
FROM customers
WHERE age = (SELECT MIN(age) FROM customers);

CREATE TABLE customer_order(
    id serial primary key,
    amount int,
    customer_id int references customers(id)
);

INSERT INTO customer_order(amount, customer_id) VALUES (3, 1), (2, 2), (10, 5);

SELECT first_name, last_name, age, country
FROM customers
WHERE customers.id NOT IN (SELECT customer_id FROM customer_order);