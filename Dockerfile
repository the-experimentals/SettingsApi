FROM gradle:7.4.2-jdk17-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM eclipse-temurin:17.0.2_8-jre-alpine

EXPOSE 8080 6900

RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/*.jar /app/settingsapi.jar

ENTRYPOINT ["java", "-Djava.securitydocker.egd=file:/dev/./urandom" ,"-jar","/app/settingsapi.jar"]