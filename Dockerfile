FROM maven:3.9.4-eclipse-temurin-21 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:21-slim
COPY --from=build /target/number-to-khmer-word-0.0.1-SNAPSHOT.jar number-to-khmer-word.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","number-to-khmer-word.jar", "--trace"]