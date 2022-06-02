
FROM openjdk:11-jre-slim-buster
COPY /target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
EXPOSE 5004