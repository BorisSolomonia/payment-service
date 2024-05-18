FROM maven:latest
WORKDIR /payment-service

COPY . /payment-service
COPY . /src/main/resources/application.yaml
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "/payment-service/target/payment-service-0.0.1-SNAPSHOT.jar"]