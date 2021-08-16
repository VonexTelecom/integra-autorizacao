FROM openjdk:8-jdk-alpine

ENV TZ='GMT-3'

VOLUME /tmp

EXPOSE 8082

ARG JAR_FILE=target/*.jar

ADD ${JAR_FILE} api-autorizacao.jar

ENTRYPOINT ["java","-Xmx4g","-jar","/api-autorizacao.jar"]
