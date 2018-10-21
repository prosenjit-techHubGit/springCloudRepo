FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD /target/Service2-0.0.1-SNAPSHOT.jar target/app.jar
COPY $Service2-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","target/app.jar"]