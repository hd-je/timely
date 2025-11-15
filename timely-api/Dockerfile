# 1단계: 빌드
FROM gradle:8.7-jdk21 AS build
WORKDIR /app

# 현재 프로젝트 전체 복사
COPY . .

# gradlew 권한 부여 후 빌드
RUN chmod +x ./gradlew
RUN ./gradlew clean build -x test

# 2단계: 실행
FROM eclipse-temurin:21-jre
WORKDIR /app

# 빌드된 jar 복사
COPY --from=build /app/build/libs/*.jar app.jar

# 포트
EXPOSE 8080

CMD ["java", "-jar", "app.jar"]