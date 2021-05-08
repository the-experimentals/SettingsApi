FROM gradle:7.0-jdk16-hotspot AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM adoptopenjdk/openjdk16:jre-16.0.1_9-alpine

EXPOSE 5004

RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/*.jar /app/settingsapi.jar

ENTRYPOINT ["java", "-Djava.securitydocker.egd=file:/dev/./urandom","-jar","/app/settingsapi.jar"]