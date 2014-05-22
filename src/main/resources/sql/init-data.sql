insert into bet.ROLE (ID, ROLE) values (1, 'ADMIN');
insert into bet.ROLE (ID, ROLE) values (2, 'USER');

INSERT INTO bet.USER (ID, FIRSTNAME, NAME, PASSWORD, USERNAME) VALUES (1, 'Anthony', 'Coulon', null, 'anthony.coulon@valtech.fr');
INSERT INTO bet.USER (ID, FIRSTNAME, NAME, PASSWORD, USERNAME) VALUES (2, 'Fabrice', 'Tavilla', null, 'fabrice.tavilla@valtech.fr');

insert into bet.USER_ROLE (USER_ID, ROLE_ID) values (1, 1);
insert into bet.USER_ROLE (USER_ID, ROLE_ID) values (1, 2);
insert into bet.USER_ROLE (USER_ID, ROLE_ID) values (2, 2);