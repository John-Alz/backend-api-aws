# Etapa 1: Build (construcción con Gradle)
FROM gradle:8.14.3-jdk17 AS build
WORKDIR /app
COPY . .
RUN gradle clean build -x test --no-daemon

# Etapa 2: Runtime (imagen final liviana)
FROM amazoncorretto:17-alpine
WORKDIR /app
COPY --from=build /app/build/libs/usersapi-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
