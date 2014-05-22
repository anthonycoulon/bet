CREATE DATABASE `bet` CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE USER 'bet-user'@'localhost'; GRANT ALL PRIVILEGES ON *.* TO 'bet-user'@'localhost';

grant all privileges on `bet`.* to 'bet-user'@'localhost' identified by 'dbpwd';

grant SELECT, INSERT, UPDATE, DELETE ON `bet`.* to 'bet-user'@'localhost' identified by 'dbpwd';

flush privileges;