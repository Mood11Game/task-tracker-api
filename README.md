# Task Tracker API

REST API для управления задачами.

## Stack

- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Hibernate
- Swagger OpenAPI
- Maven

## Endpoints

GET /tasks
- получить все задачи

GET /tasks/{id}
- получить задачу по ID

POST /tasks
- создать задачу

PUT /tasks/{id}
- обновить задачу

DELETE /tasks/{id}
- удалить задачу

GET /tasks/status/{status}
- фильтр по статусу

GET /tasks/sorted?field=title&direction=asc
- сортировка
