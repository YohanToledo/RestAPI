FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY --from=build /home/app/target/jar_name.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]