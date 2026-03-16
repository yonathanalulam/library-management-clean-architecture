
# Library Management System

A simple Library Management System built with Spring Boot, demonstrating the implementation of Clean Architecture, the CQRS pattern, and the Factory pattern.

## Architecture Overview

This project is strictly divided into four layers to enforce the Dependency Rule:

* **Domain:** Contains the core business logic and entities (Book). Uses the Factory Pattern (BookFactory) to encapsulate the creation of new books.
* **Application:** Contains the business use cases. Implements the CQRS pattern by separating read operations (GetAllBooksQuery, GetBookByIdQuery) from write operations (AddBookCommand, BorrowBookCommand).
* **Infrastructure:** Contains framework-specific implementations, such as the InMemoryBookRepository for data persistence.
* **Presentation:** Contains the REST API controllers (BookController) that handle HTTP requests and route them to the appropriate application handlers.

## Technologies Used

* Java
* Spring Boot
* Gradle

## Running the Application

./gradlew bootRun

## API Endpoints

### 1. Add a Book (Command)
curl -X POST -H "Content-Type: application/json" -d '{"title":"Dune", "author":"Frank Herbert"}' http://localhost:8080/books

### 2. Get All Books (Query)
curl http://localhost:8080/books

### 3. Borrow a Book (Command)
curl -X POST http://localhost:8080/books/{id}/borrow

### 4. Get a Book by ID (Query)
curl http://localhost:8080/books/{id}