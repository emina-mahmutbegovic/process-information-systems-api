# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jre-slim

# Set environment variables for Spring Boot application
ENV SPRING_PROFILES_ACTIVE=production
ENV JAVA_OPTS="-Xmx512m -Xms256m"

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container at /app
COPY build/libs/process-information-systems-api-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose port 8080 to the outside world
EXPOSE 8080

# Command to run the Spring Boot application
CMD ["java", "-jar", "app.jar"]
