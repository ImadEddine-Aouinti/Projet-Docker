# Utiliser une image officielle OpenJDK 21 slim
FROM openjdk:21-jdk-slim

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Copier le fichier JAR généré dans le conteneur
COPY target/app_web-0.0.1-SNAPSHOT.jar app_web.jar

# Exposer le port sur lequel l'application écoute
EXPOSE 8080

# Lancer l'application
CMD ["java", "-jar", "app_web.jar"]
