FROM eclipse-temurin:latest
VOLUME /temp
COPY /target/load-balancer-1.0.0.jar load-balancer.jar
EXPOSE 8080
CMD java -jar load-balancer.jar