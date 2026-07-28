FROM eclipse-temurin:25-jdk

VOLUME /tmp

COPY target/run-api.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]


