# 📋 Task Tracker REST API

  

<div align="center">

  

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk&logoColor=white)

![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.5-brightgreen?style=for-the-badge&logo=springboot&logoColor=white)

![Spring Data JPA](https://img.shields.io/badge/Spring_Data_JPA-Hibernate-blue?style=for-the-badge&logo=hibernate&logoColor=white)

![PostgreSQL](https://img.shields.io/badge/PostgreSQL-14+-336791?style=for-the-badge&logo=postgresql&logoColor=white)

![Swagger / OpenAPI](https://img.shields.io/badge/OpenAPI_3-Swagger_UI-85EA2D?style=for-the-badge&logo=swagger&logoColor=black)

![Maven](https://img.shields.io/badge/Maven-3.9+-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)

  

**Надежный и производительный RESTful API сервис для управления задачами и трекинга жизненного цикла workflow.**

  

[Возможности](#-основные-возможности) • [Стек технологий](#-стек-технологий) • [Быстрый старт](#-быстрый-старт) • [Спецификация API](#-документация-api) • [Архитектура](#-архитектура-проекта) • [Тестирование](#-тестирование)

  

</div>

  

---

  

## 📌 О проекте

  

**Task Tracker API** — это бэкенд-сервис для трекинга задач, разработанный в соответствии с принципами чистой архитектуры и REST-стандартами на современном стеке **Java 21** и **Spring Boot 3**.

  

Проект спроектирован с учетом требований к production-решениям: валидация входных данных на уровне модели, серверная пагинация, фильтрация по статусам, регистронезависимый поиск, сортировка по произвольным полям и интерактивная интерактивная документация через Swagger / OpenAPI 3.

  

---

  

## ✨ Основные возможности

  

- 🔄 **Полный жизненный цикл CRUD**: создание, просмотр, обновление и удаление задач.

- 🛡 **Строгая валидация (Jakarta Validation)**: защита от пустых значений и контроль длины полей (`@NotBlank`, `@Size`).

- 📄 **Серверная пагинация**: постраничная выдача результатов (`Pageable`) для масштабируемой работы с большими объемами данных.

- 🔍 **Полнотекстовый поиск**: регистронезависимый поиск по подстроке в названии задачи (`containingIgnoreCase`).

- 🏷 **Фильтрация по статусам**: выборка задач по этапам (`TODO`, `IN_PROGRESS`, `DONE`).

- ↕️ **Динамическая сортировка**: сортировка списка задач по любому полю сущности в порядке возрастания или убывания.

- 📖 **Автодокументирование (OpenAPI / Swagger)**: интерактивная веб-консоль для тестирования эндпоинтов из браузера.

- 🧪 **Комплексные тесты**: интеграционное и компонентное тестирование сервисного слоя с использованием in-memory базы H2.

  

---

  

## 🛠 Стек технологий

  

| Категория | Технологии |

|---|---|

| **Платформа** | Java 21 LTS |

| **Фреймворк** | Spring Boot 3.5.x (Spring Web, Spring Data JPA, Spring Validation) |

| **Базы данных** | PostgreSQL (основная СУБД), H2 Database (in-memory для тестов) |

| **ORM / Спецификация** | Hibernate, Jakarta Persistence (JPA) |

| **API Документация** | Springdoc OpenAPI 3.0 / Swagger UI |

| **Библиотеки и утилиты** | Project Lombok |

| **Тестирование** | JUnit 5, Spring Boot Starter Test |

| **Сборщик проекта** | Apache Maven (Maven Wrapper) |

  

---

  

## 📊 Модель данных

  

Сущность `Task` описывает задачу в системе:

  

| Поле | Тип | Ограничения | Описание |

|---|---|---|---|

| `id` | `Long` | Primary Key, Auto-increment (`IDENTITY`) | Уникальный идентификатор задачи |

| `title` | `String` | `@NotBlank`, `max = 100` | Название (заголовок) задачи |

| `description` | `String` | `@NotBlank`, `max = 500` | Подробное описание задачи |

| `status` | `Enum (TaskStutas)` | `TODO`, `IN_PROGRESS`, `DONE` | Текущий статус выполнения |

| `priority` | `Enum (TaskPriority)` | `LOW`, `MEDIUM`, `HIGH` | Приоритет задачи |

  

### Пример JSON-представления:

  

```json

{

"id": 1,

"title": "Настроить Spring Security",

"description": "Реализовать аутентификацию по JWT-токену",

"status": "IN_PROGRESS",

"priority": "HIGH"

}

```

  

---

  

## 🚀 Быстрый старт

  

### Требования

- **JDK**: версия 21 или выше

- **PostgreSQL**: версия 14 или выше

- **Git**

  

### 1. Клонирование репозитория

```bash

git clone https://github.com/<your-username>/task-tracker-api.git

cd task-tracker-api

```

  

### 2. Настройка базы данных

Создайте локальную базу данных в PostgreSQL:

```sql

CREATE DATABASE tasktracker;

```

  

Создайте конфигурационный файл `application.properties` из шаблона:

```bash

cp src/main/resources/application.properties.example src/main/resources/application.properties

```

  

Откройте `src/main/resources/application.properties` и укажите ваши параметры подключения:

```properties

spring.application.name=task-tracker

  

spring.datasource.url=jdbc:postgresql://localhost:5432/tasktracker

spring.datasource.username=YOUR_USERNAME

spring.datasource.password=YOUR_PASSWORD

  

spring.jpa.hibernate.ddl-auto=update

spring.jpa.show-sql=true

```

  

### 3. Запуск приложения

  

Используйте Maven Wrapper, установленный в проекте:

  

**Для macOS / Linux:**

```bash

./mvnw clean spring-boot:run

```

  

**Для Windows:**

```cmd

mvnw.cmd clean spring-boot:run

```

  

После старта сервер будет доступен по адресу: `http://localhost:8080`.

  

### 4. Доступ к интерактивной документации Swagger UI

После запуска приложения перейдите в браузере:

- **Swagger UI**: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

- **OpenAPI Schema (JSON)**: [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

  

---

  

## 📖 Документация API

  

### Сводная таблица эндпоинтов

  

| Метод | Эндпоинт | Описание |

|---|---|---|

| `POST` | `/tasks` | Создание новой задачи |

| `GET` | `/tasks` | Получение списка всех задач (с пагинацией) |

| `GET` | `/tasks/{id}` | Получение задачи по идентификатору (ID) |

| `PUT` | `/tasks/{id}` | Полное обновление задачи по ID |

| `DELETE` | `/tasks/{id}` | Удаление задачи по ID |

| `GET` | `/tasks/status/{status}` | Фильтрация задач по статусу (`TODO`, `IN_PROGRESS`, `DONE`) |

| `GET` | `/tasks/search` | Регистронезависимый поиск по названию (`title`) |

| `GET` | `/tasks/sorted` | Сортировка по выбранному полю (`field`, `direction`) |

  

---

  

### Примеры запросов и ответов (cURL)

  

#### 1. Создание задачи (`POST /tasks`)

  

**Запрос:**

```bash

curl -X POST http://localhost:8080/tasks \

-H "Content-Type: application/json" \

-d '{

"title": "Реализовать кэширование",

"description": "Подключить Redis для кэширования частых запросов",

"status": "TODO",

"priority": "MEDIUM"

}'

```

  

**Ответ `200 OK`:**

```json

{

"id": 1,

"title": "Реализовать кэширование",

"description": "Подключить Redis для кэширования частых запросов",

"status": "TODO",

"priority": "MEDIUM"

}

```

  

---

  

#### 2. Получение задач с пагинацией (`GET /tasks`)

  

Поддерживает стандартные параметры Spring Data: `page` (индекс с 0), `size` (размер страницы), `sort`.

  

**Запрос:**

```bash

curl -X GET "http://localhost:8080/tasks?page=0&size=10&sort=id,desc"

```

  

**Ответ `200 OK`:**

```json

{

"content": [

{

"id": 1,

"title": "Реализовать кэширование",

"description": "Подключить Redis для кэширования частых запросов",

"status": "TODO",

"priority": "MEDIUM"

}

],

"pageable": {

"pageNumber": 0,

"pageSize": 10,

"sort": {

"empty": false,

"sorted": true,

"unsorted": false

},

"offset": 0,

"paged": true,

"unpaged": false

},

"totalElements": 1,

"totalPages": 1,

"last": true,

"size": 10,

"number": 0,

"numberOfElements": 1,

"first": true,

"empty": false

}

```

  

---

  

#### 3. Получение задачи по ID (`GET /tasks/{id}`)

  

**Запрос:**

```bash

curl -X GET http://localhost:8080/tasks/1

```

  

**Ответ `200 OK`:**

```json

{

"id": 1,

"title": "Реализовать кэширование",

"description": "Подключить Redis для кэширования частых запросов",

"status": "TODO",

"priority": "MEDIUM"

}

```

  

---

  

#### 4. Обновление задачи (`PUT /tasks/{id}`)

  

**Запрос:**

```bash

curl -X PUT http://localhost:8080/tasks/1 \

-H "Content-Type: application/json" \

-d '{

"title": "Реализовать кэширование (In Progress)",

"description": "Подключить Redis и написать юнит-тесты",

"status": "IN_PROGRESS",

"priority": "HIGH"

}'

```

  

**Ответ `200 OK`:**

```json

{

"id": 1,

"title": "Реализовать кэширование (In Progress)",

"description": "Подключить Redis и написать юнит-тесты",

"status": "IN_PROGRESS",

"priority": "HIGH"

}

```

  

---

  

#### 5. Удаление задачи (`DELETE /tasks/{id}`)

  

**Запрос:**

```bash

curl -X DELETE http://localhost:8080/tasks/1

```

  

**Ответ `200 OK`**

  

---

  

#### 6. Фильтрация по статусу (`GET /tasks/status/{status}`)

  

Доступные значения статусов: `TODO`, `IN_PROGRESS`, `DONE`.

  

**Запрос:**

```bash

curl -X GET http://localhost:8080/tasks/status/IN_PROGRESS

```

  

**Ответ `200 OK`:**

```json

[

{

"id": 1,

"title": "Реализовать кэширование (In Progress)",

"description": "Подключить Redis и написать юнит-тесты",

"status": "IN_PROGRESS",

"priority": "HIGH"

}

]

```

  

---

  

#### 7. Поиск по названию (`GET /tasks/search?title={query}`)

  

Поиск выполняется регистронезависимо по вхождению переданной подстроки.

  

**Запрос:**

```bash

curl -X GET "http://localhost:8080/tasks/search?title=кэш"

```

  

**Ответ `200 OK`:**

```json

[

{

"id": 1,

"title": "Реализовать кэширование (In Progress)",

"description": "Подключить Redis и написать юнит-тесты",

"status": "IN_PROGRESS",

"priority": "HIGH"

}

]

```

  

---

  

#### 8. Сортировка по полю (`GET /tasks/sorted?field={field}&direction={asc|decs}`)

  

Сортировка по любому атрибуту сущности (например, `title`, `id`, `priority`, `status`).

  

**Запрос:**

```bash

curl -X GET "http://localhost:8080/tasks/sorted?field=title&direction=asc"

```

  

**Ответ `200 OK`:**

```json

[

{

"id": 1,

"title": "Реализовать кэширование",

"description": "Подключить Redis",

"status": "TODO",

"priority": "HIGH"

},

{

"id": 2,

"title": "Создать Swagger документацию",

"description": "Описать эндпоинты через аннотации",

"status": "DONE",

"priority": "MEDIUM"

}

]

```

  

---

  

## 📂 Архитектура проекта

  

Проект выстроен по классической слоистой архитектуре (**Layered Architecture**), обеспечивающей разделение ответственности (Separation of Concerns):

  

```

task-tracker-api/

├── src/

│ ├── main/

│ │ ├── java/com/example/task_tracker/

│ │ │ ├── TaskTrackerApplication.java # Точка входа в Spring Boot приложение

│ │ │ ├── Task.java # JPA Entity (сущность с правилами валидации)

│ │ │ ├── TaskRepository.java # Слой доступа к данным (Spring Data JPA)

│ │ │ ├── controller/

│ │ │ │ ├── TaskController.java # REST Контроллер (эндпоинты и маршрутизация)

│ │ │ │ ├── TaskPriority.java # Enum: LOW, MEDIUM, HIGH

│ │ │ │ └── TaskStutas.java # Enum: TODO, IN_PROGRESS, DONE

│ │ │ └── service/

│ │ │ └── TaskService.java # Сервисный слой (бизнес-логика)

│ │ └── resources/

│ │ ├── application.properties.example # Шаблон настроек подключения к БД

│ │ └── application.properties # Локальная конфигурация (git-ignored)

│ └── test/

│ └── java/com/example/task_tracker/

│ ├── TaskTrackerApplicationTests.java # Тест загрузки Spring Application Context

│ └── serviceTest/

│ └── TeskServiceTest.java # Интеграционные тесты сервисного слоя

├── pom.xml # Конфигурация Maven зависимостей и сборки

├── mvnw / mvnw.cmd # Maven Wrapper скрипты

└── README.md # Документация проекта

```

  

---

  

## 🧪 Тестирование

  

Тесты сервисного слоя (`TaskServiceTest`) написаны с использованием **JUnit 5** и **Spring Boot Test**. Для максимальной изоляции тестов от внешнего окружения в качестве БД используется in-memory база **H2**.

  

### Запуск тестов:

```bash

./mvnw test

```

  

### Покрытые сценарии:

- ✅ Создание новой задачи (`createTaskTest`)

- ✅ Получение задачи по первичному ключу (`getTaskById`)

- ✅ Обновление всех полей задачи (`updateTask`)

- ✅ Удаление задачи и проверка отсутствия в репозитории (`deleteTest`)

- ✅ Выборка всех сохраненных задач (`getAllTaskTest`)

- ✅ Фильтрация по статусу выполнения (`getTaskByStatusTest`)

- ✅ Поиск по фрагменту заголовка (`searchByTitleTest`)

- ✅ Корректность сортировки по возрастанию и убыванию (`getTaskSortedTest`)

  

---
