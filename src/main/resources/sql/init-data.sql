
INSERT INTO bet.OPPONENT(ID,NAME,FLAG,GR, RANK) VALUES(1,'Suisse','sui','A',0);
INSERT INTO bet.OPPONENT(ID,NAME,FLAG,GR, RANK) VALUES(2,'Albanie','alb','A',0);
INSERT INTO bet.OPPONENT(ID,NAME,FLAG,GR, RANK) VALUES(3,'France','fra','A',0);
INSERT INTO bet.OPPONENT(ID,NAME,FLAG,GR, RANK) VALUES(4,'Roumanie','rou','A',0);

INSERT INTO bet.OPPONENT(ID,NAME,FLAG,GR, RANK) VALUES(5,'Galles','gal','B',0);
INSERT INTO bet.OPPONENT(ID,NAME,FLAG,GR, RANK) VALUES(6,'Russie','rus','B',0);
INSERT INTO bet.OPPONENT(ID,NAME,FLAG,GR, RANK) VALUES(7,'Angleterre','ang','B',0);
INSERT INTO bet.OPPONENT(ID,NAME,FLAG,GR, RANK) VALUES(8,'Slovaquie','slo','B',0);

INSERT INTO bet.OPPONENT(ID,NAME,FLAG,GR, RANK) VALUES(9,'Allemagne','all','C',0);
INSERT INTO bet.OPPONENT(ID,NAME,FLAG,GR, RANK) VALUES(10,'Irlande du Nord','iln','C',0);
INSERT INTO bet.OPPONENT(ID,NAME,FLAG,GR, RANK) VALUES(11,'Ukraine','ukr','C',0);
INSERT INTO bet.OPPONENT(ID,NAME,FLAG,GR, RANK) VALUES(12,'Pologne','pol','C',0);

INSERT INTO bet.OPPONENT(ID,NAME,FLAG,GR, RANK) VALUES(13,'Turquie','tur','D',0);
INSERT INTO bet.OPPONENT(ID,NAME,FLAG,GR, RANK) VALUES(14,'Espagne','esp','D',0);
INSERT INTO bet.OPPONENT(ID,NAME,FLAG,GR, RANK) VALUES(15,'Croatie','cro','D',0);
INSERT INTO bet.OPPONENT(ID,NAME,FLAG,GR, RANK) VALUES(16,'Rep. Tchèque','rtc','D',0);

INSERT INTO bet.OPPONENT(ID,NAME,FLAG,GR, RANK) VALUES(17,'Italie','ita','E',0);
INSERT INTO bet.OPPONENT(ID,NAME,FLAG,GR, RANK) VALUES(18,'Suède','sue','E',0);
INSERT INTO bet.OPPONENT(ID,NAME,FLAG,GR, RANK) VALUES(19,'Irlande','irl','E',0);
INSERT INTO bet.OPPONENT(ID,NAME,FLAG,GR, RANK) VALUES(20,'Belgique','bel','E',0);

INSERT INTO bet.OPPONENT(ID,NAME,FLAG,GR, RANK) VALUES(21,'Islande','isl','F',0);
INSERT INTO bet.OPPONENT(ID,NAME,FLAG,GR, RANK) VALUES(22,'Autriche','aut','F',0);
INSERT INTO bet.OPPONENT(ID,NAME,FLAG,GR, RANK) VALUES(23,'Portugal','por','F',0);
INSERT INTO bet.OPPONENT(ID,NAME,FLAG,GR, RANK) VALUES(24,'Hongrie','hon','F',0);



INSERT INTO bet.MATCHS (ID, MATCH_DATE, SCORE, MATCH_OPPONENT1_FK, MATCH_OPPONENT2_FK, MATCH_TIME,MATCH_LEVEL, MATCH_STADIUM_FK) VALUES (1, '2016-06-10', null, 3, 4, '2016-06-10 21:00:00', 0,null);

