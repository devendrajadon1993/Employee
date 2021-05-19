# Spring boot and MySql REST API - CRUD Example

The application demonstrates the REST API using Spring boot and Mysql. The application demonstrates all the database operations like Create, Read, Update and Delete.

## Tools and Technologies used

* Spring boot 2.0.1
* [MySql] - https://dev.mysql.com/downloads/mysql/5.5.html?os=3&version=5
* [Spring Tool Suite] (https://spring.io/blog/2020/03/20/spring-tools-4-6-0-released)
* JDK 1.8 - http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
* Maven 3 - https://maven.apache.org/
* [Git] (https://github.com/devendrajadon1993/Employee)


Database
Application uses mysql db. The connection string to database can be changed easily in the application.yml.

## Step to install

1. **Clone the application**

```bash
git clone https://github.com/devendrajadon1993/Employee.git
```

2. **Build and run the backend app using maven**

```bash
cd spring-employee-rest-api
mvn package
java -jar target/spring-employee-rest-api-0.0.1-SNAPSHOT.jar
```

Alternatively, you can run the app without packaging it using -

```bash
mvn spring-boot:run
```

The backend server will start at <http://localhost:8080>.

Swagger Docs

Run the server and browse to {application root URL}/swagger-ui.html
