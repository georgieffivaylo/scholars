# scholars
Scholars statistics project

A Java 21 Project with virtual threads.
The project runs at port 8085. 
It supports a basic MVC architecture that uses the REST endpoints.
H2 database support (configured in application.yaml).

Dependencies
- Spring Boot
- Spring Data JPA
- Query DSL
- Lombok
- Thymeleaf
- Validation
- WebMVC
- ModelMapper
- H2
- Flyway

Before initial start, run "mvn clean package" in the console 
to load all generated (QClass /QueryDSL/) classes. 
Otherwise the project won't start.
