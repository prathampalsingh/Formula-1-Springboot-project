 # Formula 1 Tracker 🚀

A Spring Boot application to manage and track Formula 1 drivers, races, teams, and results. This project leverages modern Java development tools and libraries, such as Spring Boot, JPA, Hibernate, Lombok, and MySQL, to create a RESTful API that seamlessly interacts with the database.

---

## 📜 Features
- **Drivers**: Manage driver profiles including details like name, nationality, age, wins, and championships.
- **Teams**: Create and manage F1 teams, linking drivers and managing their budgets and car models.
- **Races**: Keep track of race details such as name, track, date, and results.
- **Results**: Record and retrieve race results, including driver rankings.

---

## 🛠️ Tech Stack
- **Backend**: Java with Spring Boot
- **Database**: MySQL (with MySQL Driver)
- **ORM**: JPA/Hibernate
- **Utilities**: Lombok for cleaner code
- **Testing**: Postman for API testing

---

## 🚀 Getting Started
### 1. Configure the Database
Update the application.properties file with your MySQL credentials:

spring.datasource.url=jdbc:mysql://localhost:3306/f1_tracker\
spring.datasource.username=your-username\
spring.datasource.password=your-password\
spring.jpa.hibernate.ddl-auto=update


### 2.Build and Run

Use Maven to build and run the project:

```bash
  mvn clean install
  mvn spring-boot:run
```
Access the API at: http://localhost:8080

## 📂 Project Structure

src\
├── main\
│   ├── java\
│   │   ├── com.f1.tracker.controller\
│   │   │   ├── DriverController.java   <div dir="rtl">         # Handles driver-related API requests\
│   │   │   ├── RaceController.java       <div dir="rtl">       # Handles race-related API requests\
│   │   │   ├── RaceResultController.java       <div dir="rtl"> # Handles race result-related API requests\
│   │   │   ├── TeamController.java          <div dir="rtl">    # Handles team-related API requests\
│   │   ├── com.f1.tracker.entity\
│   │   │   ├── DriverEntity.java         <div dir="rtl">   # Entity representing Driver table\
│   │   │   ├── RaceEntity.java           <div dir="rtl">   # Entity representing Race table\
│   │   │   ├── RaceResultEntity.java      <div dir="rtl">  # Entity representing Race Results table\
│   │   │   ├── TeamEntity.java           <div dir="rtl">   # Entity representing Team table\
│   │   ├── com.f1.tracker.service\
│   │   │   ├── DriverService.java          <div dir="rtl"> # Business logic for Driver\
│   │   │   ├── RaceService.java          <div dir="rtl">   # Business logic for Race\
│   │   │   ├── RaceResultService.java     <div dir="rtl">  # Business logic for Race Results\
│   │   │   ├── TeamService.java           <div dir="rtl">  # Business logic for Team\
│   │   ├── com.f1.tracker.repository\
│   │   │   ├── DriverRepository.java       <div dir="rtl"> # JPA Repository for Driver\
│   │   │   ├── RaceRepository.java         <div dir="rtl"> # JPA Repository for Race\
│   │   │   ├── RaceResultRepository.java   <div dir="rtl"> # JPA Repository for Race Results\
│   │   │   ├── TeamRepository.java         <div dir="rtl"> # JPA Repository for Team\
│   └── resources\
│       ├── application.properties          <div dir="rtl"> # Application configuration\
│       └── data.sql                      <div dir="rtl">   # Sample data for database initialization (if applicable)\
├── test\
│   ├── java\
│   │   ├── com.f1.tracker                 <div dir="rtl">  # Unit tests for various components\
├── pom.xml                                 <div dir="rtl"> # Maven build file containing project dependencies

##  🧭 API Endpoints

- **Drivers**
GET /drivers - Get all drivers\
POST /drivers/createDriver - Add a new driver\
PUT /drivers/{id} - Update a driver\
DELETE /drivers/{id} - Delete a driver
- **Teams**
GET /teams - Get all teams\
POST /teams/createTeam - Add a new team\
PUT /teams/{id} - Update a team\
DELETE /teams/{id} - Delete a team
- **Race**
GET /races - Get all races\
POST /races/createRace - Add a new race\
PUT /races/{id} - Update a race\
DELETE /races/{id} - Delete a race
- **Results**
GET /results - Get all race results\
POST /results/createRaceResult - Add a new result\
PUT /results/{id} - Update a result\
DELETE /results/{id} - Delete a result

## ✨ Highlights

**Spring Boot Framework**: Simplifies application setup and development.\
**JPA and Hibernate**: Efficient ORM for database interactions.\
**Lombok**: Reduces boilerplate code.**\
**MySQL Driver**: Seamless database connectivity.\
**Postman**: Comprehensive API testing.

***Made with ❤️ using Java and Spring Boot.***


