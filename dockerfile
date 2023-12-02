FROM openjdk:17 AS build
COPY target/shelterapp.jar /usr/app/shelterapp.jar
WORKDIR /usr/app
ENTRYPOINT ["java","-jar","shelterapp.jar"]
EXPOSE 5000