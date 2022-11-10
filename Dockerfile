FROM openjdk:8
EXPOSE 8089
ADD /target/achat-1.0.jar  achat-1.0.jar
ENTRYPOINT ["java", "-jar", "devopsproject-1.0.jar"]


