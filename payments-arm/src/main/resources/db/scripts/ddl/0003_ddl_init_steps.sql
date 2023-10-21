-- liquibase formatted sql

-- changeset konstantin:0003_ddl_initial_steps_#0001 logicalFilePath:path-independent runOnChange:true splitStatements:true endDelimiter:/
create table if not exists monitoring_metrics
(
    id              serial primary key   not null,
    created         timestamp            not null,
    code            varchar              not null,
    name            varchar              not null,
    metric_value    numeric              not null
);

comment on table monitoring_metrics is 'Таблица метрик мониторинга';
comment on column monitoring_metrics.id is 'Идентификатор записи';
comment on column monitoring_metrics.created is 'Дата и время создания записи';
comment on column monitoring_metrics.code is 'Код метрики';
comment on column monitoring_metrics.name is 'Название метрики';
comment on column monitoring_metrics.metric_value is 'Значение метрики';
/
