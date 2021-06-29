FROM openjdk:8-jre-alpine

RUN yum install -y maven

RUN mvn clean install -DskipTests

ARG JAR_FILE=target/mock-api-service-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]

EXPOSE 8080

USER 1000
