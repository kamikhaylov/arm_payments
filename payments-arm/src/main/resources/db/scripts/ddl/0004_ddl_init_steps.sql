-- liquibase formatted sql

-- changeset konstantin:0004_ddl_initial_steps_#0001 logicalFilePath:path-independent runOnChange:true splitStatements:true endDelimiter:/
create table if not exists parameters
(
    name                varchar(64)     not null    unique,
    java_type           varchar(64)     not null,
    description         varchar(128)    not null,
    parameter_value     varchar(2400)   not null
);

comment on table parameters is 'Таблица управляемых параметров';
comment on column parameters.name is 'Название параметра';
comment on column parameters.java_type is 'Java-тип параметра';
comment on column parameters.description is 'Описание параметра';
comment on column parameters.parameter_value is 'Значение параметра';
/
