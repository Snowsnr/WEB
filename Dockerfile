FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn -q -DskipTests package

FROM eclipse-temurin:21-jre-alpine
LABEL authors="snowsnr"
WORKDIR /app
COPY --from=build /app/target/MiniInventario4BM2-0.0.1-SNAPSHOT.jar app_inventariomini.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "app_inventariomini.jar"]