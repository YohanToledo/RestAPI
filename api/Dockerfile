FROM adoptopenjdk/openjdk11:latest
EXPOSE 8080
ENV APP_PROFILE=dev
ADD target/spring-boot-docker.jar spring-boot-docker.jar
ENTRYPOINT ["java","-jar","/spring-boot-docker.jar"]
