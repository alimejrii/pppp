FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
RUN apk --no-cache add curl
RUN curl -u admin:admin -o achat-1.4.jar "http://192.168.1.195:8081/repository/maven-releases/tn/esprit/rh/achat/1.4/achat-1.4.jar" -L
ENTRYPOINT ["java","-jar","/achat-1.4.jar"]
EXPOSE 8089
