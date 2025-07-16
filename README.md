This is a backend REST API built using **Spring Boot** and **PostgreSQL** for managing library operations such as managing books, users, and book issuance/returns.

---

## 📆 Project Duration
**March 2025 – April 2025**  
**Contributor**: Solo Project (Individual contribution)

---

## 🧰 Tech Stack
- Java 17  
- Spring Boot  
- Spring Data JPA  
- PostgreSQL  
- Maven   
- Postman

---

## 🚀 Features
- CRUD operations for managing books and users
- Issue and return books with due date tracking
- Prevent duplicate book issuance
- Spring Boot layered architecture (Controller → Service → Repository)
- Input validation and global exception handling


https://github.com/NavyaNivas/LibraryManagement
  
Setup Instructions

1. **Clone the Repository**
   ```bash
   git clone https://github.com/NavyaNivas/LibraryManagement
   cd library-management-backend

2.Configure PostgreSQL

Create a PostgreSQL database named library_db

Update your application.properties:
spring.datasource.url=jdbc:postgresql://localhost:5432/library_db
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password
spring.jpa.hibernate.ddl-auto=update

3.Run the Application
mvn clean install
mvn spring-boot:run

