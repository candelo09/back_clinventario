#FROM openjdk:17-jdk-slim-buster
#ARG JAR_FILE=gradle/wrapper/*.jar
#COPY gradle/wrapper/clinventario-0.0.1-SNAPSHOT.jar clinventario.jar
#ENTRYPOINT ["java","-jar","clinventario.jar"]

# Imagen base con JDK 17 y runtime optimizado
#FROM eclipse-temurin:17-jdk-alpine
#
## Directorio de trabajo dentro del contenedor
#WORKDIR /app
#
## Copiar los archivos de compilación
#COPY build/libs/*.jar clinventario.jar
#
## Puerto en el que corre Spring Boot
#EXPOSE 8080
#
## Comando para ejecutar la aplicación
#ENTRYPOINT ["java", "-jar", "clinventario.jar"]

# Etapa 1: Construcción
FROM gradle:8-jdk17 AS build

WORKDIR /clinventario

COPY gradle gradle
COPY build.gradle settings.gradle ./
COPY src ./src

# Construir la aplicación
RUN gradle clean bootJar --no-daemon

# Etapa 2: Ejecutar la app con SSL
FROM eclipse-temurin:17

WORKDIR /clinventario

# Copiar el JAR compilado
COPY --from=build /clinventario/build/libs/*.jar clinventario.jar

# Copiar el certificado SSL al contenedor
COPY certs/keystore.p12 /clinventario/certs/keystore.p12

# Exponer el puerto HTTPS
EXPOSE 8443

CMD ["java", "-jar", "clinventario.jar"]
