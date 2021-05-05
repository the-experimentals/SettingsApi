FROM gradle:7.0.0-jdk16-hotspot@sha256:d31e12d105e332ec2ef1f31c20eac6d1467295487ac70e534e3c1d0ae4a0506e AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM adoptopenjdk/openjdk16:alpine-jre

EXPOSE 5004

RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/*.jar /app/settingsapi.jar

ENTRYPOINT ["java", "-Djava.securitydocker.egd=file:/dev/./urandom","-jar","/app/settingsapi.jar"]