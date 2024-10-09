DROP TABLE IF EXISTS app_users;
DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS categories;

CREATE TABLE app_users (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password_hash VARCHAR(150) NOT NULL,
    user_role VARCHAR(50) NOT NULL);

INSERT INTO app_users (username, password_hash, user_role) VALUES 
    ('user1', '$2a$10$PaosWINUqsUNOQcQNSBHKu2FuusbCwq9MsrfiHYNwTppPK8P4ra.6', 'USER'),
    ('user2', '$2a$10$864A0p89X3fKI41facTLOO3OVQFRlCsoGCpnzJQiPS2YM3H.r4gmS', 'USER'),
    ('admin', '$2a$10$k1FXWfeZq0aBdNQaVVuLueFXuIr9picFRFXrjq1G4blXUSqZOsWn6', 'ADMIN');

CREATE TABLE categories (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    category_name VARCHAR(50) NOT NULL);

INSERT INTO categories (category_name) VALUES 
    ('Crime'),
    ('Cooking'),
    ('Self-help');

CREATE TABLE books (
    id BIGSERIAL NOT NULL PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    author VARCHAR(50) NOT NULL,
    isbn VARCHAR(50) NOT NULL,
    publication_year BIGINT NOT NULL,
    price FLOAT NOT NULL,
    category_id BIGINT,
    FOREIGN KEY (category_id) REFERENCES categories(id));

INSERT INTO books (title, author, isbn, publication_year, price, category_id) VALUES 
    ('Akun seikkailut', 'Aku Ankka', 'A1234B5678', 2008, 8.99, 1),
    ('Iineksen iltapäiväkahvit', 'Iines Ankka', 'A4321B8765', 2023, 12.99, 2),
    ('Roopen säästövinkit', 'Roope Ankka', 'A3412B7856', 2019, 29.99, 3),
    ('Ole elämäsi keksijä', 'Pelle Peloton', 'B7482N2934', 2015, 18.99, 3);

SELECT * FROM app_users;
SELECT * FROM categories;
SELECT * FROM books;