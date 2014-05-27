insert into bet.ROLE (ID, ROLE) values (1, 'ROLE_ADMIN');
insert into bet.ROLE (ID, ROLE) values (2, 'ROLE_USER');

INSERT INTO bet.USER (ID, FIRSTNAME, NAME, PASSWORD, USERNAME) VALUES (1, 'Anthony', 'Coulon', 'antho', 'anthony.coulon@valtech.fr');
INSERT INTO bet.USER (ID, FIRSTNAME, NAME, PASSWORD, USERNAME) VALUES (2, 'Fabrice', 'Tavilla', 'fab', 'fabrice.tavilla@valtech.fr');
INSERT INTO bet.USER (ID, FIRSTNAME, NAME, PASSWORD, USERNAME) VALUES (3, 'Antho', 'Coulon', 'admin', 'admin');

insert into bet.USER_ROLE (USER_ID, ROLE_ID) values (1, 2);
insert into bet.USER_ROLE (USER_ID, ROLE_ID) values (2, 2);
insert into bet.USER_ROLE (USER_ID, ROLE_ID) values (3, 1);

insert into bet.OPPONENT(id, NAME) values (1, 'France');
insert into bet.OPPONENT(id, NAME) values (2, 'Suisse');
insert into bet.OPPONENT(id, NAME) values (3, 'Bresil');
insert into bet.OPPONENT(id, NAME) values (4, 'Croatie');
insert into bet.OPPONENT(id, NAME) values (5, 'Espagne');
insert into bet.OPPONENT(id, NAME) values (6, 'Pays-bas');


INSERT INTO bet.MATCHS (ID, MATCH_DATE, SCORE, MATCH_OPPONENT1_FK, MATCH_OPPONENT2_FK, MATCH_TIME)
VALUES (1, '2014-05-27 00:00:00.0', '2-1', 1, 2, '2014-05-27 10:00:00.0');
INSERT INTO bet.MATCHS (ID, MATCH_DATE, SCORE, MATCH_OPPONENT1_FK, MATCH_OPPONENT2_FK, MATCH_TIME)
VALUES (2, '2014-05-27 00:00:00.0', null, 3, 4, '2014-05-27 20:00:00.0');
INSERT INTO bet.MATCHS (ID, MATCH_DATE, SCORE, MATCH_OPPONENT1_FK, MATCH_OPPONENT2_FK, MATCH_TIME)
VALUES (3, '2014-05-28 00:00:00.0', null, 5, 6, '2014-05-28 18:00:00.0');

insert into bet.BET(ID, BET, BET_USER_FK) values(1,'3-0',1);
insert into bet.BET(ID, BET, BET_USER_FK) values(2,'2-1',2);

insert into bet.MATCH_BET(MATCH_ID, BET_ID) values(1,1);
insert into bet.MATCH_BET(MATCH_ID, BET_ID) values(2,2);