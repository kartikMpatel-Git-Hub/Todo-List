
---

# 📝 Todo-List App (Spring Boot + JSP + MySQL + Docker + Spring Security)

A secure full-stack **Todo List** application built with **Java Spring Boot**, **JSP**, and **MySQL**—featuring user authentication using **Spring Security** and Dockerized MySQL setup.

---

## 🚀 Features

- ✅ User login with Spring Security
- 📝 Add, update, and delete tasks
- 📌 Mark tasks as completed
- 📂 View all or pending tasks
- 🧑 Per-user task management (only see your own tasks)
- 🖥️ JSP-based frontend with Bootstrap
- 🐬 MySQL database (Docker container)
- 🛡️ Secure login form with session handling

---
## 🔐 Spring Security Overview

* Custom login page (`/login`)
* Passwords stored securely (e.g., BCrypt)
* Session-based authentication
* Logout support
* Unauthorized access redirection

Example login credentials can be stored in the database using a `users` table with encrypted passwords.

---
## 🛠️ Tech Stack

| Layer        | Technology           |
|--------------|----------------------|
| Backend      | Spring Boot (Java)   |
| Frontend     | JSP, JSTL, Bootstrap |
| Authentication | Spring Security    |
| Database     | MySQL (Dockerized)   |
| ORM          | Spring Data JPA      |
| Build Tool   | Maven                |

---

## 🗃️ Project Structure

```

/todo-list/
├── src/main/java/
│   └── com/todo/
│       ├── controller/
│       ├── entity/
│       ├── repository/
│       └── TodoListApplication.java
├── src/main/webapp/WEB-INF/jsp/
│   ├── index.jsp
│   ├── add-task.jsp
│   └── header/footer.jsp
├── application.properties
├── Docker command (MySQL setup)
└── pom.xml

````

---

## 🐬 MySQL Setup Using Docker

Make sure Docker is installed and running.

Run the following command to start a MySQL 8 container:

```bash
docker run --detach \
  --env MYSQL_ROOT_PASSWORD=dummypassword \
  --env MYSQL_USER=todos-user \
  --env MYSQL_PASSWORD=dummytodos \
  --env MYSQL_DATABASE=todos \
  --name mysql \
  --publish 3306:3306 \
  mysql:8-oracle
````

---

## ⚙️ Configuration (application.properties)

```properties
spring.application.name=TodoList
server.port=3000
spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.suffix =.jsp
logging.level.org.springframework=info
logging.level.com.todo.TodoList.login=debug

spring.mvc.format.date=yyyy-MM-dd


# For H2
#spring.datasource.url=jdbc:h2:mem:testdb

#---------------------FOR MYSQL-----------------------------#
spring.datasource.url=jdbc:mysql://localhost:3306/todos

# For Docker
spring.datasource.username=<Your_username> 
spring.datasource.password=<Your_password>

# For Local SQL
#spring.datasource.username=<Your_username>
#spring.datasource.password=<Your_password>
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update

#--------------------------------------------------#

spring.jpa.defer-datasource-initialization=true
```

---

## ▶️ Running the Project

1. **Start MySQL Docker Container** (if not already running)
2. **Import the project into your IDE** (e.g., IntelliJ, Eclipse)
3. **Build the project** using Maven:

   ```bash
   mvn clean install
   ```
4. **Run the Spring Boot app**:

   ```bash
   mvn spring-boot:run
   ```
5. **Access the App**:
   Visit `http://localhost:8080` in your browser

---
## 🔐 Default Login (Sample)

You can preload users via schema or through registration logic:

| Username | Password                      |
|----------|-------------------------------|
| `Kartik` | `123` (encrypted with BCrypt) |

---

## 📌 Future Enhancements

* User registration with email verification
* OAuth2 login (Google/GitHub)
* Task categories/tags
* REST API with JWT
* Docker Compose for full-stack setup

---

## 🙋‍♂️ Author

Made with 💻 by [Kartik Patel](https://github.com/kartikMpatel-Git-Hub)

---
