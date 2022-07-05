# Library backend

This is the backend for the simple library application. This is a Java
web service built on the Jooby framework.

This program is broken by design! It contains more bugs than an average ant 
hill! **DO NOT USE FOR ANYTHING OUT IN THE REAL WORLD**.

## Running

The application assumes that there is a MySQL database up and running with the
URL and credentials configured in `resources/application.conf``. It will use
Flyway to create the proper schema before starting the service.

```
mvn clean jooby:run
```

## Building

```
mvn clean package
```

## Configuration

Most things can be configured in resources/application.conf. The default server
port (8080) can be changed with the configuration `server.port = XXXX`.

## Web Service API

The web service API is a simple API that uses JSON to transfer data. It does 
not follow a strict REST design.

### Authentication

Authentication is handled through a session cookie that is HTTP only. It does 
not support token based `Authentication` headers.

### Endpoints

* GET  /login/check
* POST /login
* GET  /logout
* POST /logout
* GET  /books
* GET  /register/available
* POST /register
* GET  /classifications
* GET  /admin/users/{id}
* GET  /admin/books/{id}
* GET  /admin/loan/overdue
* POST /admin/loan/lend
* POST /admin/loan/return
* GET  /user/loans