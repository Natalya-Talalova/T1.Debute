FROM maven AS build
WORKDIR /app

# Сначала копируем только pom.xml, чтобы Docker использовал кэш для зависимостей, если исходники не изменились
COPY pom.xml .
RUN mvn dependency:go-offline --no-transfer-progress

# Копируем исходники и собираем проект
COPY src ./src
RUN mvn clean package -DskipTests

# Финальный этап для запуска приложения
FROM openjdk:21-jdk-slim
WORKDIR /app

# Копируем собранный jar-файл из предыдущего этапа
COPY --from=build /app/target/team-management-service-*.jar /app/app.jar

# Запуск приложения
CMD ["java", "-jar", "/app/app.jar"]
