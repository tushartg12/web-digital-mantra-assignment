**README.md**

# Web Digital Mantra Assignment - Spring Boot CRUD Application for Product Management

This Spring Boot application provides basic CRUD (Create, Read, Update, Delete) operations for managing products. It uses Spring Data JPA to interact with the database and provides a RESTful API for performing these operations.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Java 8 or higher installed on your system.
- Maven installed to manage project dependencies.
- MySql 8.0.34 installed on the system.

## Getting Started

To get the project up and running, follow these steps:

1. **Extract the zip file:**
   
   Extract the zip file provided to you

2. **Database Configuration:**

   Update `application.properties` with your database configuration:

   ```properties
   spring.datasource.url=jdbc:mysql://<database-host>:<port>/<database-name>
   spring.datasource.username=<database-username>
   spring.datasource.password=<database-password>
   ```

3. **Build and Run:**

   Use Maven to build and run the application:

   ```bash
   mvn spring-boot:run
   ```

   The application will start on `http://localhost:8080`.

## API Endpoints

- **Get All Products:**
  
  `GET /products`

- **Get Product by ID:**

  `GET /products/{productId}`

- **Create a Product:**

  `POST /products`

  Request Body:
  ```json
  {
    "name": "Product Name",
    "about": "Product Description",
    "price": 29.99,
    "quantity": 100
  }
  ```

- **Update a Product:**

  `PUT /products/{productId}`

  Request Body:
  ```json
  {
    "name": "Product Name",
    "about": "Product Description",
    "price": 29.99,
    "quantity": 50
  }
  ```

- **Delete a Product:**

  `DELETE /products/{productId}`

## Sample Usage

### Get All Products

```http
GET /products
```

### Get Product by ID

```http
GET /products/{productId}
```

### Create a Product

```http
POST /products
Content-Type: application/json

{
  "name": "Product Name",
  "about": "Product Description",
  "price": 29.99,
  "quantity": 100
}
```

### Update a Product

```http
PUT /products/{productId}
Content-Type: application/json

{
  "name": "Product Name",
  "about": "Product Description",
  "price": 29.99,
  "quantity": 100
}
```

### Delete a Product

```http
DELETE /products/{productId}
```

## Technologies Used

- **Spring Boot:** Framework for creating stand-alone, production-grade Spring-based applications.
- **Spring Data JPA:** Part of the larger Spring Data project and makes it easy to implement JPA-based repositories.
- **JUnit:** Unit Testing.
- **MySQL:** Relational database management system.

**Happy Coding!**