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

INSERT INTO DBA.ORDERS (TROLLEY_ID, BOOT_CODE, CUST_EMAIL, QUANTITY, PRICE, DATE_CLOSED) VALUES (2, 3, 'user@gmail.com', 3, 285, null);
INSERT INTO DBA.ORDERS (TROLLEY_ID, BOOT_CODE, CUST_EMAIL, QUANTITY, PRICE, DATE_CLOSED) VALUES (2, 1, 'user@gmail.com', 1, 59.99, null);
INSERT INTO DBA.ORDERS (TROLLEY_ID, BOOT_CODE, CUST_EMAIL, QUANTITY, PRICE, DATE_CLOSED) VALUES (1, 2, 'user@gmail.com', 2, 131.98, '2022-02-10');
