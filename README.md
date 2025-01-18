 # Formula 1 🚀

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

***While Creating spring boot project make sure to select maven and in dependencies (Spring data jpa, Spring web, lombok, mysql driver)***
### 1. MySql setup

1. create database name f1db
```bash
create database f1db
```

### 2. Configure `application.properties`
Update the application.properties file with your MySQL credentials:
```bash
spring.datasource.url=jdbc:mysql://localhost:3306/your-databasename
spring.datasource.username=your-username
spring.datasource.password=your-password
spring.jpa.show-sql=true
spring.jpa.generate-ddl=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

### 3.Build and Run
Use Maven to build and run the project:
```bash
  mvn clean install
  mvn spring-boot:run
```
### Postman
1. Make sure to select the `post` method
2. In the url provide:
   ```bash
   http://localhost:8080/teams/createTeam
   ```
3. Select `body` and format as `raw`
4. From the drop down menu select `Json`
5. Provide this within the body
   ```bash
   {
   "name": "Red Bull Racing",
   "headquarters": "Milton Keynes, UK",
   "budget": 450000000.00,
   "carModel": "RB20",
   "drivers": [
    {
      "name": "Max Verstappen",
      "nationality": "Dutch",
      "age": 27,
      "wins": 63,
      "championships": 4
    },
    {
      "name": "Sergio Perez",
      "nationality": "Mexican",
      "age": 34,
      "wins": 6,
      "championships": 0
    }
   ]
   }

## 📂 Project Structure

src\
├── main\
│   ├── java\
│   │   ├── com.f1.tracker.controller\
│   │   │   ├── DriverController.java            # Handles driver-related API requests\
│   │   │   ├── RaceController.java              # Handles race-related API requests\
│   │   │   ├── RaceResultController.java        # Handles race result-related API requests\
│   │   │   ├── TeamController.java              # Handles team-related API requests\
│   │   ├── com.f1.tracker.entity\
│   │   │   ├── DriverEntity.java            # Entity representing Driver table\
│   │   │   ├── RaceEntity.java              # Entity representing Race table\
│   │   │   ├── RaceResultEntity.java        # Entity representing Race Results table\
│   │   │   ├── TeamEntity.java              # Entity representing Team table\
│   │   ├── com.f1.tracker.service\
│   │   │   ├── DriverService.java           # Business logic for Driver\
│   │   │   ├── RaceService.java             # Business logic for Race\
│   │   │   ├── RaceResultService.java       # Business logic for Race Results\
│   │   │   ├── TeamService.java             # Business logic for Team\
│   │   ├── com.f1.tracker.repository\
│   │   │   ├── DriverRepository.java        # JPA Repository for Driver\
│   │   │   ├── RaceRepository.java          # JPA Repository for Race\
│   │   │   ├── RaceResultRepository.java    # JPA Repository for Race Results\
│   │   │   ├── TeamRepository.java          # JPA Repository for Team\
│   └── resources\
│       ├── application.properties           # Application configuration\
│       └── data.sql                        # Sample data for database initialization (if applicable)\
├── test\
│   ├── java\
│   │   ├── com.f1.tracker                 # Unit tests for various components\
├── pom.xml                                 # Maven build file containing project dependencies

##  🧭 API Endpoints

- **Drivers**\
GET /drivers - Get all drivers\
POST /drivers/createDriver - Add a new driver\
PUT /drivers/{id} - Update a driver\
DELETE /drivers/{id} - Delete a driver

- **Teams**\
GET /teams - Get all teams\
POST /teams/createTeam - Add a new team\
PUT /teams/{id} - Update a team\
DELETE /teams/{id} - Delete a team

- **Race**\
GET /races - Get all races\
POST /races/createRace - Add a new race\
PUT /races/{id} - Update a race\
DELETE /races/{id} - Delete a race

- **Results**\
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

## 💾 Database Result
1. This is the description of the database driver and teams which uses `@ManyToOne` and `@ManyToMany` relationship\
![f1_manager_desc](https://github.com/user-attachments/assets/3e201677-8f5c-483a-99e5-3e283b54a765)

2. As you can see the data is present in the database\
![f1_manager_data](https://github.com/user-attachments/assets/6f7dba09-2180-4acc-b74c-ba995f601350)

***Made with ❤️ using Java and Spring Boot.***


