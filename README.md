# subscription service

это микросервис на Spring Boot 3 с Java 17, реализующий REST API для управления пользователями и их подписками на цифровые сервисы

## функциональность

- **управление пользователями:**
  - создание, получение, обновление и удаление пользователей
- **управление подписками:**
  - добавление подписки для пользователя.
  - получение списка подписок пользователя.
  - удаление подписки.
  - получение ТОП-3 популярных подписок.

## технологии

- Spring Boot 3
- Java 17
- PostgreSQL – база данных для хранения информации
- RabbitMQ – брокер сообщений для обмена событиями
- Flyway – для миграций базы данных
- Docker & Docker Compose

## Запуск проекта
```
mvn clean package -DskipTests
```
```
docker compose build
```
```
docker compose up -d
```

## Проверка API через curl:

- **Создать пользователя:**
  ```
  curl -X POST -H "Content-Type: application/json" \
       -d '{"name":"John Doe","email":"john@example.com"}' \
       http://localhost:8080/users
  ```

- **Получить пользователя:**
  ```
  curl http://localhost:8080/users/1
  ```

- **Обновить пользователя:**
  ```
  curl -X PUT -H "Content-Type: application/json" \
       -d '{"name": "John Smith", "email": "john.smith@example.com"}' \
       http://localhost:8080/users/1
  ```

- **Удалить пользователя:**
  ```
  curl -X DELETE http://localhost:8080/users/1
  ```

- **Добавить подписку пользователю:**
  ```
  curl -X POST -H "Content-Type: application/json" \
       -d '{"serviceName": "Netflix"}' \
       http://localhost:8080/users/1/subscriptions
  ```

- **Получить подписки пользователя:**
  ```
  curl http://localhost:8080/users/1/subscriptions
  ```

- **Удалить подписку:**
  ```
  curl -X DELETE http://localhost:8080/users/1/subscriptions/1
  ```

- **Получить ТОП-3 популярных подписок:**
  ```
  curl http://localhost:8080/subscriptions/top
  ```
