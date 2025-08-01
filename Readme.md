# Отчет по результатам выполнения задания демонстрационного экзамена

**Студент**: Никоненко Лев Евгеньевич  
**Организация**: Федеральное государственное автономное образовательное учреждение высшего образования Национальный исследовательский ядерный университет «МИФИ»  
**Группа**: М24-535  
**Дата**: 31.07.2025

---

## Приложение на основе Spring Boot
В рамках демонстрационного экзамена было разработано Java web-приложение на основе Spring Boot, реализующее REST API для управления пользователями. Приложение соответствует требованиям задания, включая работу с базой данных H2, использование модулей Spring Web и Spring Data JPA, а также реализацию трёх основных эндпоинтов. Для тестирования API использовался **Postman**.

### Описание функционала

1. **GET /user-api/v1/users**  
   Возвращает JSON со списком всех пользователей из базы данных.
    - **Результат**: Успешно возвращает список из пяти пользователей, загруженных из `data.sql`. 
      ```json
      [
          {"id": 1, "firstName": "John", "age": 25, "country": "USA"},
          {"id": 2, "firstName": "Emma", "age": 30, "country": "UK"},
          {"id": 3, "firstName": "Michael", "age": 35, "country": "CANADA"},
          {"id": 4, "firstName": "Sophie", "age": 28, "country": "GERMANY"},
          {"id": 5, "firstName": "Marie", "age": 32, "country": "FRANCE"}
      ]
      ```
      
2. **POST /user-api/v1/users**  
   Позволяет добавить нового пользователя в базу данных.
    - **Пример тела запроса**:
      ```json
      {
          "firstName": "Test",
          "age": 20,
          "country": "USA"
      }
      ```
    - **Результат**: Пользователь успешно добавляется в таблицу `users`, возвращается JSON с данными нового пользователя. Статус ответа: 200 OK.

3. **GET /user-api/v1/additional-info?country=USA,UK**  
   Возвращает отсортированный по стране список пользователей из указанных стран.
      
### Технические детали
- **База данных**: Использована in-memory база H2. Таблица `users` создаётся автоматически благодаря настройке `spring.jpa.hibernate.ddl-auto=update`. Данные инициализируются через `data.sql`.
- **Структура проекта**:
  ```
  user-api/
  ├── src/
  │   ├── main/
  │   │   ├── java/
  │   │   │   └── com/example/
  │   │   │       ├── UserApiApplication.java
  │   │   │       ├── model/
  │   │   │       │   ├── User.java
  │   │   │       │   └── Country.java
  │   │   │       ├── repository/
  │   │   │       │   └── UserRepository.java
  │   │   │       ├── service/
  │   │   │       │   └── UserService.java
  │   │   │       └── controller/
  │   │   │           └── UserController.java
  │   │   └── resources/
  │   │       ├── application.properties
  │   │       └── data.sql
  ├── pom.xml
  ```

## Заключение
Разработанное приложение успешно реализует заданный функционал: получение списка пользователей, добавление нового пользователя и фильтрацию пользователей по странам с сортировкой. Все эндпоинты протестированы с использованием **Postman**, возвращают ожидаемые результаты и соответствуют требованиям задания. В процессе разработки были выявлены и устранены проблемы с сериализацией JSON и конфигурацией базы данных, что позволило обеспечить стабильную работу приложения. Использование Spring Boot, Spring Data JPA, H2 и Postman упростило разработку, тестирование и взаимодействие с базой данных.