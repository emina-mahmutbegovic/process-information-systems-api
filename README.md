# TV Program Application API

This is a Spring Boot application for managing TV programs, including entities like TV shows, genres, episodes, editors, hosts, guests, and the date and time of each show. The API endpoints allow you to perform CRUD operations on these entities.

## Postman Collection

For ease of testing, you can use the provided Postman collection. Import the collection JSON file `TV_Program_Application.postman_collection.json` into Postman to have quick access to the API endpoints.

## Entities

### 1. Emisija

- **Create Emisija**
    - Endpoint: `POST /api/emisije`
    - Create a new TV program.

- **Get All Emisije**
    - Endpoint: `GET /api/emisije`
    - Retrieve a list of all TV programs.

- **Get Emisija by ID**
    - Endpoint: `GET /api/emisije/{id}`
    - Retrieve details of a specific TV program by ID.

- **Update Emisija by ID**
    - Endpoint: `PUT /api/emisije/{id}`
    - Update details of a specific TV program by ID.

- **Delete Emisija by ID**
    - Endpoint: `DELETE /api/emisije/{id}`
    - Delete a TV program by ID.

### 2. Epizoda

- **Create Epizoda**
    - Endpoint: `POST /api/epizode`
    - Create a new episode.

- **Get All Epizode**
    - Endpoint: `GET /api/epizode`
    - Retrieve a list of all episodes.

- **Get Epizoda by ID**
    - Endpoint: `GET /api/epizode/{id}`
    - Retrieve details of a specific episode by ID.

- **Update Epizoda by ID**
    - Endpoint: `PUT /api/epizode/{id}`
    - Update details of a specific episode by ID.

- **Delete Epizoda by ID**
    - Endpoint: `DELETE /api/epizode/{id}`
    - Delete an episode by ID.

### 3. Gost

- **Create Gost**
    - Endpoint: `POST /api/gosti`
    - Create a new guest.

- **Get All Gosti**
    - Endpoint: `GET /api/gosti`
    - Retrieve a list of all guests.

- **Get Gost by ID**
    - Endpoint: `GET /api/gosti/{id}`
    - Retrieve details of a specific guest by ID.

- **Update Gost by ID**
    - Endpoint: `PUT /api/gosti/{id}`
    - Update details of a specific guest by ID.

- **Delete Gost by ID**
    - Endpoint: `DELETE /api/gosti/{id}`
    - Delete a guest by ID.

### 4. Termin Emitovanja

- **Create Termin Emitovanja**
    - Endpoint: `POST /api/termini-emitovanja`
    - Schedule a new broadcasting time for an episode.

- **Get All Termini Emitovanja**
    - Endpoint: `GET /api/termini-emitovanja`
    - Retrieve a list of all broadcasting schedules.

- **Get Termin Emitovanja by Episode ID**
    - Endpoint: `GET /api/termini-emitovanja/{episodeId}`
    - Retrieve broadcasting details for a specific episode.

- **Update Termin Emitovanja by Episode ID and Start Time**
    - Endpoint: `PUT /api/termini-emitovanja`
    - Params: idEpizode, vrijemePocetka
    - Update broadcasting details for a specific episode.

- **Delete Termin Emitovanja by Episode ID and Start Time**
    - Endpoint: `DELETE /api/termini-emitovanja`
    - Params: idEpizode, vrijemePocetka
    - Delete broadcasting details for a specific episode.

### 5. Urednik

- **Create Urednik**
    - Endpoint: `POST /api/urednici`
    - Add a new editor.

- **Get All Urednici**
    - Endpoint: `GET /api/urednici`
    - Retrieve a list of all editors.

- **Get Urednik by ID**
    - Endpoint: `GET /api/urednici/{id}`
    - Retrieve details of a specific editor by ID.

- **Update Urednik by ID**
    - Endpoint: `PUT /api/urednici/{id}`
    - Update details of a specific editor by ID.

- **Delete Urednik by ID**
    - Endpoint: `DELETE /api/urednici/{id}`
    - Delete an editor by ID.

### 6. Voditelj

- **Create Voditelj**
    - Endpoint: `POST /api/voditelji`
    - Add a new host.

- **Get All Voditelji**
    - Endpoint: `GET /api/voditelji`
    - Retrieve a list of all hosts.

- **Get Voditelj by ID**
    - Endpoint: `GET /api/voditelji/{id}`
    - Retrieve details of a specific host by ID.

- **Update Voditelj by ID**
    - Endpoint: `PUT /api/voditelji/{id}`
    - Update details of a specific host by ID.

- **Delete Voditelj by ID**
    - Endpoint: `DELETE /api/voditelji/{id}`
    - Delete a host by ID.

### 7. Vrsta Emisije

- **Create Vrsta Emisije**
    - Endpoint: `POST /api/vrsta-emisije`
    - Add a new type of TV program.

- **Get All Vrste Emisije**
    - Endpoint: `GET /api/vrsta-emisije`
    - Retrieve a list of all types of TV programs.

- **Get Vrsta Emisije by ID**
    - Endpoint: `GET /api/vrsta-emisije/{id}`
    - Retrieve details of a specific type of TV program by ID.

- **Update Vrsta Emisije by ID**
    - Endpoint: `PUT /api/vrsta-emisije/{id}`
    - Update details of a specific type of TV program by ID.

- **Delete Vrsta Emisije by ID**
    - Endpoint: `DELETE /api/vrsta-emisije/{id}`
    - Delete a type of TV program by ID.

## Prerequisites
Before you begin, ensure you have met the following requirements:

### Gradle
- You have installed the latest version of [Gradle](https://gradle.org/guides/#getting-started)
### Docker
- You have installed the latest version of [Docker](https://docs.docker.com/get-docker/).

## How to Run

1. Clone the repository.

```bash
git clone https://github.com/emina-mahmutbegovic/process-information-systems-api.git
cd process-information-systems-api 
```

2. Setup Docker
```bash
docker compose up -d
```
This command will create database with all tables and seed database with dummy data provided in `resources/db.liquibase/test-data`

3. Build the application

MAC/Linux users:
```bash
./gradlew build
```

Windows users
```bash
gradlew build
```

4. Run the application

MAC/Linux users:
```bash
./gradlew bootRun
```

Windows users:
```bash
gradlew bootRun
```

The application will be accessible at `http://localhost:8080`.

## Technologies Used

- **Spring Boot**
- **Java**
- **Spring Data JPA**
- **PostgreSQL**
- **Liquibase**
- **Docker**

## Author

- Emina Mahmutbegovic

