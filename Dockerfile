FROM openjdk:17-oracle

VOLUME /app

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
