FROM openjdk:17-jdk-alphine

VOLUME /tmp

COPY target/run-api.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]


