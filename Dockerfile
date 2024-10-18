FROM maven AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package
FROM openjdk:21-jdk-slim
WORKDIR /app
COPY --from=build /app/target/team-management-service-*.jar /app/app.jar
CMD ["java", "-jar", "/app/app.jar"]