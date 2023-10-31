-- liquibase formatted sql

-- changeset konstantin:0003_dml_initial_steps_#0001 logicalFilePath:path-independent runOnChange:true splitStatements:true endDelimiter:/
insert into authorities (authority) values ('view.payments');
insert into authorities (authority) values ('edit.payments');
insert into authorities (authority) values ('view.paymentTypes');
insert into authorities (authority) values ('edit.paymentTypes');
insert into authorities (authority) values ('view.systemJournal');
insert into authorities (authority) values ('edit.systemJournal');
insert into authorities (authority) values ('view.metricMonitoring');
insert into authorities (authority) values ('edit.metricMonitoring');
/

-- changeset konstantin:0003_dml_initial_steps_#0002 logicalFilePath:path-independent runOnChange:true splitStatements:true endDelimiter:/
insert into users (
    login,
    password,
    email,
    enabled
)
values (
    'root',
    '$2a$10$qsvuecwqYo.ISn0i0hWEX.Q143UcZnCNG91DGg6oDEW32HWB3klL.',
    'root@support.com',
    true
);
/

-- changeset konstantin:0003_dml_initial_steps_#0003 logicalFilePath:path-independent runOnChange:true splitStatements:true endDelimiter:/
insert into user_authorities (user_id, authority_id)
values ((select id from users where login = 'root'), (select id from authorities where authority = 'view.payments'));
insert into user_authorities (user_id, authority_id)
values ((select id from users where login = 'root'), (select id from authorities where authority = 'edit.payments'));
insert into user_authorities (user_id, authority_id)
values ((select id from users where login = 'root'), (select id from authorities where authority = 'view.paymentTypes'));
insert into user_authorities (user_id, authority_id)
values ((select id from users where login = 'root'), (select id from authorities where authority = 'edit.paymentTypes'));
insert into user_authorities (user_id, authority_id)
values ((select id from users where login = 'root'), (select id from authorities where authority = 'view.systemJournal'));
insert into user_authorities (user_id, authority_id)
values ((select id from users where login = 'root'), (select id from authorities where authority = 'edit.systemJournal'));
insert into user_authorities (user_id, authority_id)
values ((select id from users where login = 'root'), (select id from authorities where authority = 'view.metricMonitoring'));
insert into user_authorities (user_id, authority_id)
values ((select id from users where login = 'root'), (select id from authorities where authority = 'edit.metricMonitoring'));
/
