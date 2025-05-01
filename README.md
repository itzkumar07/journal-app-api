# Journal App API

A simple REST API for managing personal journal entries built with Spring Boot and MongoDB.

## Features

- Add new journal entries
- View all entries
- Get entry by ID
- Update entry by ID
- Delete entry by ID
- Health check endpoint
- Connected to MongoDB Atlas (with optional local config)

## Technologies

- Java 21
- Spring Boot 3.4.4
- MongoDB
- Maven

## Run Locally

### Prerequisites

- Java 21+
- Maven installed
- MongoDB Atlas account or local MongoDB

### Clone & Setup

```bash
git clone https://github.com/your-username/journal-app-api.git
cd journal-app-api
```

### Configure `application.properties`

```properties
server.port=7901

# For MongoDB Atlas
spring.data.mongodb.uri=mongodb+srv://<username>:<password>@cluster0.mongodb.net/journaldb

# For Local MongoDB (optional)
# spring.data.mongodb.host=localhost
# spring.data.mongodb.port=27017
# spring.data.mongodb.database=journaldb
```

### Build & Run

```bash
mvn spring-boot:run
```

App runs at: `http://localhost:7901`

## API Endpoints

### Health Check

```
GET /health-check
```

### Journal Entry APIs

| Method | Endpoint           | Description            |
|--------|--------------------|------------------------|
| GET    | /journal           | Get all entries        |
| GET    | /journal/id/{id}   | Get entry by ID        |
| POST   | /journal           | Create new entry       |
| PUT    | /journal/id/{id}   | Update entry by ID     |
| DELETE | /journal/id/{id}   | Delete entry by ID     |

#### Sample JSON for Create/Update

```json
{
  "title": "My Day",
  "content": "Today was productive.",
  "date": "2025-05-01T10:00:00Z"
}
```

## Project Structure

```
src/
 └── main/
     └── java/
         └── com.bootcoding.journal_app_api/
             ├── controller
             ├── entity
             ├── repository
             ├── service
             └── JournalAppApiApplication.java
```

## License

This project is licensed under the MIT License.