INSERT INTO bet.MATCHS (ID, MATCH_DATE, SCORE, MATCH_OPPONENT1_FK, MATCH_OPPONENT2_FK, MATCH_TIME,MATCH_LEVEL, MATCH_STADIUM_FK) VALUES (2, '2016-06-11', null, 2, 1, '2016-06-11 15:00:00', 0,null);
INSERT INTO bet.MATCHS (ID, MATCH_DATE, SCORE, MATCH_OPPONENT1_FK, MATCH_OPPONENT2_FK, MATCH_TIME,MATCH_LEVEL, MATCH_STADIUM_FK) VALUES (3, '2016-06-11', null, 5, 8, '2016-06-11 18:00:00', 1,null);
INSERT INTO bet.MATCHS (ID, MATCH_DATE, SCORE, MATCH_OPPONENT1_FK, MATCH_OPPONENT2_FK, MATCH_TIME,MATCH_LEVEL, MATCH_STADIUM_FK) VALUES (4, '2016-06-11', null, 7, 6, '2016-06-11 21:00:00', 1,null);

INSERT INTO bet.MATCHS (ID, MATCH_DATE, SCORE, MATCH_OPPONENT1_FK, MATCH_OPPONENT2_FK, MATCH_TIME,MATCH_LEVEL, MATCH_STADIUM_FK) VALUES (5, '2016-06-12', null, 13, 15, '2016-06-12 15:00:00', 3,null);
INSERT INTO bet.MATCHS (ID, MATCH_DATE, SCORE, MATCH_OPPONENT1_FK, MATCH_OPPONENT2_FK, MATCH_TIME,MATCH_LEVEL, MATCH_STADIUM_FK) VALUES (6, '2016-06-12', null, 12, 10, '2016-06-12 18:00:00', 2,null);
INSERT INTO bet.MATCHS (ID, MATCH_DATE, SCORE, MATCH_OPPONENT1_FK, MATCH_OPPONENT2_FK, MATCH_TIME,MATCH_LEVEL, MATCH_STADIUM_FK) VALUES (7, '2016-06-12', null, 9, 11, '2016-06-12 21:00:00', 2,null);

INSERT INTO bet.MATCHS (ID, MATCH_DATE, SCORE, MATCH_OPPONENT1_FK, MATCH_OPPONENT2_FK, MATCH_TIME,MATCH_LEVEL, MATCH_STADIUM_FK) VALUES (8, '2016-06-13', null, 14, 16, '2016-06-13 15:00:00', 3,null);
INSERT INTO bet.MATCHS (ID, MATCH_DATE, SCORE, MATCH_OPPONENT1_FK, MATCH_OPPONENT2_FK, MATCH_TIME,MATCH_LEVEL, MATCH_STADIUM_FK) VALUES (9, '2016-06-13', null, 19, 18, '2016-06-13 18:00:00', 4,null);
INSERT INTO bet.MATCHS (ID, MATCH_DATE, SCORE, MATCH_OPPONENT1_FK, MATCH_OPPONENT2_FK, MATCH_TIME,MATCH_LEVEL, MATCH_STADIUM_FK) VALUES (10, '2016-06-13', null, 20, 17, '2016-06-13 21:00:00', 4,null);

INSERT INTO bet.MATCHS (ID, MATCH_DATE, SCORE, MATCH_OPPONENT1_FK, MATCH_OPPONENT2_FK, MATCH_TIME,MATCH_LEVEL, MATCH_STADIUM_FK) VALUES (11, '2016-06-14', null, 22, 24, '2016-06-14 18:00:00', 5,null);
INSERT INTO bet.MATCHS (ID, MATCH_DATE, SCORE, MATCH_OPPONENT1_FK, MATCH_OPPONENT2_FK, MATCH_TIME,MATCH_LEVEL, MATCH_STADIUM_FK) VALUES (12, '2016-06-14', null, 23, 21, '2016-06-14 21:00:00', 5,null);

