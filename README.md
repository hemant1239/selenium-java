# Selenium Java Framework 🚀

A lightweight and modular **Selenium automation framework** built using **Java + Maven + TestNG**.  
Designed for scalability, maintainability, and easy demonstration of framework capabilities.

---

## 📌 Features

- ✅ Page Object Model (POM) design pattern  
- ✅ Maven for dependency management  
- ✅ TestNG for test execution
- ✅ Supports multiple browsers (Chrome, Firefox)  
- ✅ Headless execution support (Chrome)  
- ✅ Screenshot capture on pass and failure  
- ✅ Reusable utility methods (e.g., waits)
- ✅ Extent report with screenshots

---

## 🛠️ Tech Stack

- **Language:** Java  
- **Build Tool:** Maven  
- **Test Framework:** TestNG  
- **Automation Library:** Selenium WebDriver  
- **Reporting:** Extent report

## 📂 Project Structure
```
selenium-java/
│── src/
│ ├── main/java/framework
│ │ ├── constants/ # Framework constants
│ │ ├── driver/ # Driver setup class
│ │ ├── pages/ # Page Objects
│ │ ├── utils/ # Utilities (waits, screenshots, config reader)
│ │
│ └── test/java/
│ ├── tests/ # Test classes
│ └── test/java/resources
│ │ ├── config / # 
│ │ │ ├── config.properties / # (URLs, etc)
│ │ ├── testData / # (Test Data)
│── pom.xml # Maven dependencies
│── testng.xml # TestNG suite config
│── README.md # Project documentation
```


---

## ⚡ Getting Started

### 1️⃣ Clone the Repository
```
git clone https://github.com/hemant1239/selenium-java.git
cd selenium-java
```

### 2️⃣ Install Dependencies
```
mvn clean install
```

### 3️⃣ Run Tests
```
mvn clean test
```
Or run with TestNG XML:
```
mvn clean test -DsuiteXmlFile=testng.xml
```
Headless
```
mvn clean test -Dheadless=true
```
---

## 👨‍💻 Author

### Hemant Dighade
📌 Sr. SDET | Automation | Java | Selenium

🔗 GitHub - https://github.com/hemant1239

🔗 LinkedIn - https://www.linkedin.com/in/hemant-d-687054102/

