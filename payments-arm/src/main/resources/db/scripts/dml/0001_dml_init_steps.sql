-- liquibase formatted sql

-- changeset konstantin:0001_dml_initial_steps_#0001 logicalFilePath:path-independent runOnChange:true splitStatements:true endDelimiter:/
insert into payment_types (type, description) values ('mobilePayment', 'Платеж за мобильную связь');
insert into payment_types (type, description) values ('communalServicesPayment', 'Оплата ЖКХ');
insert into payment_types (type, description) values ('сarTaxPayment', 'Налог на автомобиль');
insert into payment_types (type, description) values ('propertyTax', 'Налог на недвижимость');
insert into payment_types (type, description) values ('customsDuty', 'Таможенная пошлина');
/

-- changeset konstantin:0001_dml_initial_steps_#0002 logicalFilePath:path-independent runOnChange:true splitStatements:true endDelimiter:/
insert into payments (payment_id, client_id, creation_date, amount, currency, organization, type, description)
values ('70000010', '100000900', current_date, 1000, 'RUB', 'OOO MOBILE', 'mobilePayment', 'Ежемесячная оплата за мобильную связь');
/
