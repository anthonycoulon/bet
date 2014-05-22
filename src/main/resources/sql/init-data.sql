insert into bet.ROLE (ID, ROLE) values (1, 'ROLE_ADMIN');
insert into bet.ROLE (ID, ROLE) values (2, 'ROLE_USER');

INSERT INTO bet.USER (ID, FIRSTNAME, NAME, PASSWORD, USERNAME) VALUES (1, 'Anthony', 'Coulon', 'antho', 'anthony.coulon@valtech.fr');
INSERT INTO bet.USER (ID, FIRSTNAME, NAME, PASSWORD, USERNAME) VALUES (2, 'Fabrice', 'Tavilla', 'fab', 'fabrice.tavilla@valtech.fr');
INSERT INTO bet.USER (ID, FIRSTNAME, NAME, PASSWORD, USERNAME) VALUES (3, 'Antho', 'Coulon', 'admin', 'admin');

insert into bet.USER_ROLE (USER_ID, ROLE_ID) values (1, 2);
insert into bet.USER_ROLE (USER_ID, ROLE_ID) values (2, 2);
insert into bet.USER_ROLE (USER_ID, ROLE_ID) values (3, 1);