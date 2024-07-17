CREATE DATABASE belajar_spring_restful_api;

USE belajar_spring_restful_api;

CREATE TABLE users (
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    token VARCHAR(255) ,
    token_expired_at BIGINT,
    PRIMARY KEY (username),
    UNIQUE(token)
) ENGINE InnoDB;

CREATE TABLE contacts(
    id VARCHAR(255) NOT NULL ,
    username VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NOT NULL ,
    last_name VARCHAR(255) ,
    phone VARCHAR(255) ,
    email VARCHAR(255) ,
    PRIMARY KEY(id),
    FOREIGN KEY fk_users_contacts(username) REFERENCES users(username)
) ENGINE InnoDB;

CREATE TABLE addresses(
    id VARCHAR(255) NOT NULL ,
    contact_id VARCHAR(255) NOT NULL,
    street VARCHAR(355) ,
    city VARCHAR(255) ,
    province VARCHAR(255) ,
    country VARCHAR(255) NOT NULL,
    postalCode VARCHAR(10),
    PRIMARY KEY(id),
    FOREIGN KEY fk_addresses_contacts(contact_id) REFERENCES contacts(id)
) ENGINE InnoDB;