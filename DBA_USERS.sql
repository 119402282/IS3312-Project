drop table USERS;
create table USERS
(
    EMAIL    VARCHAR(30) not null
        primary key,
    PASSWORD VARCHAR(25),
    TYPE     VARCHAR(5),
    FULLNAME VARCHAR(50),
    EIRCODE  VARCHAR(8)
);

INSERT INTO DBA.USERS (EMAIL, PASSWORD, TYPE, FULLNAME, EIRCODE) VALUES ('user@gmail.com', 'user', 'USER', 'Geralt of Rivia', 'D22 63XW');
INSERT INTO DBA.USERS (EMAIL, PASSWORD, TYPE, FULLNAME, EIRCODE) VALUES ('ciri@princess.pl', 'ciri', 'USER', 'Ciri of Cintra', 'V94 01DT');
INSERT INTO DBA.USERS (EMAIL, PASSWORD, TYPE, FULLNAME, EIRCODE) VALUES ('magic1000@power.net', 'courage', 'USER', 'Yennefer of Vengerberg', 'D01 8TPX');
INSERT INTO DBA.USERS (EMAIL, PASSWORD, TYPE, FULLNAME, EIRCODE) VALUES ('triss@gold.com', 'triss', 'USER', 'Triss Merigold', 'A82 D0V3');
INSERT INTO DBA.USERS (EMAIL, PASSWORD, TYPE, FULLNAME, EIRCODE) VALUES ('song@music.org', 'tossACoin2URWitcher', 'USER', 'Jaskier', 'A81 N4DR');
INSERT INTO DBA.USERS (EMAIL, PASSWORD, TYPE, FULLNAME, EIRCODE) VALUES ('admin@gmail.com', 'admin', 'ADMIN', 'King Foltest', 'D07 0P7K');
INSERT INTO DBA.USERS (EMAIL, PASSWORD, TYPE, FULLNAME, EIRCODE) VALUES ('q.cal@mail.com', 'lioness', 'ADMIN', 'Queen Calanthe', 'H91 83WC');
