Project Overview :
-----------------
This repository contains Selenium WebDriver automation scripts for testing the Opencart e-commerce application. 
The test cases cover functional, regression, and cross-browser testing. 
The project demonstrates hands-on experience in Java, TestNG, Selenium, and hybrid automation frameworks.

Technologies & Tools Used:
--------------------------
Programming Language: Java
Automation Tool: Selenium WebDriver
Test Framework: TestNG
Build Tool: Maven
Version Control: Git / GitHub
Bug Tracking: JIRA
Reporting: Extent Reports, TestNG Reports
Additional Tools: Postman (API testing), Git Bash, Chrome/Edge Browser
Project Structure:
------------------
OpencartV121/
├── src/
│   └── test/java/testCases/
│       ├── TC001_Registration.java       # User Registration Test
│       ├── TC002_LoginTest.java          # Basic Login Test
│       ├── TC003_LoginDDT.java           # Data-Driven Login Test
│       └── TC004_SearchProduct.java      # Search Functionality Test
├── reports/                               # TestNG HTML reports
├── screenshots/                            # Failed test screenshots
├── pom.xml
├── README.md

Test Cases Included:
--------------------
Test Case ID	Description
TC001	User registration test – verifies new user can register successfully.
TC002	Login test – validates correct login for valid credentials.
TC003	Data-driven login test – tests multiple login scenarios with valid/invalid credentials.
TC004	Search product test – validates search functionality and results page.
How to Run:
-----------
Clone the repository:
git clone https://github.com/SravaniKokkera/OpencartV121.git
Open the project in your IDE (Eclipse / IntelliJ).
Install required dependencies using Maven:
mvn clean install
Execute the test suite:
mvn test
Test reports will be available in the reports/ folder.
Screenshots of failed tests are stored in the screenshots/ folder.
🔹 Notes
Ensure ChromeDriver or EdgeDriver is available in your system PATH.
Tests are designed to run independently for reliable results.
API testing or future extensions can use Postman or Rest Assured.
Key Features:
-------------
Manual & Automation Testing (Functional, Regression, Smoke)
Data-Driven Login & Registration Tests
Selenium WebDriver with Java & TestNG
Page Object Model (POM) structure
HTML Reports & Screenshots for failures
Cross-Browser Testing (Chrome, Edge, Firefox)
Maven build & CI/CD ready (Jenkins/Docker basics)
JIRA integration for defect tracking.
