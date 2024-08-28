<br/>
<p align="center">
  <a href="https://github.com/ro-carlos/haast-challenge">
    <img src="https://upload.wikimedia.org/wikipedia/commons/d/d5/Selenium_Logo.png" alt="Logo" width="80" height="80">
  </a>

  <h3 align="center">Haast Challenge</h3>

  <p align="center">
    Custom Automation Framework
    <br/>
    <br/>
    <a href="https://github.com/ro-carlos/haast-challenge"><strong>Explore the docs »</strong></a>
    <br/>
    <br/>
  </p>
</p>

![Downloads](https://img.shields.io/github/downloads/ro-carlos/haast-challenge/total) ![Contributors](https://img.shields.io/github/contributors/ro-carlos/haast-challenge?color=dark-green) ![Issues](https://img.shields.io/github/issues/ro-carlos/haast-challenge) ![License](https://img.shields.io/github/license/ro-carlos/haast-challenge)

## Table Of Contents

- [About the Project](#about-the-project)
- [Built With](#built-with)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Usage](#usage)
- [Authors](#authors)

## About The Project

![Screen Shot](https://drive.google.com/uc?export=view&id=1xdLldyKH3coYg6b43nRH2NUUIoAYxiR3)
![Screen Shot](https://drive.google.com/uc?export=view&id=1p4PcrKI13_PaD3_HElh6Ttk4fPydpYqI)

This is an automation framework to run test cases using selenium and java.

## Built With

Java 11, Selenium 4.8.0, TestNG 7.7.1

## Getting Started

You just need the Java 11 version on your local machine.

### Prerequisites

Install Java 11.

- java

_Check Oracle, please refer to the [Java Versions](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)_

### Installation

1. Clone the repo

```sh
git clone https://github.com/ro-carlos/haast-challenge.git
```

2. Install Maven Packages

```sh
mvn clean install
```

## Usage

1. Run all the unit test classes.

```sh
mvn clean test
```

2. Run a single test class.

```sh
mvn clean test -Dtest=LoginTest 
```

3.  Run multiple test classes.

```sh
mvn clean test -Dtest=LoginTest,SearchTest
```

4.  Run a single test method from a test class.

```sh
mvn clean test -Dtest=LoginTest#loginWithValidUserWrongPassword
```

5. Run tests with groups

```sh
mvn clean test -Dtest.groups=regression
```

6. Run tests with groups and headless mode

```sh
mvn clean test -Dtest.groups=smoke -Dheadless=true
```

## Authors

- **Carlos Rodríguez** - _Software Engineer_ - [Carlos Rodríguez](https://github.com/ro-carlos/) - _Challenge_
