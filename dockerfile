# Étape 1 : Utilisation d'une image JDK
FROM openjdk:17-jdk-slim as builder

# Étape 2 : Copier le fichier jar de l'application
WORKDIR /app
COPY target/*.jar app.jar

# Étape 3 : Exposer le port sur lequel l'application va tourner
EXPOSE 8080

# Étape 4 : Commande pour exécuter l'application
ENTRYPOINT ["java", "-jar", "app.jar"]
