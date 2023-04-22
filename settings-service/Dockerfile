FROM gradle:8.1.1-jdk17 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build -x test --no-daemon --parallel

FROM eclipse-temurin:17.0.4_8-jre-alpine

EXPOSE 8080 6900

RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/*.jar /app/settingsapi.jar

ENTRYPOINT ["java", "-Djava.securitydocker.egd=file:/dev/./urandom" ,"-jar","/app/settingsapi.jar"]