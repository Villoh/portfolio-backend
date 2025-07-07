# Portfolio Backend

This is the backend service for the Portfolio application. It is built with Java, Spring Boot, and follows a hexagonal (ports and adapters) architecture. The backend exposes REST, WebSocket, SSE, GraphQL, and gRPC APIs for interacting with portfolio data and features.

## ✅ CI Status

![Build](https://github.com/Villoh/portfolio-backend/actions/workflows/build.yml/badge.svg)
![Tests](https://github.com/Villoh/portfolio-backend/actions/workflows/test.yml/badge.svg)

## Features
- **About Me**: Localized personal information endpoint
- **Contact**: Send contact messages via email
- **Greetings**: Personalized greetings via REST, WebSocket, GraphQL, and gRPC
- **Metrics**: Live system and JVM metrics via SSE
- **Voting**: Real-time voting for programming languages via SSE

## Technologies
- Java 21
- Spring Boot 3
- MapStruct
- Reactor (WebFlux)
- gRPC
- GraphQL
- JUnit 5 & Mockito (testing)

## Project Structure
- `src/main/java` - Application source code
  - `application` - Business logic and service interfaces
  - `domain` - Domain models and ports
  - `infrastructure` - Adapters for REST, WebSocket, SSE, GraphQL, gRPC, email, metrics, rendering, etc.
- `src/main/resources` - Configuration, templates, and static assets
- `src/test/java` - Unit and integration tests

## Running the App

### Prerequisites
- Java 21+
- Gradle (or use the provided `gradlew` script)

### Build and Run
```sh
./gradlew build
./gradlew bootRun
```

### Docker
You can build and run the app with Docker:
```sh
docker build -t portfolio-backend .
docker run -p 8080:8080 portfolio-backend
```

Or use Docker Compose:
```sh
docker-compose up --build
```

## API Endpoints
- REST: `/api/about-me`, `/api/contact`, `/api/greetings/{name}`
- SSE: `/api/metrics/stream`, `/api/vote/stream`
- WebSocket: `/ws/greetings`
- GraphQL: `/graphql`
- gRPC: see `greeting.proto`

## Configuration
- Edit `src/main/resources/application.yml` for app settings
- Email, metrics, and template settings are configurable

## Testing
Run all tests with:
```sh
./gradlew test
```

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
