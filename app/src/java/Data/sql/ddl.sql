drop table orders;
drop table boots;
drop table users;

create table USERS
(
    EMAIL    VARCHAR(30) not null
        primary key,
    PASSWORD VARCHAR(25),
    TYPE     VARCHAR(5),
    FULLNAME VARCHAR(50),
    EIRCODE  VARCHAR(8)
);

create table BOOTS
(
    CODE        INTEGER       not null
        primary key,
    NAME        VARCHAR(100)  not null,
    TYPE        VARCHAR(20)   not null,
    DESCRIPTION VARCHAR(1000) not null,
    SIZE        INTEGER       not null,
    COLOR       VARCHAR(15)   not null,
    PRICE       NUMERIC(6, 2) not null,
    BRAND       VARCHAR(30)   not null
);

create table ORDERS
(
    TROLLEY_ID  INTEGER     not null,
    BOOT_CODE   INTEGER     not null
        constraint ORDERS_BOOTS_CODE_FK
            references BOOTS
            on delete cascade,
    CUST_EMAIL  VARCHAR(30) not null
        constraint ORDERS_USERS_EMAIL_FK
            references USERS
            on delete cascade,
    QUANTITY    INTEGER,
    PRICE       DOUBLE,
    DATE_CLOSED DATE,
    constraint ORDERS_PK
        primary key (TROLLEY_ID, BOOT_CODE, CUST_EMAIL)
);
