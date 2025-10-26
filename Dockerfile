# Stage 1: Build the application using Maven with JDK 21
FROM maven:3.9.5-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
# The pom.xml must be configured for Java 21 for this to work
RUN mvn clean package -DskipTests

# Stage 2: Create the final, smaller runtime image (JRE 21)
FROM eclipse-temurin:21-jre-alpine # <-- CHANGED TO JRE 21
WORKDIR /app
# Copy the built JAR from the 'build' stage
COPY --from=build /app/target/CompanyCrawler-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]