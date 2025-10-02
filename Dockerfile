# Stage 1: Build the application (using a JDK image)
FROM eclipse-temurin:17-jdk-jammy AS build

WORKDIR /app

# Copy the Maven pom.xml and source code
COPY pom.xml .
COPY src ./src

COPY mvnw .
COPY .mvn ./.mvn
RUN chmod +x ./mvnw

RUN ./mvnw package -DskipTests

# Stage 2: Create the final, smaller runtime image (using a JRE image)
# Use the official JRE image for a smaller footprint
FROM eclipse-temurin:17-jre-jammy

# Set the working directory
WORKDIR /app

# Copy the built JAR file from the 'build' stage
# The JAR file is typically named 'target/*.jar'
COPY --from=build /app/target/*.jar app.jar

# Expose the default Spring Boot port
EXPOSE 8080

# Command to run the application
# Use the JRE to run the JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
