# Paso 1: Usar una imagen base de Java 17 ligera
FROM eclipse-temurin:17-jdk-alpine

# Paso 2: Crear un directorio de trabajo dentro del contenedor
WORKDIR /app

# Paso 3: Copiar el archivo .jar que generaste con Maven al contenedor
# Asegúrate de que el nombre coincida con el que genera tu build
COPY target/validador-comprobantes-0.0.1-SNAPSHOT.jar app.jar

# Paso 4: Exponer el puerto 8080 (el que usa tu Spring Boot)
EXPOSE 8080

# Paso 5: Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]