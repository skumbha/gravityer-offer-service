# Create a lightweight base image for runtime
FROM openjdk:17-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the compiled JAR file from the build stage
COPY target/gravityer-offer-1.0.0.jar ./app.jar

# Expose the port that your Spring Boot application listens on
EXPOSE 8080

# Specify the command to run your application when the container starts
CMD ["java", "-jar", "app.jar"]
