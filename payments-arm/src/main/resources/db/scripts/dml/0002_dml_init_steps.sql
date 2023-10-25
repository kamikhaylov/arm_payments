-- liquibase formatted sql

-- changeset konstantin:0002_dml_initial_steps_#0001 logicalFilePath:path-independent runOnChange:true splitStatements:true endDelimiter:/
insert into parameters (name, java_type, description, parameter_value)
values ('payment.list.service.enabled', 'java.lang.Boolean', 'Включение/выключения сервиса получения списка платежей', 'true');
/
