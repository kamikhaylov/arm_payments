-- liquibase formatted sql

-- changeset konstantin:0002_ddl_initial_steps_#0001 logicalFilePath:path-independent runOnChange:true splitStatements:true endDelimiter:/
create table if not exists system_journal
(
    id              serial primary key,
    level           varchar,
    created         timestamp,
    message         text,
    parameters      text,
    class_name      varchar,
    trace           text
);

comment on table system_journal is 'Системный журнал логирования';
comment on column system_journal.id is 'Идентификатор записи';
comment on column system_journal.level is 'Уровень логирования';
comment on column system_journal.created is 'Дата и время записи';
comment on column system_journal.message is 'Запись журнала';
comment on column system_journal.parameters is 'Параметры логирования';
comment on column system_journal.class_name is 'Имя класса';
comment on column system_journal.trace is 'Трассировка';
/
