# Dockerfile
FROM openjdk:11-jdk-slim
VOLUME /tmp
CMD ls
ARG JAR_FILE=./target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]