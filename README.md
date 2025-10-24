# Java Selenium TestNG Framework

This project contains a basic Selenium + TestNG automation framework built using the Page Object Model (POM) pattern. The first
sample test covers a successful login to [Sauce Demo](https://www.saucedemo.com/).

## Tech stack
- Java 11
- Maven
- Selenium 4.20.0
- TestNG 7.9.0
- WebDriverManager 5.8.0

## Project structure
```
src
├── main
│   └── java
│       └── com
│           └── saucedemo
│               └── pages
│                   ├── BasePage.java
│                   ├── InventoryPage.java
│                   └── LoginPage.java
└── test
    └── java
        └── com
            └── saucedemo
                ├── base
                │   └── BaseTest.java
                └── tests
                    └── LoginTest.java
```

## Getting started
1. Ensure the following tools are available on your machine:
   - Java 11 or newer
   - Maven 3.8+
   - Google Chrome (the tests use headless Chrome)
2. Install project dependencies and compile the code:
   ```bash
   mvn clean compile
   ```

## Running the tests
- Execute the full suite with Maven:
  ```bash
  mvn clean test
  ```
- Run the TestNG suite file explicitly (useful when adding more suites):
  ```bash
  mvn -Dsurefire.suiteXmlFiles=testng.xml test
  ```
- You can also run the `testng.xml` suite directly from your IDE's TestNG runner.

### Test data
The sample login test signs in with the Sauce Demo credentials `standard_user` / `secret_sauce`. Update `LoginTest` if you want to parameterize or externalize credentials for your environment.

### Reports
After a run, Maven Surefire HTML reports are generated under `target/surefire-reports`. Open `index.html` in a browser to review the results.

> **Note:** WebDriverManager downloads the matching ChromeDriver binary automatically at runtime. Internet access is required the first time the tests execute on a new machine.
