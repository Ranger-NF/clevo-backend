# Clevo API

Clevo is an innovative platform for streamlining waste collection, enhancing citizen participation, and providing valuable insights for authorities. This README provides an overview of the Clevo API, including its architecture, technology stack, and key features.

-----

## ⚙️ Architecture and Technology Stack

The Clevo API is built with a **Java Spring Boot** backend, providing a robust framework for creating RESTful APIs. It utilizes a **MySQL** database for all data storage. The API is designed with clear roles for different users: Citizens, Recyclers, and Authorities, each with specific endpoints to manage their tasks.

| Component | Technology | Description |
| :--- | :--- | :--- |
| **Backend** | **Java** with **Spring Boot** | A robust framework for building RESTful APIs. It simplifies the creation of stand-alone, production-grade applications. |
| **Database** | **MySQL** | A powerful and widely used open-source relational database for storing all application data. |
| **API Documentation** | **OpenAPI/Swagger** | Used to define and document the API endpoints, making it easy for developers to understand and integrate with the platform. |

-----

## 🚀 Getting Started

### Prerequisites

* **Java 17 or higher**
* **Maven**
* **MySQL**

### Local Development

1.  **Clone the repository:**
    ```bash
    git clone [repository_url]
    cd clevo-api
    ```
2.  **Set up the database:**
    Create a MySQL database and update the connection details in `src/main/resources/application.properties`.
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/clevo_db
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    ```
3.  **Build the project:**
    ```bash
    mvn clean install
    ```
4.  **Run the application:**
    ```bash
    mvn spring-boot:run
    ```

The API will be accessible at `http://localhost:8080`.

-----

## 💡 Key API Endpoints

The API is organized by user roles: **Citizen**, **Recycler**, and **Authority**. Below are some of the core endpoints.

### Citizen Endpoints 🧑‍🌾

* **`POST /api/citizen/book`**: Book a pickup slot for waste collection.
* **`GET /api/citizen/slots`**: View available pickup slots.
* **`GET /api/citizen/bookings`**: Get a list of the user's past and pending bookings.
* **`GET /api/citizen/rewards/total`**: Check total accumulated eco-points.
* **`GET /api/citizen/rewards/available`**: View available rewards to redeem.
* **`POST /api/citizen/rewards/redeem`**: Redeem a reward using eco-points.

### Recycler Endpoints ♻️

* **`POST /api/recycler/slots`**: Create a new pickup slot.
* **`PUT /api/recycler/slots/{id}`**: Update an existing pickup slot.
* **`DELETE /api/recycler/slots/{id}`**: Delete a pickup slot.
* **`GET /api/recycler/slots/{recyclerId}`**: View all slots created by a specific recycler.
* **`GET /api/recycler/bookings/ward/{wardId}`**: Get all bookings within a specific ward.
* **`PUT /api/recycler/bookings/{bookingId}/status`**: Update the status of a booking (e.g., to 'COLLECTED').

### Authority Endpoints 🏛️

* **`GET /api/authority/users`**: List all users registered on the platform.
* **`PUT /api/authority/users/{id}/deactivate`**: Deactivate a user account.
* **`PUT /api/authority/users/{id}/activate`**: Activate a user account.
* **`POST /api/authority/wards`**: Add a new ward.
* **`GET /api/authority/waste-categories`**: List all defined waste categories.
* **`POST /api/authority/waste-categories`**: Add a new waste category.
* **`GET /api/authority/dashboard/waste-trend`**: Get waste collection trends over time.
* **`GET /api/authority/dashboard/waste-by-type`**: Get waste breakdown by category.
* **`GET /api/authority/dashboard/waste-by-region`**: Get waste collection data by geographical region (ward).
* **`GET /api/authority/dashboard/eco-points-distribution`**: Analyze eco-points distributed among citizens.