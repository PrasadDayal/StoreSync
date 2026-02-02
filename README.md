# StoreSync – Inventory Management System

## Problem Statement
Small businesses often rely on manual or poorly structured systems to manage inventory, leading to stock mismanagement, lack of visibility, and operational inefficiencies.

## Solution Overview
StoreSync is a backend-driven inventory management system built using Spring Boot that allows businesses to manage products, suppliers, users, and stock levels with secure role-based access.

The system exposes RESTful APIs and provides a dashboard for real-time inventory monitoring.

## Tech Stack
- Java
- Spring Boot
- Spring Data JPA
- MySQL
- HTML, CSS, JavaScript

## Features
- Product and supplier management (CRUD operations)
- Role-based access control (Admin / Staff)
- Real-time inventory dashboard
- Secure backend APIs
- Scalable relational database design

## System Architecture
- Controller layer handles REST API requests
- Service layer contains business logic
- Repository layer manages database interactions using JPA
- MySQL used for persistent data storage

## Database Design
- Normalized tables for users, products, suppliers, and inventory
- Foreign key relationships to maintain data integrity

## Setup Instructions
1. Clone the repository  
   `git clone https://github.com/PrasadDayal/StoreSync.git`

2. Configure MySQL database and update credentials in `application.properties`

3. Run the application  
   `mvn spring-boot:run`

4. Access APIs using Postman or frontend UI

## Future Enhancements
- JWT-based authentication
- Sales analytics and reporting
- Demand prediction module

## Screenshots
(Add application screenshots here)
