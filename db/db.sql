DROP USER IF EXISTS 'testboard'@'localhost';
DROP DATABASE IF EXISTS test_board;

CREATE DATABASE  test_board DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

USE mysql;

CREATE USER 'testboard'@'localhost' IDENTIFIED BY 'qwerty123';
GRANT ALL PRIVILEGES ON test_board.* TO 'testboard'@'localhost';

CREATE TABLE tb_user (
    uid         INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id          VARCHAR(30) NOT NULL,
    pwd         BINARY(255) NOT NULL,
    name        VARCHAR(30) NOT NULL,
    reg_date    datetime DEFAULT now(),
    wthdr_date  datetime
) ENGINE = InnoDB;

INSERT INTO tb_user(id, pwd, name) VALUES ('admin', SHA2('admin', 256), 'admin');

CREATE TABLE tb_board (
    bid         INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    uid         INT NOT NULL,
    title       VARCHAR(100) NOT NULL,
    content     TEXT NOT NULL,
    deleted     bit(1) DEFAULT 0,
    crtn_date   datetime DEFAULT now(),
    mdfd_date   datetime DEFAULT now(),
    FOREIGN KEY (uid) REFERENCES tb_user(uid) ON UPDATE NO ACTION
) ENGINE = InnoDB;


CREATE TABLE tb_attach (
    aid         INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    bid         INT NOT NULL,
    name        VARCHAR(256) NOT NULL,
    path        VARCHAR(512) NOT NULL,
    type        VARCHAR(256),
    crtn_date   datetime DEFAULT now(),
    FOREIGN KEY (bid) REFERENCES tb_board(bid) ON UPDATE NO ACTION
) ENGINE = InnoDB;