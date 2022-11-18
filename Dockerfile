FROM openjdk:8-jdk-alpine
EXPOSE 8089
ADD target/achatDevops-1.0.jar achatDevops-1.0.jar
ENTRYPOINT ["java","-jar","/achatDevops-1.0.jar"]