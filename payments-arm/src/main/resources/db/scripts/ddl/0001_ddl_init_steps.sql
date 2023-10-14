-- liquibase formatted sql

-- changeset konstantin:0001_ddl_initial_steps_#0001 logicalFilePath:path-independent runOnChange:true splitStatements:true endDelimiter:/
create table if not exists payment_types
(
    type            varchar(50)     not null primary key,
    description     varchar(100)    not null
);

comment on table payment_types is 'Таблица типов платежей';
comment on column payment_types.type is 'Тип платежа';
comment on column payment_types.description is 'Описание';
/

-- changeset konstantin:0001_ddl_initial_steps_#0002 logicalFilePath:path-independent runOnChange:true splitStatements:true endDelimiter:/
create table if not exists payments
(
    payment_id      varchar(36)     not null primary key,
    client_id       varchar(36)     not null,
    creation_date   timestamp(6)    not null,
    amount          numeric(19,4),
    currency        varchar(3),
    organization    varchar(100),
    type            varchar(50)     not null,
    description     varchar(100),

    constraint fk_payments_type foreign key (type) references payment_types (type)
);

comment on table payments is 'Таблица платежей';
comment on column payments.payment_id is 'Идентификатор платежа';
comment on column payments.client_id is 'Идентификатор клиента';
comment on column payments.creation_date is 'Дата создания';
comment on column payments.amount is 'Сумма платежа';
comment on column payments.currency is 'Валюта платежа';
comment on column payments.organization is 'Организация';
comment on column payments.type is 'Тип платежа';
comment on column payments.description is 'Описание платежа';
/