FROM openjdk:11.0.4-jre-slim

RUN mkdir /app

WORKDIR /app

ADD ./api/target/ride-catalogue-api-1.0-SNAPSHOT.jar /app

EXPOSE 8083

CMD ["java", "-jar", "ride-catalogue-api-1.0-SNAPSHOT.jar"]