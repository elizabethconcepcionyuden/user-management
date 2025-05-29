# Usa imagen base con JDK 17
FROM eclipse-temurin:17-jdk-alpine

# Crea y mueve a directorio de trabajo
WORKDIR /app

# Copia el jar generado por Gradle
COPY build/libs/*.jar app.jar

# Comando que se ejecuta al iniciar el contenedor
ENTRYPOINT ["java", "-jar", "app.jar"]
