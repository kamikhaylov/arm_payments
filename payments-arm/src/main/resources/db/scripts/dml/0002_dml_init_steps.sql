-- liquibase formatted sql

-- changeset konstantin:0002_dml_initial_steps_#0001 logicalFilePath:path-independent runOnChange:true splitStatements:true endDelimiter:/
insert into parameters (name, java_type, description, parameter_value)
values ('payment.list.service.enabled', 'java.lang.Boolean', 'Включение/выключения сервиса получения списка платежей', 'true');
/

-- changeset konstantin:0002_dml_initial_steps_#0002 logicalFilePath:path-independent runOnChange:true splitStatements:true endDelimiter:/
insert into parameters (name, java_type, description, parameter_value)
values ('payment.details.service.enabled', 'java.lang.Boolean', 'Включение/выключения сервиса получения детальной информации платежа', 'true');
insert into parameters (name, java_type, description, parameter_value)
values ('payment.monitoring.service.enabled', 'java.lang.Boolean', 'Включение/выключения сервиса получения метрик мониторинга', 'true');
insert into parameters (name, java_type, description, parameter_value)
values ('payment.systemJournal.service.enabled', 'java.lang.Boolean', 'Включение/выключения сервиса получения записей системного журнала', 'true');
/
