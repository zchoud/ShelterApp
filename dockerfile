# Use an official OpenJDK base image with a specific version of Java
FROM openjdk:17

# Set a working directory inside the container
WORKDIR /app

# Copy your entire project directory (including the pom.xml) into the container
COPY . /app

# Build the Java application using Maven
RUN mvn clean package

# Define the entry point to run your Spring Boot application
CMD ["java", "-jar", "target/dashboard-0.0.1-SNAPSHOT.war"]