INSERT INTO bet.MATCHS (ID, MATCH_DATE, SCORE, MATCH_OPPONENT1_FK, MATCH_OPPONENT2_FK, MATCH_TIME,MATCH_LEVEL, MATCH_STADIUM_FK) VALUES (13, '2016-06-15', null, 6, 8, '2016-06-15 15:00:00', 1,null);
INSERT INTO bet.MATCHS (ID, MATCH_DATE, SCORE, MATCH_OPPONENT1_FK, MATCH_OPPONENT2_FK, MATCH_TIME,MATCH_LEVEL, MATCH_STADIUM_FK) VALUES (14, '2016-06-15', null, 4, 1, '2016-06-15 18:00:00', 0,null);
INSERT INTO bet.MATCHS (ID, MATCH_DATE, SCORE, MATCH_OPPONENT1_FK, MATCH_OPPONENT2_FK, MATCH_TIME,MATCH_LEVEL, MATCH_STADIUM_FK) VALUES (15, '2016-06-15', null, 3, 2, '2016-06-15 21:00:00', 0,null);

INSERT INTO bet.MATCHS (ID, MATCH_DATE, SCORE, MATCH_OPPONENT1_FK, MATCH_OPPONENT2_FK, MATCH_TIME,MATCH_LEVEL, MATCH_STADIUM_FK) VALUES (16, '2016-06-16', null, 7, 5, '2016-06-16 15:00:00', 1,null);
INSERT INTO bet.MATCHS (ID, MATCH_DATE, SCORE, MATCH_OPPONENT1_FK, MATCH_OPPONENT2_FK, MATCH_TIME,MATCH_LEVEL, MATCH_STADIUM_FK) VALUES (17, '2016-06-16', null, 11, 10, '2016-06-16 18:00:00', 2,null);
INSERT INTO bet.MATCHS (ID, MATCH_DATE, SCORE, MATCH_OPPONENT1_FK, MATCH_OPPONENT2_FK, MATCH_TIME,MATCH_LEVEL, MATCH_STADIUM_FK) VALUES (18, '2016-06-16', null, 9, 12, '2016-06-16 21:00:00', 2,null);

INSERT INTO bet.MATCHS (ID, MATCH_DATE, SCORE, MATCH_OPPONENT1_FK, MATCH_OPPONENT2_FK, MATCH_TIME,MATCH_LEVEL, MATCH_STADIUM_FK) VALUES (19, '2016-06-17', null, 17, 18, '2016-06-17 15:00:00', 4,null);
INSERT INTO bet.MATCHS (ID, MATCH_DATE, SCORE, MATCH_OPPONENT1_FK, MATCH_OPPONENT2_FK, MATCH_TIME,MATCH_LEVEL, MATCH_STADIUM_FK) VALUES (20, '2016-06-17', null, 16, 15, '2016-06-17 18:00:00', 3,null);
INSERT INTO bet.MATCHS (ID, MATCH_DATE, SCORE, MATCH_OPPONENT1_FK, MATCH_OPPONENT2_FK, MATCH_TIME,MATCH_LEVEL, MATCH_STADIUM_FK) VALUES (21, '2016-06-17', null, 14, 13, '2016-06-17 21:00:00', 3,null);

INSERT INTO bet.MATCHS (ID, MATCH_DATE, SCORE, MATCH_OPPONENT1_FK, MATCH_OPPONENT2_FK, MATCH_TIME,MATCH_LEVEL, MATCH_STADIUM_FK) VALUES (22, '2016-06-18', null, 20, 19, '2016-06-18 15:00:00', 4,null);
INSERT INTO bet.MATCHS (ID, MATCH_DATE, SCORE, MATCH_OPPONENT1_FK, MATCH_OPPONENT2_FK, MATCH_TIME,MATCH_LEVEL, MATCH_STADIUM_FK) VALUES (23, '2016-06-18', null, 21, 24, '2016-06-18 18:00:00', 5,null);
INSERT INTO bet.MATCHS (ID, MATCH_DATE, SCORE, MATCH_OPPONENT1_FK, MATCH_OPPONENT2_FK, MATCH_TIME,MATCH_LEVEL, MATCH_STADIUM_FK) VALUES (24, '2016-06-18', null, 23, 22, '2016-06-18 21:00:00', 5,null);

