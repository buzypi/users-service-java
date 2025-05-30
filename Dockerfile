# Use the official Maven image to build the application
FROM maven:3.9.9-eclipse-temurin-24-alpine AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the rest of the application source code
COPY src ./src

# Package the application
RUN mvn clean package -DskipTests

# Use a smaller JDK runtime for running the application
FROM eclipse-temurin:24-jre

# Set the working directory for the runtime container
WORKDIR /app

# Copy the jar file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose port 8080
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
