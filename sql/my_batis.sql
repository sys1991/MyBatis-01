SHOW DATABASES ;
DROP DATABASE IF EXISTS mybatis;
CREATE DATABASE mybatis;

USE mybatis;

DROP TABLE IF EXISTS mybatis.user;
CREATE TABLE mybatis.user(
  id INT(11) UNSIGNED AUTO_INCREMENT PRIMARY KEY ,
  username VARCHAR(255),
  password VARCHAR(255)
);
SELECT *
FROM mybatis.user;

-- table student
DROP TABLE IF EXISTS mybatis.student;
CREATE TABLE mybatis.student (
  id         INT(11) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  email      VARCHAR(255) UNIQUE,
  username   VARCHAR(255),
  password   VARCHAR(255),
  last_ip    VARCHAR(255),
  last_login DATETIME
);

SELECT *
FROM mybatis.student;





