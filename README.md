# User Notification Preference & Delivery API

## Project Overview
Backend application to manage user notification preferences and simulate notification delivery using EMAIL, SMS, and PUSH channels.

---

# Technologies Used

- Java 21
- Spring Boot
- Spring Data JPA
- MySQL
- Lombok
- Maven

---

# Features

## User Management
- Create User
- Get User By ID
- Get All Users

## Notification Preferences
- Enable/Disable EMAIL, SMS, PUSH
- Update Preferences
- Fetch Preferences

## Notification Delivery
- Send Notifications
- Validate Enabled Channels
- Store Notification History

## Notification History
- Get Notifications By User
- Get Notifications By Status
- Get Notifications By Type

---

# Business Rules

- Disabled channels should not receive notifications
- Every notification attempt is stored
- Default notification preferences are disabled

---

# API Endpoints

## User APIs

POST   /users  
GET    /users/{id}  
GET    /users  

---

## Preference APIs

PUT    /preferences/{userId}  
GET    /preferences/{userId}  

---

## Notification APIs

POST   /notifications/send  
GET    /notifications/user/{userId}  
GET    /notifications/status/{status}  
GET    /notifications/type/{type}  

---


# Database Configuration

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/user_notification_app
spring.datasource.username=root
spring.datasource.password=root

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

---
#How To Run Application:

Step 1: Clone Project
git clone <repository-url>
Step 2: Open Project

#Open project in:

STS
Eclipse

Configure Database

#Create MySQL database:

CREATE DATABASE user_notification_app;

Update database credentials in:

src/main/resources/application.properties
Step 4: Install Maven Dependencies
mvn clean install

#Run Application

Run main class:

UserNotificationPreferenceDeliveryApiApplication.java

---
#Swagger Api

http://localhost:8080/swagger-ui/index.html

#Author

Mahesh kapilavai