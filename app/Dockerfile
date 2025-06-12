# Stage 1: Сборка с Maven
FROM maven:3.8.3-openjdk-17 AS builder
WORKDIR /app

# Копируем только pom.xml, чтобы кэшировать зависимости
COPY pom.xml .
RUN mvn dependency:go-offline

# Копируем исходники и собираем
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Финальный образ с Java
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Копируем JAR из первой стадии
COPY --from=builder /app/target/*.jar app.jar
ENTRYPOINT ["java", "-Xms128m", "-Xmx384m", "-XX:+UseContainerSupport", "-jar", "app.jar"]