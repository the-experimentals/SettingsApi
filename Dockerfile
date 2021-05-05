FROM gradle:7.0.0-jdk16-hotspot@sha256:38e1de0085dba0dc2230d984ea48d63e663bbfc1abe547a09cfa3d9b48d987ca AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM adoptopenjdk/openjdk16:alpine-jre

EXPOSE 5004

RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/*.jar /app/settingsapi.jar

ENTRYPOINT ["java", "-Djava.securitydocker.egd=file:/dev/./urandom","-jar","/app/settingsapi.jar"]