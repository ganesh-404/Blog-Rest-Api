Here is the updated `README.md` with a section on containerization using Docker:

```markdown
# Blogs Management

## Overview

Blogs Management is a Spring Boot application designed to manage blog posts. It provides functionalities to create,
read, update, and delete blog entries. The project uses Maven for dependency management and includes integration tests
with Testcontainers.

## Project Structure

- **core-services**: Contains the core services and business logic.
    - **src/main/java**: Contains the main application code.
    - **src/test/java**: Contains the test code.

## Technologies Used

- **Java**: Programming language.
- **Spring Boot**: Framework for building the application.
- **Maven**: Dependency management.
- **Lombok**: Reduces boilerplate code.
- **MapStruct**: Mapper for converting between entities and DTOs.
- **Testcontainers**: Provides throwaway instances of databases for testing.
- **Docker**: Containerization platform.

## Prerequisites

- Java 11 or higher
- Maven 3.6.0 or higher
- Docker (for Testcontainers and containerization)

## Getting Started

### Clone the Repository

```sh
git clone https://github.com/Ganesh-Heerah/blogs-management.git
cd blogs-management
```

### Build the Project

```sh
mvn clean install
```

### Run the Application

```sh
mvn spring-boot:run
```

## Running Tests

The project includes integration tests that use Testcontainers to spin up a MySQL database.

```sh
mvn test
```

## Containerization with Docker

The application can be containerized using Docker. A `Dockerfile` is provided to build a Docker image.

### Build Docker Image

```sh
docker build -t blogs-management:latest -f backend-app/Dockerfile .
```

### Run Docker Container

```sh
docker run -p 8080:8080 blogs-management:latest
```

## Project Modules

### core-services

This module contains the core business logic and services.

#### Key Classes

- **BlogServiceImpl**: Service implementation for managing blogs.
- **BlogRepository**: Repository interface for Blog entity.
- **BlogMapper**: Mapper interface for converting between Blog entities and DTOs.

## Dependencies

### Maven Dependencies

- **Spring Boot Starter Data JPA**: For JPA and Hibernate.
- **Lombok**: To reduce boilerplate code.
- **MapStruct**: For object mapping.
- **Testcontainers**: For integration testing with containers.

### Example `pom.xml`

```xml

<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>${lombok.version}</version>
    </dependency>
    <dependency>
        <groupId>org.mapstruct</groupId>
        <artifactId>mapstruct</artifactId>
        <version>1.6.2</version>
    </dependency>
    <dependency>
        <groupId>org.testcontainers</groupId>
        <artifactId>testcontainers</artifactId>
        <version>1.17.3</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.testcontainers</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>1.17.3</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.testcontainers</groupId>
        <artifactId>mysql</artifactId>
        <version>1.17.3</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

## Author

- Ganesh Heerah

## License

This project is licensed under the MIT License.

```

This `README.md` now includes instructions for building and running the Docker container.