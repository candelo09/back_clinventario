FROM openjdk:17-jdk-slim-buster
ARG JAR_FILE=gradle/wrapper/*.jar
COPY ${JAR_FILE} clinventario.jar
ENTRYPOINT ["java","-jar","/clinventario.jar"]