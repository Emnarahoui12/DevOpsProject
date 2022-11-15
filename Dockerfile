FROM maven:3.8.2-jdk-11
ARG JAR=target/*.jar
COPY ${JAR} project.jar
EXPOSE 80
ENTRYPOINT ["java", "-jar", "project.jar"]