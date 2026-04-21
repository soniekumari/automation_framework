# Automation Framework (UI + API)

This project is a hybrid automation framework developed to test both UI and API functionalities using a structured and maintainable approach.

---

## Tech Stack

- Java  
- Maven  
- TestNG  
- Playwright  
- Rest Assured  

---

## Project Structure


### automation_framework/
│<br>
├── src/<br>
│   ├── main/<br>
│   │   ├── java/<br>
│   │   │   ├── pages/<br>
│   │   │   ├── utils/<br>
│   │   │   ├── api/<br>
│   │   │<br>
│   │   └── resources/<br>
│   │       ├── config.properties<br>
│   │       ├── schema.json<br>
│   │<br>
│   └── test/<br>
│       ├── java/<br>
│       │   ├── ui/<br>
│       │   ├── api/<br>
│<br>
├── testng.xml<br>
├── pom.xml<br>
│<br>
├── .github/<br>
│   └── workflows/<br>
│       └── test.yml<br>


---


## Features

### UI Automation
- Playwright-based UI automation
- Page Object Model (POM) design
- Dynamic waits for stability
- Assertions for validation

### API Automation
- Rest Assured for API testing
- Authentication token handling
- Request chaining (data dependency)
- JSON schema validation

### Utilities
- Centralized config management using properties file
- Reusable helper methods

---

## Setup Instructions

### Clone the repository
git clone <your-repo-url>

### Install dependencies
mvn clean install

## Run Tests
### Run all tests
mvn test

## Run using TestNG suite
mvn test -DsuiteXmlFile=testng.xml

---
## Reporting

This framework uses Maven Surefire plugin for test execution reporting.

Reports are automatically generated after each run and stored in:

target/surefire-reports/

It includes:
- Test execution summary
- Passed/failed test cases
- Detailed logs for failures
