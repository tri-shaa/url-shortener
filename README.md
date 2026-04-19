#  URL Shortener

A simple URL shortener built using Spring Boot that converts long URLs into short, shareable links.

##  Features
- Shorten long URLs
- Redirect to original URL
- Simple and clean UI
- REST API support
- Click tracking
- Copy links
- Auto -update

##  Tech Stack
- Java
- Spring Boot
- H2 Database
- HTML, CSS, JavaScript

##  How to Run

1. Clone the repository
2. Run the application:
   mvn spring-boot:run
3.  Open in browser:
   http://localhost:8080/


##  API Endpoints

### Shorten URL:
  POST /shorten

### Redirect:
  GET /r/{code}
