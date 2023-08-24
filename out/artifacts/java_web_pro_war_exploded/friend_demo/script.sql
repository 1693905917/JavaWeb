CREATE DATABASE `user`;
USE `user`;

CREATE TABLE friend_user(
id BIGINT PRIMARY KEY AUTO_INCREMENT,
username VARCHAR(20) UNIQUE,
`password` VARCHAR(10),
`name` VARCHAR(20),
age INT(3),
gender CHAR(1),
phone VARCHAR(20)
);
DROP TABLE friend_user;

CREATE TABLE friend_pic(
id BIGINT PRIMARY KEY AUTO_INCREMENT,
picName VARCHAR(100),
userId BIGINT
);

INSERT INTO friend_user
VALUES(2,'薛之谦','6666','邓紫棋',28,'m','9600');
INSERT INTO friend_user
VALUES(3,'钢铁侠','9999','蜘蛛侠',218,'m','7777');
INSERT INTO friend_user
VALUES(4,'尚迪','7799','阿斯顿侠',28,'m','7887');
SELECT * FROM friend_user;
INSERT INTO friend_user
VALUES(1,'黄志鹏,'6623','孔佐佑',20,'m','9230');

select `username` from `friend_user` where `username`='黄志鹏';
delete from friend_user where id=1;



