FROM maven:3.8.6-eclipse-temurin-17 as build
WORKDIR /app/
ADD src/ /app/src
ADD pom.xml /app/

RUN mvn install

#EXECUTE
FROM eclipse-temurin:17.0.4.1_1-jre
WORKDIR /app/
COPY --from=build /app/target/invoice-service.jar /app/invoice-service.jar
EXPOSE 8080
RUN ls -la

#CMD "pwd"
ENTRYPOINT ["sh", "-c", "java -jar /app/invoice-service.jar"]