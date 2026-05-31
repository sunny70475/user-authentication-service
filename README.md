# User Authentication Service

A production-ready RESTful microservice built with **Spring Boot 3** that handles user registration, login, and token validation with BCrypt password hashing and centralized exception handling.

---

## Features

- **Sign Up** — Register a new user with email uniqueness check and BCrypt-hashed password storage
- **Login** — Authenticate with email and password using secure hash comparison
- **Token Validation** — Endpoint stub ready for JWT integration
- **Global Exception Handling** — Centralized error responses via `@RestControllerAdvice`
- **Role-based User Model** — Users support multiple roles via a many-to-many relationship
- **Environment-based Config** — No hardcoded secrets; credentials loaded from environment variables
- **Docker Support** — MySQL spun up instantly via Docker Compose

---

## Tech Stack

| Layer | Technology |
|---|---|
| Framework | Spring Boot 3.5.3 |
| Language | Java 17 |
| Security | Spring Security + BCrypt |
| Database | MySQL 8 |
| ORM | Spring Data JPA / Hibernate |
| Containerization | Docker Compose |
| Build Tool | Maven |
| Boilerplate | Lombok |

---

## Project Structure

```
src/main/java/com/example/userauthenticationservice/
├── configurations/
│   └── AuthConfig.java           # BCryptPasswordEncoder + SecurityFilterChain beans
├── controllers/
│   ├── AuthController.java       # REST endpoints
│   └── ControllerAdvisor.java    # Global exception handler
├── dtos/
│   ├── SignUpRequestDto.java
│   ├── LoginRequestDto.java
│   ├── ValidateTokenRequestDto.java
│   └── UserDto.java
├── exceptions/
│   ├── UserAlreadyExistsException.java
│   ├── UserNotSignedUpException.java
│   └── PasswordMismatchException.java
├── models/
│   ├── BaseModel.java            # id, createdAt, lastUpdatedAt, status
│   ├── User.java
│   ├── Role.java
│   └── Status.java
├── repositories/
│   └── UserRepo.java
└── services/
    ├── IAuthService.java
    └── AuthService.java
```

---

## Getting Started

### Prerequisites

- Java 17+
- Maven
- Docker & Docker Compose

### 1. Clone the repository

```bash
git clone https://github.com/sunny70475/user-authentication-service.git
cd user-authentication-service
```

### 2. Set up environment variables

Copy the example env file and fill in your values:

```bash
cp .env.example .env
```

Edit `.env`:

```env
DB_URL=jdbc:mysql://localhost:3306/userauthenticationservice
DB_USERNAME=root
DB_PASSWORD=your_password_here
DB_NAME=userauthenticationservice
```

### 3. Start MySQL with Docker

```bash
docker compose up -d
```

### 4. Run the application

**Using Maven:**
```bash
./mvnw spring-boot:run
```

**With env vars inline (PowerShell):**
```powershell
$env:DB_PASSWORD="your_password"; ./mvnw spring-boot:run
```

**IntelliJ:** `Run > Edit Configurations > Environment Variables` → add `DB_PASSWORD=your_password`

The service starts on `http://localhost:8080`.

---

## API Reference

Base URL: `http://localhost:8080`

### Sign Up
```
POST /auth/signup
```
```json
{
  "name": "Sunny",
  "email": "sunny@example.com",
  "password": "Secret@123",
  "phoneNumber": "9876543210"
}
```
**Response `201 Created`:**
```json
{
  "id": 1,
  "name": "Sunny",
  "email": "sunny@example.com"
}
```

---

### Login
```
POST /auth/login
```
```json
{
  "email": "sunny@example.com",
  "password": "Secret@123"
}
```
**Response `200 OK`:**
```json
{
  "id": 1,
  "name": "Sunny",
  "email": "sunny@example.com"
}
```

---

### Validate Token *(coming soon)*
```
POST /auth/validateToken
```
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "userId": 1
}
```

---

## Error Handling

All errors return a `400 Bad Request` with a plain message:

| Scenario | Message |
|---|---|
| Email already registered | `Please login directly` |
| Email not found on login | `Please create your account first` |
| Wrong password | `Passwords didn't match` |

---

## Security

- Passwords are **never stored in plain text** — BCrypt hashing is applied before persistence
- Secrets are loaded from **environment variables**, never hardcoded
- `application.properties` and `.env` are excluded from version control via `.gitignore`

---

## Roadmap

- [ ] JWT token generation on login
- [ ] Token validation implementation
- [ ] Logout endpoint
- [ ] Forget password flow
- [ ] Refresh token support

---

## Author

**Sunny** — [GitHub](https://github.com/sunny70475)
