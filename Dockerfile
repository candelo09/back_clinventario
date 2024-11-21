FROM openjdk:17-jdk-slim-buster
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} clinventario-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/clinventario-0.0.1-SNAPSHOT.jar"]