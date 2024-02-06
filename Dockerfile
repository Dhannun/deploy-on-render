# Use an official Maven image as the builder stage
FROM maven:3-openjdk-17-slim AS builder

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven project directory into the container
COPY . /app

# Build the Spring Boot application
RUN mvn clean package

# Use an official OpenJDK runtime as the base image
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the executable JAR file from the builder stage into the container
COPY --from=builder /app/target/ticket.jar /app/ticket.jar

# Expose the port that the application will run on
EXPOSE 8080

# Specify the command to run on container startup
ENTRYPOINT ["java", "-jar", "ticket.jar"]
