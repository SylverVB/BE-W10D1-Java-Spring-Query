# Spring-Query

A Spring Boot project designed to explore writing and testing **custom database queries** using **JPQL** (Java Persistence Query Language).

## 📚 Purpose

The purpose of this project is to **learn and practice writing custom database queries** in **Spring's JPQL**, beyond basic CRUD operations.

---

## 🚀 Project Overview

This project demonstrates:

- Setting up a basic **Spring Boot** application with Maven.
- Using **JPA** and **Hibernate** for database interaction.
- Defining custom **JPQL queries** in a repository interface.
- Writing **manual tests** in a main application class.
- Writing **unit tests** to validate repository methods.
- Using an **in-memory H2 database** for fast testing without external setup.

---

## 🛠️ Features

### 1. Maven Setup (`pom.xml`)
- Configured Spring Boot (v3.4.5) with essential dependencies: Web, JPA, Lombok, H2 database, Actuator, DevTools.
- Set Java 21 compatibility.
- Enabled unit testing with Surefire plugin and Mockito agent.

### 2. Application Properties (`application.properties`)
- Disabled web server for development (`spring.main.web-application-type=none`).
- Configured JPA to automatically create and drop tables during session (`spring.jpa.hibernate.ddl-auto=create-drop`).

### 3. Entity: `Pet` (`Pet.java`)
- A simple model class with fields: `id`, `name`, `species`, and `age`.
- Auto-generated primary key using `IDENTITY`.
- Used Lombok for cleaner code (getters, setters, constructors, etc.).

### 4. Repository: `PetRepository` (`PetRepository.java`)
- Extended `JpaRepository` for standard CRUD operations.
- Defined custom JPQL queries:
  - Find pets by name.
  - Find pets by name and species.
  - Find the oldest pet.
  - Find the average age of all pets.

### 5. Manual Testing: `App` (`App.java`)
- Manually tested repository methods inside a Spring Boot `main` method.
- Saved sample pets and printed query results to the console for verification.

### 6. Unit Testing: `PetRepositoryTest` (`PetRepositoryTest.java`)
- Automated testing of repository custom queries using JUnit 5.
- Verified the accuracy of queries with assertions.
- Cleared database before each test to ensure isolated environments.

---

## 📦 Technologies Used
- Java 21
- Spring Boot 3.4.5
- Spring Data JPA
- H2 In-Memory Database
- Maven
- Lombok
- JUnit 5

---

## ⚡ How to Run

1. **Clone the repository**:
   ```bash
   git clone https://github.com/SylverVB/BE-W10D1-Java-Spring-Query.git
   cd BE-W10D1-Java-Spring-Query
   ```

2. **Build and run the application**:
   ```bash
   mvn spring-boot:run
   ```

3. **Run tests**:
   ```bash
   mvn test
   ```