# 🏪 StoreSync - Inventory Management System

StoreSync is a Spring Boot-based Inventory Management System designed to help businesses efficiently manage products, suppliers, and stock levels. It includes authentication, dashboard insights, and demand prediction features.

## 🚀 Features

* **🔐 User Authentication & Authorization:** Secured via Spring Security.
* **📦 Product Management:** Add, Update, Delete, View inventory items.
* **🧑‍💼 Supplier Management:** Keep track of supplier data and contacts.
* **📊 Dashboard:** Real-time overview of stock and analytics.
* **⚠️ Low Stock Alerts:** Automated notifications when stock drops below thresholds.
* **📧 Email Notifications:** Timely alerts and reports.
* **📈 Demand Prediction System:** Forecasting logic to anticipate inventory needs.
* **👥 Role-based Access Control:** Restrict actions based on user permissions.

## 🛠️ Tech Stack

* **Backend:** Java, Spring Boot, Spring Security
* **Frontend:** HTML, CSS, JavaScript (Thymeleaf templates)
* **Database:** Configured via `application.properties` (MySQL recommended)
* **Build Tool:** Maven

## 📁 Project Structure

```text
StoreSync/
│── src/main/java/com/example/Inventory
│   ├── config/           # Security & Mail Configuration
│   ├── controller/       # MVC Controllers
│   ├── model/            # Entity Classes
│   ├── repository/       # JPA Repositories
│   ├── service/          # Business Logic
│   ├── util/             # Utility Classes
│
│── src/main/resources/
│   ├── templates/        # HTML Views (Thymeleaf)
│   ├── static/           # CSS, JS, Images
│   ├── application.properties
│
│── pom.xml               # Maven Dependencies
```

### 1. Clone the Repository
```bash
git clone [https://github.com/your-username/storesync.git](https://github.com/your-username/storesync.git)
cd storesync
```

### 2. Configure Database
Edit `src/main/resources/application.properties` to match your database credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/storesync
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

### 3. Run the Application
Using the Maven wrapper:
```bash
./mvnw spring-boot:run
```

Or with a local Maven installation:
```bash
mvn spring-boot:run
```

### 4. Access the App
Open your browser and navigate to:
```text
http://localhost:8080
```

## 🔑 Default Functional Modules

* **Authentication:** Login/Register system
* **Dashboard:** Overview of stock and analytics
* **Products:** Manage inventory items
* **Suppliers:** Manage supplier data
* **Alerts:** Low stock notifications
* **Prediction:** Demand forecasting logic

## 📦 Build JAR

To build an executable JAR file, run:
```bash
mvn clean package
```
Run the compiled JAR:
```bash
java -jar target/Inventory-0.0.1-SNAPSHOT.jar
```

## 🧠 Future Improvements

- [ ] REST API support
- [ ] Mobile app integration
- [ ] Advanced analytics (AI/ML)
- [ ] Multi-store support
- [ ] Cloud deployment

## 📄 License

This project is licensed under the MIT License.

## 👨‍💻 Author

Developed by **[Prasad Dayal]**

## ⭐ Support

If you like this project, give it a ⭐ on GitHub!
