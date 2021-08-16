FROM openjdk:8-jdk-alpine

ENV TZ='GMT-3'

VOLUME /tmp

EXPOSE 8080

ARG JAR_FILE=target/*.jar

ADD ${JAR_FILE} api-reference.jar

ENTRYPOINT ["java","-Xmx4g","-jar","/api-reference.jar"]