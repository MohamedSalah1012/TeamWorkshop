# Use an official OpenJDK runtime as a parent image
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . /app

# Install Maven
RUN apt-get update && apt-get install -y maven

# Build the application
RUN mvn clean install

# Make port 8080 available to the world outside this container
EXPOSE 8080

## Define environment variable
#ENV DATABASE_URL=${DATABASE_URL}
#ENV DATABASE_USERNAME=${DATABASE_USERNAME}
#ENV DATABASE_PASSWORD=${DATABASE_PASSWORD}
#ENV SERVER_PORT=${SERVER_PORT}

# Run the application
CMD ["java", "-jar", "target/your-app.jar"]
