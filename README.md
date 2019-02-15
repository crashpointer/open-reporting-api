# Reporting API

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

It provides that you make complex reports easily for payment systems.

# Prerequisites

  - Java 8 Environment
  - PostgreSQL 9.4 or over

# Dependencies

You can see required dependencies in the pom.xml.

* Spring boot
* Spring Jpa
* JWT (Json Web Token)
* Jsr310

# Test Environment

This application is tested over:

- Arch Linux
- Java 8 OpenJDK
- PostgreSQL 11

# Settings

You will need some settings to execute and test this application. You can find required settings in the application.properties.

#### Database Settings

Suppose you have a server that be the PostgreSQL. Only will be enough that you edit the following parameters:

* spring.datasource.url
* spring.datasource.username
* spring.datasource.password

#### HTTPS Settings

* server.ssl.key-store
* server.ssl.key-store-password
* server.ssl.keyStoreType
* server.ssl.keyAlias

# Deployment

The Reporting API (Application Programming Interface) requires [Maven](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-maven-plugin/2.0.1.RELEASE) v2.0+ to run.

Install the dependencies and devDependencies and start the server.

```sh
$ cd open-reporting-api
$ maven clean install
$ mvn spring-boot:run
```

If you need test data, you can execute the following commands into your database server:

```sh
$ createdb -T template0 your_database_name
$ psql your_database_name < database.bak
```

# Interfaces

The Reporting API is currently extended with the following Interfaces.

| Interface | URI |
| ------ | ------ |
| Login | /api/v3/merchant/user/login |
| Report | /api/v3/transactions/report |
| List | /api/v3/transaction/list |
| Transaction | /api/v3/transaction |
| Client | /api/v3/client |


License
----

GNU v3


**Open Source Software**
