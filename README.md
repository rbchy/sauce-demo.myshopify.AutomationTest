
# 🚀 Sauce_Demo_Automation_Final

A highly scalable, robust, and enterprise-ready Behavior Driven Development (BDD) Test Automation Framework built using **Java**, **Cucumber BDD**, **TestNG**, and **Maven**. 

This framework is custom-built to automate, validate, and regress critical workflows on modern web applications, currently configured out-of-the-box for the **Sauce Demo** platform. It utilizes industry-standard automation patterns to deliver clean code, stable executions, and insightful test reporting.

---

## 📌 Project Overview

The framework validates end-to-end user journeys, transactional workflows, and crucial UI layers. The architecture cleanly separates test behaviors from implementation details by incorporating:

*   **✅ Behavior Driven Development (BDD)** via highly readable Gherkin features.
*   **✅ Page Object Model (POM)** for decoupling page elements from test logic.
*   **✅ Cross-Browser Execution capabilities** to ensure seamless rendering across distinct engines.
*   **✅ Dynamic Wait & Synchronizations** to eliminate fragile, flaky executions.
*   **✅ Centralized Build Management** controlled entirely via Maven.

---

## 🛠️ Tech Stack

| Technology | Purpose |
| :--- | :--- |
| **Java (JDK 21+)** | Core Programming Language (Built and optimized on OpenJDK 21.0.7) |
| **Browser Automation Engine**| Scalable Web Driver Architecture |
| **Cucumber BDD (v7.18.0)** | Behavior Driven Development and Step Definition Mapping |
| **TestNG** | Test Orchestration, Assertions, and Suite Execution Management |
| **Maven** | Dependency Management and Build Lifecycle Control |
| **Eclipse / IntelliJ** | Development Integrated Development Environment (IDE) |
| **Cucumber HTML Reports** | Extensive Post-Execution Test Visualizations |

---

## 📂 Project Structure

The project conforms to a highly modular Maven directory structure, making it incredibly intuitive to scale or refactor:

```text
Sauce_Demo_Automation_Final
│
├── src/test/java
│   ├── pages               # Page Element Locators and Action Methods (POM)
│   ├── stepdefinitions     # Glued Gherkin step implementations 
│   ├── runners             # TestNG Cucumber Runner Configurations
│   ├── utilities           # Reusable helper methods and synchronization wrappers
│   └── hooks               # Setup (@Before) and Teardown (@After) operations
│
├── src/test/resources
│   └── features            # Pure Gherkin Business Feature Files
│       ├── AddToCart.feature
│       ├── HomePage.feature
│       ├── LoginSteps.feature
│       ├── NavigationLinks.feature
│       ├── SearchFunctionality.feature
│       └── SignUp.feature
│
├── target
│   └── cucumber-reports    # Auto-generated HTML Test execution reports
│
├── pom.xml                 # Central Project Object Model dependency file
└── README.md               # Project documentation

```

---

## ✅ Automated Feature Coverage

### 🔐 Authentication & Access

* **Login Workflows (`LoginSteps.feature`):** Positive and negative access validation, handling valid and invalid credential matrices.
* **Sign Up Flow (`SignUp.feature`):** Validation of registration forms, required field validations, and user onboarding steps.

### 🛒 E-Commerce & Transactional Workflows

* **Home Page Context (`HomePage.feature`):** Structural landing page components, hero sections, and state assertions.
* **Cart Core (`AddToCart.feature`):** Dynamic element handling for adding, updating, and persisting products inside the user cart.
* **Search Engine (`SearchFunctionality.feature`):** Content filtration, matching queries, handling empty/negative search criteria states.
* **Navigation Triggers (`NavigationLinks.feature`):** Comprehensive link crawling, cross-page jumps, and structural footer/header verification.

---

## 🧪 Test Execution Metrics (Last Run)

The framework guarantees rock-solid stability and zero flakiness. The latest automated regression build completed with a flawless success rate:

* **📊 Metrics:** **100% PASSED**
* **🧩 Total Scenarios Executed:** 17 Scenarios
* **🟢 Total Passed:** 17 Scenarios
* **🔴 Total Failed:** 0 Scenarios
* **⏱️ Suite Execution Duration:** 4 minutes, 15 seconds
* **💻 Platform Engine:** Mac OS X (OpenJDK 64-Bit Server VM `21.0.7+6-LTS`)

---

## ▶️ How to Run the Project Local

### Prerequisites

Before triggering execution, ensure your local environment contains the following installations:

1. **Java Development Kit:** JDK 21+
2. **Apache Maven:** Configured in your system variables (`mvn -v`)
3. **IDE Environment:** Eclipse IDE or IntelliJ IDEA
4. **Target Browser:** Google Chrome / Chrome Driver installed

### 🔧 Setup Steps

1. **Clone the Repository:**

```bash
   git clone [https://github.com/yourusername/Sauce_Demo_Automation_Final.git](https://github.com/yourusername/Sauce_Demo_Automation_Final.git)

```

2. **Navigate into the workspace root:**

```bash
   cd Sauce_Demo_Automation_Final

```

3. **Compile and Install Project Dependencies:**

```bash
   mvn clean install -DskipTests

```

### 🏎️ Execution Commands

Run the entire automated suite using the Maven test phase command line configurations:

* **Execute All Test Scenarios (Default Runner):**

```bash
    mvn clean test
    ```
*   **Run Targeted Test Tags (e.g., Smoke Suite):**
```bash
    mvn test -Dcucumber.filter.tags="@smoke"
    ```
*   **Run Targeted Regression Test Tags:**
```bash
    mvn test -Dcucumber.filter.tags="@regression"
    ```

---

## 📊 Rich HTML Reporting

Upon suite teardown, the execution wrapper natively outputs a fully populated, styled HTML graphic log. You can review step timings, parameter data tables, and embedded failure capture logs at the following relative path location:

```text
📂 target/cucumber-reports/Sauce DemoCucumberFinalReport.html

```

---

## 📸 Core Framework Technical Features

* **Automatic Defect Visual Capture:** Implements a dynamic context listener hook that drops full-page screenshots into the HTML report immediately if a step fails.
* **Centralized Configuration Engine:** Zero hardcoded strings. Environments, URLs, and timing timeouts are driven entirely via clean configuration matrices.
* **Thread-Safe Architecture:** Built with parallel hooks structure preparation, ready for concurrent multi-thread runs via TestNG.

---

## 👨‍💻 Author

**Ranajit Baran Chowdhury**

* 🚀 *QA Automation Engineer*
* 📧 **Email:** chyranajit@gmail.com
* 📱 **Phone:** +1 (267)-342-5565
* 💼 **Connect:** Feel free to fork this project, open issues, or submit performance enhancements!

---

## 📄 License

This test suite framework distribution is openly licensed under the terms of the **MIT License**.

```

```
