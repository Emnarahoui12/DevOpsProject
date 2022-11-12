FROM openjdk:11
EXPOSE 8089
ADD target/devopsprojet.jar devopsprojet.jar
ENTRYPOINT ["java", "-jar", "/devopsprojet.jar" ]