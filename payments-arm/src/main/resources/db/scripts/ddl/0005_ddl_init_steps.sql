-- liquibase formatted sql

-- changeset konstantin:0005_ddl_initial_steps_#0001 logicalFilePath:path-independent runOnChange:true splitStatements:true endDelimiter:/
create table if not exists authorities (
    id          serial       primary key,
    authority   varchar(50)  not null unique
);

comment on table authorities is 'Роли пользователей';
comment on column authorities.id is 'Идентификатор роли пользователя';
comment on column authorities.authority is 'Роль пользователя';
/

-- changeset konstantin:0005_ddl_initial_steps_#0002 logicalFilePath:path-independent runOnChange:true splitStatements:true endDelimiter:/
create table if not exists users (
    id              serial          not null    primary key,
    login           varchar         not null    unique,
    password        varchar         not null,
    email           varchar         not null,
    enabled         boolean         not null
);

comment on table users is 'Пользователи';
comment on column users.id is 'Идентификатор пользователя';
comment on column users.login is 'Логин';
comment on column users.password is 'Пароль';
comment on column users.email is 'Почтовый ящик';
comment on column users.enabled is 'Признак доступности учетной записи';
/

-- changeset konstantin:0005_ddl_initial_steps_#0003 logicalFilePath:path-independent runOnChange:true splitStatements:true endDelimiter:/
create table if not exists user_authorities (
    id              serial   primary key,
    user_id         int      not null       references users(id),
    authority_id    int      not null       references authorities(id)
);

comment on table user_authorities is 'Выданные роли пользователям';
comment on column user_authorities.id is 'Идентификатор выданной роли';
comment on column user_authorities.user_id is 'Идентификатор пользователя';
comment on column user_authorities.authority_id is 'Идентификатор роли';
/

-- changeset konstantin:0005_ddl_initial_steps_#0004 logicalFilePath:path-independent runOnChange:true splitStatements:true endDelimiter:/
alter table user_authorities add constraint uc_user_id_authority_id unique (user_id, authority_id);
/

-- changeset konstantin:0005_ddl_initial_steps_#0005 logicalFilePath:path-independent runOnChange:true splitStatements:true endDelimiter:/
create table if not exists user_tokens (
    user_id         int             not null    unique,
    token           varchar         not null,
    created         timestamp       not null,

    constraint fk_user_id foreign key (user_id) references users (id)
);

comment on table user_tokens is 'Токены пользователей';
comment on column user_tokens.user_id is 'Идентификатор пользователя';
comment on column user_tokens.token is 'Токен';
comment on column user_tokens.created is 'Дата и время создания токена';
/