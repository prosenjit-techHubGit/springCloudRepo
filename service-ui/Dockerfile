FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY service-ui-0.0.1-SNAPSHOT.jar /app/service-ui-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/service-ui-0.0.1-SNAPSHOT.jar"]
