#  Stock Portfolio Monitoring App

A Spring Boot-based backend system that allows users to securely manage their stock portfolios, receive alerts, and track real-time performance with role-based access, reports, and scheduled updates.

---

##  Domain

Finance / Personal Investment Management

---

##  Objectives

- Enable users to register, authenticate, and securely manage multiple portfolios and stock holdings.
- Fetch real-time stock prices using third-party APIs like Yahoo Finance.
- Automatically update and cache prices using scheduled jobs for performance optimization.
- Allow users to set alerts for stock price thresholds and portfolio loss percentages.
- Trigger notifications via email when alerts are triggered using JavaMailSender.
- Calculate gain/loss for individual holdings and overall portfolio performance.
- Provide daily portfolio summaries and support export in PDF/Excel format.
- Enforce secure access using JWT authentication and role-based authorization (USER, ADMIN).


---

##  Tech Stack

| Layer           | Technology                         |
|----------------|-------------------------------------|
| Language        | Java                                |
| Framework       | Spring Boot, Spring Security        |
| Persistence     | Spring Data JPA                     |
| Authentication  | JWT (JSON Web Token)                |
| Database        | MySQL                               |
| Scheduling      | Spring Scheduler / Quartz           |
| API Client      | RestTemplate                        |
| Reporting       | Apache POI (Excel), iText (PDF)     |
| Build Tool      | Maven                               |

---

##  Key Modules

- User & Role Management
- Portfolio and Holding Management
- Real-Time Stock Price Fetching
- Alerts & Notifications
- Gain/Loss Calculation
- Reporting (PDF/Excel)

---

##  Roles & Access

| Role   | Access Description                             |
|--------|------------------------------------------------|
| USER   | Manage own portfolios, holdings, alerts        |
| ADMIN  | Manage users, all system data (optionally)     |

---

##  Entity Overview

### 1. User
- id, username, email, password, role
- One-to-Many with Portfolios and Alerts

### 2. Portfolio
- id, name, user
- One-to-Many with Holdings

### 3. Holding
- id, stockSymbol, quantity, buyPrice, portfolio

### 4. StockPriceCache
- stockSymbol (PK), currentPrice, lastUpdated

### 5. Alert
- id, stockSymbol, priceThreshold, portfolioLossPercentage, triggered, user

### 6. PortfolioReportLog 
- id, date, totalValue, totalGainLoss, portfolio

---

##  REST API Endpoints

###  AuthController
- POST `/api/auth/register`
- POST `/api/auth/login`

###  PortfolioController
- GET `/api/portfolios`
- POST `/api/portfolios`
- GET `/api/portfolios/{id}/holdings`

###  HoldingController
- POST `/api/holdings`
- PUT `/api/holdings/{id}`
- DELETE `/api/holdings/{id}`

###  AlertController
- POST `/api/alerts`
- GET `/api/alerts`
- PUT `/api/alerts/{id}`

###  ReportController
- GET `/api/reports/portfolio-summary`
- GET `/api/reports/export?type=pdf|excel`

---

##  Example Workflow

1. **User registers and logs in** to receive a JWT token for authenticated access.  
2. **User creates one or more portfolios** and adds stock holdings (e.g., stock symbol, quantity, buy price).  
3. **System fetches real-time stock prices** via scheduled jobs and caches them to improve performance.  
4. **Gain/Loss is calculated** automatically for each holding and the entire portfolio.  
5. **Alerts are evaluated**:
   - If a stock price crosses a set threshold or portfolio loss exceeds a defined percentage, the alert is triggered.
   - The system **sends an email notification** to the user using **JavaMailSender (JMS)**.
   - Alerts can also be logged internally for auditing or retry purposes.
6. **Reports are generated** summarizing the portfolio's status, which users can **export as PDF or Excel**.


---

##  ER Diagram

![ER Diagram](https://github.com/user-attachments/assets/f2d3dedc-974e-4328-96be-4ad878c4d989)



---

##  Class Diagram

![Class Diagram](https://github.com/user-attachments/assets/81cc88e3-56b2-4706-9bf0-3c7bab36ecac)

---

##  Sample Configuration (`application.properties`)

```properties
#Application
spring.application.name=stockportfoliomonitoringapp

server.port=8080

# MySQL Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/springboot_team_db
spring.datasource.username=your-mysql-username-here
spring.datasource.password=your-mysql-password-here

#JPA configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

#Swagger
springdoc.swagger-ui.path=/docs

#JSM
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your-email-here
spring.mail.password=your-app-password-here
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true

##  Suggested Project Structure

com.bridgelabz.stockportfoliomonitoringapp
│
├── config               # Security, JWT, Swagger
├── controller           # API controllers
├── dto                 # Data Transfer Objects
├── entity               # JPA entities
├── exception            # Custom exceptions
├── repository           # Spring Data JPA interfaces
├── scheduler            # Scheduled jobs (price fetching)
├── service              # Service layer interfaces
├── serviceimpl          # Implementations of services
├── util                 # Utility classes (email, calculator, export)
└── StockPortfolioApplication.java


---

##  Optional Enhancements

| Feature                 | Technology              |
|------------------------|-------------------------|
| Real-time updates       | WebSockets              |
| AI-based buy/sell advice| ML Model Integration    |
| Google Sheets sync      | Sheets API              |
| Mobile-optimized APIs   | REST Best Practices     |

---

##  Suggested Sprints

| Day  | Deliverables                                         |
|------|------------------------------------------------------|
| 1    | Auth module, roles, JWT, DB config                   |
| 2    | Portfolio & holdings module                          |
| 3    | Price fetcher scheduler, cache setup                 |
| 4    | Alerts system with email/log notifications           |
| 5    | Reporting module, Excel/PDF export                   |
| 6    | Testing, documentation, Swagger UI integration       |

---

##  How to Run the Project

###  Prerequisites

- Java 17+
- Maven
- MySQL
- Swagger UI
- JMS

###  Steps

```bash
# Clone the repository
git clone https://github.com/your-username/stock-portfolio-app.git
cd stock-portfolio-app

# Configure DB in application.properties

# Build and run
./mvnw clean install
./mvnw spring-boot:run

## API Documentation
Visit: http://localhost:8080/swagger-ui.html

## Authors
- Siripurapu Papinaidu – Project Lead & Alert Module
- Rohan R - Holdings Module and Testing
- Mohanraj V - Portfolio Module and Testing
- Karthik Singaram.B - User Module and Testing
- Vrutika Panikar - Portfolio Repot Module and Testing
- Janhvi Jaiswal - Portfolio Module, Holding Module and Testing

## Contributors
Thanks to all contributors and testers involved in shaping this project!


