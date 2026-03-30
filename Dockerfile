# ---------- Stage 1: Build ----------
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

# Copy pom.xml first (for caching dependencies)
COPY pom.xml .

RUN mvn dependency:go-offline

# Copy rest of the project
COPY src ./src

# Build the jar
RUN mvn clean package -DskipTests


# ---------- Stage 2: Run ----------
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy jar from build stage
COPY --from=build /app/target/project-0.0.1-SNAPSHOT.jar app.jar

# Expose port (optional but good practice)
EXPOSE 8080

# Run application
ENTRYPOINT ["java","-jar","/app/app.jar"]