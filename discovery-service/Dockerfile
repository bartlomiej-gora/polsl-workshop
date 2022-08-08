FROM eclipse-temurin:latest
VOLUME /temp
COPY /target/discovery-service-1.0.0.jar service.jar
EXPOSE 8761
CMD java -jar service.jar