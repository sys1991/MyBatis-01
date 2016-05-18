SHOW DATABASES;
DROP DATABASE IF EXISTS mybatis;
CREATE DATABASE mybatis;

USE mybatis;

DROP TABLE IF EXISTS mybatis.Admin;
CREATE TABLE mybatis.Admin (
  id       INT(11) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  email    VARCHAR(255),
  username VARCHAR(255),
  password VARCHAR(255),
  role     CHAR(1) COMMENT 'a-Admin s-system t-teacher'

);

INSERT INTO mybatis.Admin
VALUES (NULL, 'system@qq.com', 'system', '13do3DeGj6b8Nxf0l3+J/ER05/yQzbHHPkaIhb4m01f+p0nj14OrJEIts4K2qZ3m', 's');

SELECT *
FROM mybatis.Admin;

-- table student
DROP TABLE IF EXISTS mybatis.student;
CREATE TABLE mybatis.student (
  id         INT(11) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  email      VARCHAR(255) UNIQUE,
  username   VARCHAR(255),
  password   VARCHAR(255),
  photo      VARCHAR(255),
  last_ip    VARCHAR(255),
  last_login DATETIME,
  class_id   INT(11) UNSIGNED
);

DROP TABLE IF EXISTS mybatis.class;
CREATE TABLE mybatis.class (
  id          INT(11) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  name        VARCHAR(255),
  schedule    VARCHAR(255),
  start_date  DATETIME,
  finish_date DATETIME
);

ALTER TABLE mybatis.student
ADD CONSTRAINT
  fk_student_class_id
FOREIGN KEY (class_id)
REFERENCES mybatis.class (id);

SELECT *
FROM mybatis.Admin;

SELECT *
FROM mybatis.student;

SELECT *
FROM mybatis.class;



