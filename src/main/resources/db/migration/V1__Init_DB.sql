create table measure
(
    measure_id int8 not null,
    measures   varchar(255)
);
create table product
(
    id            bigserial not null,
    deleting_sign boolean,
    name          varchar(255),
    value         numeric(19, 2),
    vendor_code   varchar(255),
    user_id       int8,
    primary key (id)
);;
create table roles
(
    user_id int8 not null,
    roles   varchar(255)
);
create table shipment
(
    id         bigserial not null,
    barcode    varchar(255),
    weight     numeric(19, 2),
    product_id int8,
    primary key (id)
);
create table usr
(
    id              bigserial not null,
    activation_code varchar(255),
    active          boolean,
    email           varchar(255),
    login           varchar(255),
    password        varchar(255),
    primary key (id)
);
alter table if exists measure
    add constraint measure_shipment_fk foreign key (measure_id) references shipment;
alter table if exists product
    add constraint product_usr_fk foreign key (user_id) references usr;
alter table if exists product
    add constraint product_product_fk foreign key (id) references product;
alter table if exists roles
    add constraint roles_usr_fk foreign key (user_id) references usr;
alter table if exists shipment
    add constraint shipment_product_fk foreign key (product_id) references product;
alter table if exists shipment
    add constraint shipment_shipment_fk foreign key (id) references shipment