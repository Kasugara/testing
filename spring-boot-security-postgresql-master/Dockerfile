FROM adoptopenjdk/openjdk11:alpine-jre
MAINTAINER Andre Ertanto "ertanto_andre11@yahoo.com"
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/application.jar"]