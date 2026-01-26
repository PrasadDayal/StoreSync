# StoreSync – Inventory Management System

StoreSync is a web-based inventory management system that enables users to securely manage products and monitor stock levels in real time. It provides a user-specific dashboard with inventory summaries and visual insights to support efficient stock control and decision-making.

---

## Project Description

StoreSync is designed to help users manage inventory efficiently by allowing them to add, view, and track products securely. Each user can access only their own inventory data. The system highlights low-stock items and provides a visual dashboard for better inventory analysis. It is built as a full-stack Java web application using Spring Boot and Thymeleaf.

---

## Features

- User authentication and authorization using Spring Security
- User-specific product management
- Add, view, and delete products
- Low stock and OK stock indicators
- Interactive dashboard with inventory summary
- Chart-based stock visualization
- Secure logout functionality

---

## Technologies Used

- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- Thymeleaf
- MySQL
- HTML, CSS, JavaScript
- Maven

---

## Project Structure

src/main/java/com/example/Inventory
│
├── config
│ └── SecurityConfig.java
│
├── controller
│ ├── AuthController.java
│ ├── DashboardController.java
│ ├── ProductController.java
│ └── LoginController.java
│
├── model
│ ├── User.java
│ └── Product.java
│
├── repository
│ ├── UserRepository.java
│ └── ProductRepository.java
│
├── service
│ ├── UserService.java
│ ├── ProductService.java
│ └── CustomUserDetailsService.java
│
└── InventoryApplication.java


---

## Application URLs

| Feature       | URL              |
|---------------|------------------|
| Login         | /login           |
| Register      | /register        |
| Dashboard     | /dashboard       |
| Products      | /products        |
| Add Product   | /products/add    |
| Logout        | /logout          |

---

## How to Run the Project

1. Download or clone the project repository.
2. Create a MySQL database.
3. Update database credentials in `application.properties`.
4. Run the application using Maven:


5. Open your browser and navigate to:
http://localhost:8082/login


---

## File Upload Information

All project files are uploaded together as a single compressed ZIP file. This ensures the complete project structure, source code, and resources are preserved and can be easily reviewed, executed, and evaluated.

---

## Author

Prasad Dayal
BE – Computer Engineering  

---

## License

This project is developed for educational and academic purposes only.

