# arm_payments
Проект "АРМ Платежи"

[![github actions][actions-image]][actions-url]
[![coverage][codecov-image]][codecov-url]

### Ипользуемые технологии

![tech-4.png](readme/image/tech-4.png)

Бэк: Java, SpringBoot, Spring AOP, Spring Data, PostgreSQL, JUnit, Maven

Фронт: JavaScript, React, Material UI, NPM

Веб-приложение по администрированию и сопровождению платежей клиента.

Возможности приложения:
- Просмотр платежей клиента по различным фильтрам.
- Настройка типов платежей: создание, обновление, удаление.
- Настройка фильтров платежей.
- Просмотр журналирования приложения.
- Мониторинг приложения.
- Управление параметрами приложения.

### Архитектура приложения трехслойная
- Слой контроллеры (прием запросов, валидацию и формирование ответа).
- Слой сервисы (бизнес логика приложения).
- Слой работы с БД (DAO-библиотеки).

Сервисы:
- Платежи.
- Логировние.
- Мониторинг.
- Управление параметрами.
- Аунтификация.


### Контакты
- kanmikhaylov@gmail.com
- [telegram](https://t.me/KonstantinM1khaylov)

[actions-image]: https://github.com/kamikhaylov/arm_payments/actions/workflows/maven.yml/badge.svg
[actions-url]: https://github.com/kamikhaylov/arm_payments/actions/workflows/maven.yml
[codecov-image]: https://codecov.io/gh/kamikhaylov/arm_payments/graph/badge.svg?token=
[codecov-url]: https://codecov.io/gh/kamikhaylov/arm_payments