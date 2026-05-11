FROM eclipse-temurin:25-jdk-alpine
LABEL authors="snowsnr"
ARG JAR-FILE=target/MiniInventario4BM2-0.0.1-SNAPSHOT.jar
COPY ${JAR-FILE} app_inventariomini.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "app_inventariomini.jar"]