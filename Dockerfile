FROM openjdk:17-jdk-slim-buster AS builder

RUN apt-get update -y
RUN apt-get install -y binutils

WORKDIR /app

COPY . .

RUN ./gradlew build

FROM openjdk:17-jdk-slim

COPY --from=builder /app/build/libs /app

RUN apt-get update && \
    apt-get install -y mariadb-client

# Set environment variables for the database connection
ENV DB_HOST=localhost
ENV DB_PORT=3306
ENV DB_NAME=bachelor_grade
ENV DB_USERNAME=root
ENV DB_PASSWORD=

# Start the Spring Boot application
CMD java -jar app/bachelor_grade-0.0.1-SNAPSHOT.jar --spring.datasource.url=jdbc:mariadb://${DB_HOST}:${DB_PORT}/${DB_NAME} --spring.datasource.username=${DB_USERNAME} --spring.datasource.password=${DB_PASSWORD}
