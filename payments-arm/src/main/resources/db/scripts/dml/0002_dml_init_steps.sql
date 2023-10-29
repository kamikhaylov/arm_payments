-- liquibase formatted sql

-- changeset konstantin:0002_dml_initial_steps_#0001 logicalFilePath:path-independent runOnChange:true splitStatements:true endDelimiter:/
insert into parameters (name, java_type, description, parameter_value)
values ('payment.list.service.enabled', 'java.lang.Boolean', 'Включение/выключения сервиса получения списка платежей', 'false');
/

-- changeset konstantin:0002_dml_initial_steps_#0002 logicalFilePath:path-independent runOnChange:true splitStatements:true endDelimiter:/
insert into parameters (name, java_type, description, parameter_value)
values ('payment.details.service.enabled', 'java.lang.Boolean', 'Включение/выключения сервиса получения детальной информации платежа', 'false');
insert into parameters (name, java_type, description, parameter_value)
values ('payment.monitoring.service.enabled', 'java.lang.Boolean', 'Включение/выключения сервиса получения метрик мониторинга', 'false');
insert into parameters (name, java_type, description, parameter_value)
values ('payment.systemJournal.service.enabled', 'java.lang.Boolean', 'Включение/выключения сервиса получения записей системного журнала', 'false');
/

-- changeset konstantin:0002_dml_initial_steps_#0003 logicalFilePath:path-independent runOnChange:true splitStatements:true endDelimiter:/
insert into parameters (name, java_type, description, parameter_value)
values ('payment.type.list.service.enabled', 'java.lang.Boolean', 'Включение/выключения сервиса получения списка типов платежей', 'false');
/

-- changeset konstantin:0002_dml_initial_steps_#0004 logicalFilePath:path-independent runOnChange:true splitStatements:true endDelimiter:/
insert into parameters (name, java_type, description, parameter_value)
values ('payment.type.merge.service.enabled', 'java.lang.Boolean', 'Включение/выключения сервиса вставки типа платежа', 'false');
insert into parameters (name, java_type, description, parameter_value)
values ('payment.type.delete.service.enabled', 'java.lang.Boolean', 'Включение/выключения сервиса удаления типа платежа', 'false');
/
