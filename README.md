
<h1 align="center">Automation Project with Cucumber and Java</h1>



---

<p align="center">This repository contains an automated testing project.
    <br> 
</p>

## 📝 Table of Contents

- [Introduction](#introduction)
- [Getting Started](#getting-started)
- [Requirements](#requirements)
- [Project Setup](#project-setup)
- [Running the Tests](#running-tests)
- [Web Browsers](#web-browsers)
- [General Implementation Details](#general-implementation-details)
- [Authors](#authors)


## 🧐 Introduction <a name="introduction"></a>

This project contains examples of test automation using Cucumber with Java as the programming language. Cucumber is a test automation tool that allows writing tests in natural language and is widely used in behavior-driven development (BDD).

## 🏁 Getting Started <a name="getting-started"></a>

Below are the instructions that will allow you to get a functional copy of the project on your local machine for development and testing purposes.

### 📋 Requirements <a name="requirements"></a>

Below are the necessary requirements to install the software, as well as the steps to carry out the installation effectively.


```
Java JDK 8 o superior
Maven
Cucumber 7.11.2
JUnit version 5.9.2
```

### 🛠️🔩 Project Setup <a name="project-setup"></a>

Detailed steps for setting up a development environment:
- Clone this repository to your local machine.
- Open the project in your preferred development environment (e.g., IntelliJ IDEA or Eclipse).
- Ensure you have the necessary dependencies in the project's pom.xml file. If any are missing, make sure to add them.
- Execute the following command to compile the project and download Maven dependencies:

```
mvn clean compile
```
## 🚧⚒️ Running the Tests <a name="running-tests"></a>
- To compile the project, execute the command
```
mvn test
```
## 🌐 Web Browsers <a name="web-browsers"></a>
The automation currently runs on the following web browsers:
- Google Chrome Version 115 or higher

## 💻 General Implementation Details <a name="general-implementation-details"></a>
Test scenarios are created in the feature file using Gherkin language and connected to step definition methods using annotations like @Given, @When, and @Then. The step definition methods are connected to Task classes for Given and When steps, where high-level actions are performed. These Task classes can invoke Interaction classes for low-level actions. For the Then step, it communicates with Question classes to perform validations.
🚧 **_The complete project structure will look like this:_**

```bash
   📦Retoautomation
   ┣ 📂src
   ┃ ┣ 📂test
   ┃ ┃ ┣ 📂java
   ┃ ┃ ┃ ┣ 📂Data
   ┃ ┃ ┃ ┣ 📂Driver 
   ┃ ┃ ┃ ┣ 📂Models
   ┃ ┃ ┃ ┣ 📂Object
   ┃ ┃ ┃ ┣ 📂Steps 
   ┃ ┃ ┃ ┗ 📂utils  
   ┃ ┃ ┃    ┗ 📦RunnersTest 
   ┃ ┣ 📂test
   ┃ ┃ ┣ 📂resources
   ┃ ┃ ┃ ┗ 📂features 
   ┃ ┃ ┃ ┗ 📂org  
   ┣ 📂target
   ┣ 📜.gitignore
   ┣ 📜pom.xml
   ┣ 📜README.md
```
```src/test/java/data```: This folder contains classes that define data objects used in the tests. These objects are used to provide input data to the tests and verify their results.

```src/test/java/Driver```: This folder contains classes that handle the configuration and instantiation of web browser drivers (e.g., Selenium WebDriver) used in automation.

```src/test/java/models```: This folder contains classes that define models of objects from the application under test.

```src/test/java/Objetc```: This folder contains classes that represent objects of the user interface (UI) of the web application under test. These classes are used to interact with UI elements of the web application and perform verifications on them.

```src/test/java/Steps```:This folder contains classes that define the steps of the tests written in natural language using the Cucumber Gherkin format. The steps defined here are the ones that will be executed during test execution.

```src/test/java/utils```: This folder contains utility classes used throughout the automation project.

```src/test/resources/features```:  This folder contains feature files written in the Cucumber Gherkin format. These files describe the test scenarios and the corresponding steps that are executed during testing.

End with an example of getting some data out of the system or using it for a little demo.

## 🎈 Test <a name="test"></a>

Test scenarios are created in the feature files using the Gherkin language. They are connected to methods in StepDefinition classes using annotations like @Given, @When, and @Then. The step definition methods are connected to Task classes for Given and When steps, where high-level actions are performed. These Task classes can invoke Interaction classes for low-level actions. For the Then step, it communicates with Question classes to perform validations.


⛏️ Built with <a name="Built_with"></a>

- [Cucumber](https://cucumber.io/docs/installation/javascript/) - framework 
- [Selenium](https://www.selenium.dev/) -  Framework
- [Java](https://www.java.com/) - Technology

✍️ Authors <a name="authors"></a>

- [@Felipe Sanchez](https://github.com/fepesanchez) 



