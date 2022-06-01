FROM maven:3.6-jdk-11 as builder
# Copy local code to the container image.
WORKDIR /app
COPY pom.xml .
FROM openjdk:11-slim
COPY ./target/*.jar /data_JPA/mydocker/data_JPA.jar
WORKDIR /data_JPA/mydocker
# RUN sh -c 'touch demo.jar'
ENTRYPOINT ["java","-jar","data_JPA.jar"]