FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/Coins.jar /app/Coins.jar

EXPOSE 8080

CMD ["java", "-jar", "Coins.jar", "server"]