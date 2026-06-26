
# Sauce Demo Automation — Java + Selenium + Cucumber + TestNG

![Java](https://img.shields.io/badge/Java-11+-orange?logo=java)
![Selenium](https://img.shields.io/badge/Selenium-WebDriver-43B02A?logo=selenium)
![Cucumber](https://img.shields.io/badge/Cucumber-BDD-brightgreen?logo=cucumber)
![TestNG](https://img.shields.io/badge/TestNG-Runner-red)
![Maven](https://img.shields.io/badge/Maven-Build-C71A36?logo=apache-maven)
![Allure](https://img.shields.io/badge/Allure-Reports-yellow)
![Jenkins](https://img.shields.io/badge/Jenkins-CI%2FCD-D24939?logo=jenkins)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

**Author:** Ranajit Baran Chowdhury — Software Programmer & QA Automation Engineer
**Email:** chyranajit@gmail.com
**Phone:** +1 (267) 342-5565
**GitHub:** [@ranajitchowdhury](https://github.com/ranajitchowdhury)
**Portfolio:** [rbc6543.wixsite.com/rbc-portfolio](https://rbc6543.wixsite.com/rbc-portfolio)

A production-grade **BDD test automation framework** for the [Sauce Demo](https://www.saucedemo.com) e-commerce application — built with **Java**, **Selenium WebDriver**, and **Cucumber**, following enterprise-standard architecture principles: Page Object Model, thread-safe driver management, centralized configuration, and rich HTML reporting with embedded failure screenshots.

🌐 **Application Under Test:** [saucedemo.com](https://www.saucedemo.com)

---

## 📋 Tech Stack

| Layer | Technology | Purpose |
|-------|-----------|---------|
| **Language** | Java 11+ | Core automation logic |
| **Browser Automation** | Selenium WebDriver | Cross-browser UI control |
| **BDD Framework** | Cucumber (Gherkin) | Human-readable test scenarios |
| **Test Runner** | TestNG | Suite execution, grouping, parallel support |
| **Build Tool** | Maven | Dependency management & lifecycle |
| **CI/CD** | Jenkins / GitHub Actions | Automated build and execution pipeline |
| **Reporting** | Cucumber HTML + Allure | Rich, interactive test reporting |
| **Design Pattern** | Page Object Model (POM) | Maintainable, scalable UI abstraction |
| **Configuration** | Properties File | Zero hardcoded strings, environment-driven |

---

## 📁 Project Structure

```
Sauce_Demo_Automation_Final/
│
├── src/test/java/
│   ├── hooks/
│   │   └── Hooks.java                  ← @Before / @After with screenshot on failure
│   ├── pages/                          ← Page Object Model classes
│   │   ├── LoginPage.java
│   │   ├── DashboardPage.java
│   │   ├── ProductPage.java
│   │   ├── CartPage.java
│   │   └── CheckoutPage.java
│   ├── stepdefinitions/                ← Cucumber step definition classes
│   │   ├── CommonSteps.java
│   │   ├── LoginSteps.java
│   │   ├── CartSteps.java
│   │   └── CheckoutSteps.java
│   ├── runners/
│   │   └── TestRunner.java             ← TestNG + CucumberOptions runner
│   └── utils/
│       ├── DriverManager.java          ← Thread-safe WebDriver factory
│       ├── ConfigReader.java           ← config.properties reader
│       └── ScreenshotUtil.java         ← Failure screenshot capture
│
├── src/test/resources/
│   ├── features/                       ← Gherkin BDD feature files
│   │   ├── Login.feature
│   │   ├── ProductSorting.feature
│   │   ├── CartCheckout.feature
│   │   ├── SmokeTests.feature
│   │   └── RegressionTests.feature
│   └── config/
│       └── config.properties           ← URL, credentials, browser, timeouts
│
├── target/
│   └── cucumber-reports/
│       └── Sauce DemoCucumberFinalReport.html   ← Auto-generated HTML report
│
├── reports/
│   ├── allure-results/                 ← Allure raw data
│   └── screenshots/                    ← Failure screenshots (auto-saved)
│
├── pom.xml                             ← Maven dependencies & plugins
├── testng.xml                          ← TestNG suite configuration
├── Jenkinsfile                         ← CI/CD pipeline definition
└── README.md
```

---

## ✨ Framework Features

| Feature | Description |
|---------|-------------|
| ✅ BDD with Cucumber | Gherkin syntax — readable by QA, developers, and business owners |
| ✅ Page Object Model | Locators and actions encapsulated per page — single point of maintenance |
| ✅ Thread-Safe Driver | `ThreadLocal<WebDriver>` — parallel-execution ready |
| ✅ Screenshot on Failure | Auto-captured and embedded directly into Cucumber HTML report |
| ✅ Centralized Config | Zero hardcoded strings — all config driven via `config.properties` |
| ✅ Rich HTML Report | Step timings, parameter tables, failure logs, screenshots — all in one file |
| ✅ CI/CD Ready | Jenkins + GitHub Actions pipeline examples included |
| ✅ Tag-Based Execution | Run smoke, regression, or any subset with `@tags` |

---

## 🎯 Test Coverage

### 🔐 Login & Authentication
- Valid login with `standard_user`
- Invalid login — error message validation
- Locked-out user handling
- Logout and session termination

### 🛒 Product & Cart
- Add single and multiple products to cart
- Remove product from cart
- Cart badge count validation
- Product sorting — Name (A→Z, Z→A), Price (Low→High, High→Low)

### 💳 Checkout Flow
- Complete checkout with valid details
- Form validation (first name, last name, zip code)
- Order summary verification
- Purchase confirmation

### 🚀 Smoke Tests
- Application launch and home page load
- Login → Dashboard navigation
- Cart icon visibility and badge update

### 🔄 Regression Tests
- End-to-end purchase flow
- Multi-product cart and total price validation
- Sorting filter persistence

---

## ✅ Prerequisites

- ✅ **JDK 11 or higher** — configured in system PATH
- ✅ **Maven 3.8+** — installed and configured
- ✅ **Chrome / Firefox** — latest stable version
- ✅ **ChromeDriver / GeckoDriver** — matching browser version (or use WebDriverManager)
- ✅ **IDE** — IntelliJ IDEA or Eclipse
- ✅ **Git** — for cloning the repository

---

## ⚙️ Installation & Setup

**1. Clone the repository:**
```bash
git clone https://github.com/ranajitchowdhury/Sauce_Demo_Automation_Final.git
cd Sauce_Demo_Automation_Final
```

**2. Install all dependencies:**
```bash
mvn clean install -DskipTests
```

**3. Configure `src/test/resources/config/config.properties`:**
```properties
app.url=https://www.saucedemo.com
browser=chrome
headless=false
implicit.wait=10
page.load.timeout=30
valid.username=standard_user
valid.password=secret_sauce
locked.username=locked_out_user
```

---

## ▶️ Running Tests

### Run full test suite
```bash
mvn clean test
```

### Run Smoke tests only
```bash
mvn test -Dcucumber.filter.tags="@smoke"
```

### Run Regression tests only
```bash
mvn test -Dcucumber.filter.tags="@regression"
```

### Run Login tests only
```bash
mvn test -Dcucumber.filter.tags="@Login"
```

### Run in headless mode (CI/CD environments)
```bash
mvn test -Dheadless=true
```

### Run with specific TestNG suite
```bash
mvn test -DsuiteXmlFile=testng.xml
```

---

## 📊 Reports

### Cucumber HTML Report
Auto-generated after every run:
```
target/cucumber-reports/Sauce DemoCucumberFinalReport.html
```

Open in browser:
```bash
open "target/cucumber-reports/Sauce DemoCucumberFinalReport.html"
```

**Report includes:**
- ✅ / ❌ Step-level pass/fail status
- ⏱️ Step timing breakdown
- 📊 Parameter data tables
- 📸 Embedded failure screenshots
- 🏷️ Tag and scenario filtering

### Allure Report
```bash
mvn allure:serve
```

---

## 📸 Screenshot & Failure Handling

The framework implements a dynamic context listener hook that captures full-page screenshots automatically on any step failure and embeds them directly into the HTML report.

```java
// Hooks.java
@After
public void tearDown(Scenario scenario) {
    if (scenario.isFailed()) {
        // Capture full-page screenshot
        byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver())
            .getScreenshotAs(OutputType.BYTES);

        // Embed in Cucumber HTML report
        scenario.attach(screenshot, "image/png", "FAILED_" + scenario.getName());

        // Save to file system
        String path = "reports/screenshots/FAILED_"
            + scenario.getName().replaceAll("\\s+", "_") + ".png";
        FileUtils.writeByteArrayToFile(new File(path), screenshot);
        System.out.println("📸 Screenshot saved: " + path);
    }
    DriverManager.quitDriver();
}
```

**Failure outputs:**
- 📸 Full-page screenshot embedded in HTML report
- 🗂️ Screenshot saved to `reports/screenshots/FAILED_<ScenarioName>.png`
- 📋 Stack trace and step context captured in report
- 🔍 Failure reason visible without re-running tests

---

## 🔧 Centralized Configuration Engine

Zero hardcoded strings. All environments, URLs, credentials, and timeouts are driven via `config.properties`:

```java
// ConfigReader.java
public class ConfigReader {
    private static Properties prop = new Properties();

    static {
        try (FileInputStream fis = new FileInputStream(
                "src/test/resources/config/config.properties")) {
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("❌ Config file not found!", e);
        }
    }

    public static String get(String key) {
        return prop.getProperty(key);
    }
}
```

Usage in Page classes:
```java
driver.get(ConfigReader.get("app.url"));
```

---

## 🔄 CI/CD Integration

### Jenkins Pipeline

```groovy
pipeline {
    agent any

    tools {
        maven 'Maven 3.8'
        jdk 'JDK 11'
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/ranajitchowdhury/Sauce_Demo_Automation_Final.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }

        stage('Execute Tests') {
            steps {
                sh 'mvn test -Dheadless=true -Dcucumber.filter.tags="@smoke or @regression"'
            }
        }

        stage('Publish Reports') {
            steps {
                cucumber buildStatus: 'UNSTABLE',
                         fileIncludePattern: '**/cucumber.json',
                         reportTitle: 'Sauce Demo Report'

                allure([results: [[path: 'target/allure-results']]])
            }
        }
    }

    post {
        failure {
            emailext(
                subject: "❌ FAILED: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: "Tests failed. Review report: ${env.BUILD_URL}cucumber-html-reports",
                to: 'chyranajit@gmail.com'
            )
        }
        success {
            emailext(
                subject: "✅ PASSED: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: "All tests passed. Report: ${env.BUILD_URL}cucumber-html-reports",
                to: 'chyranajit@gmail.com'
            )
        }
    }
}
```

### GitHub Actions

```yaml
name: Sauce Demo Automation

on:
  push:
    branches: [main]
  pull_request:
    branches: [main]
  schedule:
    - cron: '0 8 * * 1-5'    # Mon–Fri 8 AM UTC

jobs:
  test:
    runs-on: ubuntu-latest

    steps:
      - uses: actions/checkout@v3

      - name: Set up JDK 11
        uses: actions/setup-java@v3
        with:
          java-version: '11'
          distribution: 'temurin'

      - name: Install dependencies
        run: mvn clean install -DskipTests

      - name: Run Smoke Tests
        run: mvn test -Dheadless=true -Dcucumber.filter.tags="@smoke"

      - name: Run Regression Tests
        run: mvn test -Dheadless=true -Dcucumber.filter.tags="@regression"

      - name: Upload Cucumber Report
        uses: actions/upload-artifact@v3
        if: always()
        with:
          name: cucumber-report
          path: target/cucumber-reports/

      - name: Upload Failure Screenshots
        uses: actions/upload-artifact@v3
        if: failure()
        with:
          name: failure-screenshots
          path: reports/screenshots/
```

---

## 🏷️ Tags

| Tag | Description |
|-----|-------------|
| `@smoke` | Critical path — fast build verification |
| `@regression` | Full regression test suite |
| `@Login` | Login and authentication scenarios |
| `@Cart` | Cart add, remove, and validation |
| `@Checkout` | End-to-end purchase flow |
| `@Sorting` | Product sorting and filter validation |

---

## 🏗️ Framework Architecture

```
Feature Files (Gherkin)
        ↓
Step Definitions (stepdefinitions/)
        ↓
Page Object Model (pages/)
        ↓
DriverManager (ThreadLocal WebDriver)
        ↓
Selenium WebDriver → Chrome / Firefox
        ↓
Sauce Demo Application (saucedemo.com)
        ↓
Cucumber HTML Report + Allure Report
        ↓
Jenkins / GitHub Actions Notification
```

### Senior QA Architecture Decisions

- **`ThreadLocal<WebDriver>`** — enables safe parallel execution without driver conflicts
- **Zero hardcoded strings** — `ConfigReader` makes the framework portable across environments (dev, staging, prod)
- **Centralised Hooks** — single `@Before`/`@After` prevents duplicate browser opens in multi-step scenarios
- **Embedded screenshots** — failures are self-documenting; no manual re-run needed to diagnose issues
- **Tag-based execution** — smoke, regression, or feature-specific runs without code changes

---

## 📈 Future Enhancements

- [ ] Docker containerization — isolated, reproducible test environments
- [ ] Parallel execution — TestNG `parallel="scenarios"` across multiple browsers
- [ ] BrowserStack integration — mobile and cross-browser cloud testing
- [ ] REST Assured API layer — backend contract validation alongside UI tests
- [ ] Database validation — JDBC assertions for data integrity testing
- [ ] AI-assisted test generation — auto-generate step definitions from feature files

---

## 🌟 Why This Framework?

| Strength | Detail |
|----------|--------|
| ✅ Industry-standard design | POM + BDD + Hooks — enterprise QA architecture |
| ✅ Easy to maintain | One locator change in the Page class fixes all tests |
| ✅ Self-documenting failures | Screenshots embedded in report — no guesswork |
| ✅ Readable scenarios | Gherkin understood by QA, devs, and product managers |
| ✅ Environment-agnostic | Switch URL and credentials in config — no code changes |
| ✅ CI/CD compatible | Jenkins, GitHub Actions, AWS Pipeline examples included |
| ✅ Parallel-ready | ThreadLocal driver prepares for concurrent execution |

---

## 🤝 Contributing

1. Fork the repository
2. Create your branch: `git checkout -b feature/improvement`
3. Write tests following the existing POM structure
4. Run `mvn test` to verify no regressions
5. Commit: `git commit -m 'Add improvement'`
6. Open a Pull Request

---

## 📄 License

This project is open-source under the **MIT License**.

---

## 👤 Author

**Ranajit Baran Chowdhury**
Software Programmer & QA Automation Engineer
- 📧 Email: chyranajit@gmail.com
- 📞 Phone: +1 (267) 342-5565
- 🐙 GitHub: [@ranajitchowdhury](https://github.com/rbchy)
- 🌐 Portfolio: [rbc6543.wixsite.com/rbc-portfolio](https://rbc6543.wixsite.com/rbc-portfolio)
- 💼 LinkedIn: [linkedin.com/in/ranajitchowdhury](https://linkedin.com/in/ranajitchowdhury)

---

**Version:** 1.0.0 | **Last Updated:** May 2026
