FROM alpine:latest
RUN apk add openjdk11
ARG JAR_FILE=target/*.jar
RUN apk --no-cache add curl
ENTRYPOINT ["java","-jar","/achat-1.1.jar"]
EXPOSE 8089