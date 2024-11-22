FROM openjdk:17-jdk-slim-buster
ARG JAR_FILE=gradle/wrapper/*.jar
COPY gradle/wrapper/clinventario-0.0.1-SNAPSHOT.jar clinventario.jar
ENTRYPOINT ["java","-jar","clinventario.jar"]