INSERT INTO bet.MATCHS (ID, MATCH_DATE, SCORE, MATCH_OPPONENT1_FK, MATCH_OPPONENT2_FK, MATCH_TIME,MATCH_LEVEL, MATCH_STADIUM_FK) VALUES (25, '2016-06-19', null, 4, 2, '2016-06-19 21:00:00', 0,null);
INSERT INTO bet.MATCHS (ID, MATCH_DATE, SCORE, MATCH_OPPONENT1_FK, MATCH_OPPONENT2_FK, MATCH_TIME,MATCH_LEVEL, MATCH_STADIUM_FK) VALUES (26, '2016-06-19', null, 1, 3, '2016-06-19 21:00:00', 0,null);

INSERT INTO bet.MATCHS (ID, MATCH_DATE, SCORE, MATCH_OPPONENT1_FK, MATCH_OPPONENT2_FK, MATCH_TIME,MATCH_LEVEL, MATCH_STADIUM_FK) VALUES (27, '2016-06-20', null, 6, 5, '2016-06-20 21:00:00', 1,null);
INSERT INTO bet.MATCHS (ID, MATCH_DATE, SCORE, MATCH_OPPONENT1_FK, MATCH_OPPONENT2_FK, MATCH_TIME,MATCH_LEVEL, MATCH_STADIUM_FK) VALUES (28, '2016-06-20', null, 8, 7, '2016-06-20 21:00:00', 1,null);

INSERT INTO bet.MATCHS (ID, MATCH_DATE, SCORE, MATCH_OPPONENT1_FK, MATCH_OPPONENT2_FK, MATCH_TIME,MATCH_LEVEL, MATCH_STADIUM_FK) VALUES (29, '2016-06-21', null, 11, 12, '2016-06-21 18:00:00', 2,null);
INSERT INTO bet.MATCHS (ID, MATCH_DATE, SCORE, MATCH_OPPONENT1_FK, MATCH_OPPONENT2_FK, MATCH_TIME,MATCH_LEVEL, MATCH_STADIUM_FK) VALUES (30, '2016-06-21', null, 10, 9, '2016-06-21 18:00:00', 2,null);
INSERT INTO bet.MATCHS (ID, MATCH_DATE, SCORE, MATCH_OPPONENT1_FK, MATCH_OPPONENT2_FK, MATCH_TIME,MATCH_LEVEL, MATCH_STADIUM_FK) VALUES (31, '2016-06-21', null, 16, 13, '2016-06-21 21:00:00', 3,null);
INSERT INTO bet.MATCHS (ID, MATCH_DATE, SCORE, MATCH_OPPONENT1_FK, MATCH_OPPONENT2_FK, MATCH_TIME,MATCH_LEVEL, MATCH_STADIUM_FK) VALUES (32, '2016-06-21', null, 15, 14, '2016-06-21 21:00:00', 3,null);

INSERT INTO bet.MATCHS (ID, MATCH_DATE, SCORE, MATCH_OPPONENT1_FK, MATCH_OPPONENT2_FK, MATCH_TIME,MATCH_LEVEL, MATCH_STADIUM_FK) VALUES (33, '2016-06-22', null, 21, 22, '2016-06-22 18:00:00', 5,null);
INSERT INTO bet.MATCHS (ID, MATCH_DATE, SCORE, MATCH_OPPONENT1_FK, MATCH_OPPONENT2_FK, MATCH_TIME,MATCH_LEVEL, MATCH_STADIUM_FK) VALUES (34, '2016-06-22', null, 24, 23, '2016-06-22 18:00:00', 5,null);
INSERT INTO bet.MATCHS (ID, MATCH_DATE, SCORE, MATCH_OPPONENT1_FK, MATCH_OPPONENT2_FK, MATCH_TIME,MATCH_LEVEL, MATCH_STADIUM_FK) VALUES (35, '2016-06-22', null, 17, 19, '2016-06-22 21:00:00', 4,null);
INSERT INTO bet.MATCHS (ID, MATCH_DATE, SCORE, MATCH_OPPONENT1_FK, MATCH_OPPONENT2_FK, MATCH_TIME,MATCH_LEVEL, MATCH_STADIUM_FK) VALUES (36, '2016-06-22', null, 18, 20, '2016-06-22 21:00:00', 4,null);