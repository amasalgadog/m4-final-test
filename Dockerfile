# Using OpenJDK 17 as the base image
# This Dockerfile is designed to build a Java application using Maven and run it in a container
FROM openjdk:21-jdk-slim

# Stablish the working directory in the container
# This is where the application will be copied and run
WORKDIR /app

# Copy of the Maven project files to the container
COPY target/m4-final-test-1.0-SNAPSHOT.jar app.jar

# App port exposed
EXPOSE 3000

# Run application
ENTRYPOINT ["java", "-jar", "app.jar"]
