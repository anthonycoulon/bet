insert into bet.ROLE (ID, ROLE) values (1, 'ROLE_ADMIN');
insert into bet.ROLE (ID, ROLE) values (2, 'ROLE_USER');

INSERT INTO bet.USER (ID, FIRSTNAME, NAME, PASSWORD, USERNAME, SCORE) VALUES (1, 'Anthony', 'Coulon', 'cfd67247b128ee77fb48638ca5095019cf9dc697', 'anthony.coulon@valtech.fr', 25);
INSERT INTO bet.USER (ID, FIRSTNAME, NAME, PASSWORD, USERNAME, SCORE) VALUES (2, 'Fabrice', 'Tavilla', 'c8f7878120e876bb08ce96c4d24535ca3e7a1397', 'fabrice.tavilla@valtech.fr', 15);
INSERT INTO bet.USER (ID, FIRSTNAME, NAME, PASSWORD, USERNAME, SCORE) VALUES (3, 'Antho', 'Coulon', 'd607361608e7d09a0a7d00e989cf325943f312ca', 'admin', 0);
INSERT INTO bet.USER (ID,FIRSTNAME, NAME, PASSWORD, USERNAME, SCORE) VALUES (4, 'Lyazid', 'Selmi', 'c79bb6af4401f0fc763bac4016f9826a223754ed', 'lyazid.selmi@valtech.fr', 20);
INSERT INTO bet.USER (ID,FIRSTNAME, NAME, PASSWORD, USERNAME, SCORE) VALUES (5, 'André', 'Desousa', '59a9316cac72c42005f1462c130887118dc23ebc', 'andre.desousa@valtech.fr', 8);

insert into bet.USER_ROLE (USER_ID, ROLE_ID) values (1, 2);
insert into bet.USER_ROLE (USER_ID, ROLE_ID) values (2, 2);
insert into bet.USER_ROLE (USER_ID, ROLE_ID) values (3, 1);
insert into bet.USER_ROLE (USER_ID, ROLE_ID) values (4, 2);
insert into bet.USER_ROLE (USER_ID, ROLE_ID) values (5, 2);

insert into bet.OPPONENT(id, NAME) values (1, 'France');
insert into bet.OPPONENT(id, NAME) values (2, 'Suisse');
insert into bet.OPPONENT(id, NAME) values (3, 'Bresil');
insert into bet.OPPONENT(id, NAME) values (4, 'Croatie');
insert into bet.OPPONENT(id, NAME) values (5, 'Espagne');
insert into bet.OPPONENT(id, NAME) values (6, 'Pays-bas');


INSERT INTO bet.MATCHS (ID, MATCH_DATE, SCORE, MATCH_OPPONENT1_FK, MATCH_OPPONENT2_FK, MATCH_TIME, QUOTE1, QUOTE2, MATCH_LEVEL)
VALUES (1, '2014-05-30 00:00:00.0', '2-1', 1, 2, '2014-05-30 10:00:00.0', 2, 1, 4);
INSERT INTO bet.MATCHS (ID, MATCH_DATE, SCORE, MATCH_OPPONENT1_FK, MATCH_OPPONENT2_FK, MATCH_TIME, QUOTE1, QUOTE2, MATCH_LEVEL)
VALUES (2, '2014-05-30 00:00:00.0', null, 3, 4, '2014-05-30 20:00:00.0', 1, 0, 0);
INSERT INTO bet.MATCHS (ID, MATCH_DATE, SCORE, MATCH_OPPONENT1_FK, MATCH_OPPONENT2_FK, MATCH_TIME, MATCH_LEVEL)
VALUES (3, '2014-05-31 00:00:00.0', null, 5, 6, '2014-05-31 18:00:00.0', 1);

insert into bet.BET(ID, BET, BET_USER_FK) values(1,'3-0',1);
insert into bet.BET(ID, BET, BET_USER_FK) values(2,'2-1',2);
insert into bet.BET(ID, BET, BET_USER_FK) values(3,'2-1',2);
insert into bet.BET(ID, BET, BET_USER_FK) values(4,'0-1',5);

insert into bet.MATCH_BET(MATCH_ID, BET_ID) values(1,1);
insert into bet.MATCH_BET(MATCH_ID, BET_ID) values(1,3);
insert into bet.MATCH_BET(MATCH_ID, BET_ID) values(1,4);
insert into bet.MATCH_BET(MATCH_ID, BET_ID) values(2,2);
