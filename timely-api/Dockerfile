FROM gradle:8.7-jdk21 AS build
WORKDIR /app
COPY timely-api .
RUN gradle clean build -x test

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
CMD ["java", "-jar", "app.jar"]