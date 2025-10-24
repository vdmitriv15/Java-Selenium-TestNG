# Java Selenium TestNG Framework

This project contains a basic Selenium + TestNG automation framework built using the Page Object Model (POM) pattern. The first sample test covers a successful login to [Sauce Demo](https://www.saucedemo.com/).

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

## Running the tests
1. Ensure you have Java 11+ and Maven installed.
2. Execute the tests with:
   ```bash
   mvn test
   ```

> **Note:** The tests run Chrome in headless mode. Google Chrome must be installed on the machine executing the tests.
