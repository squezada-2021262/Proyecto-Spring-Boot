DROP DATABASE IF EXISTS DBProyectoSpringBootEjemplo;
CREATE DATABASE DBProyectoSpringBootEjemplo;
USE DBProyectoSpringBootEjemplo;
 
CREATE TABLE users (
    id INT not null AUTO_INCREMENT,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(100) unique,
    primary key pk_id(id)
);
select * from users;

INSERT INTO users (first_name, last_name, email)
VALUES ('Jane', 'Doe', 'jane.doe@example.com');

INSERT INTO users (first_name, last_name, email)
VALUES ('John', 'Smith', 'john.smith@example.com');

INSERT INTO users (first_name, last_name, email)
VALUES ('Peter', 'Jones', 'peter.jones@example.com');