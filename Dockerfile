FROM openjdk:17-oracle

WORKDIR /app

COPY out /app

VOLUME /app

EXPOSE 8080

ENTRYPOINT ["java", "main.java.com.Calculatrice.CalculatriceApp", "app.jar"]
