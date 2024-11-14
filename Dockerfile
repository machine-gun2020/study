# 1. Usar una imagen base de Java
FROM openjdk:17-jdk-slim

# 2. Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# 3. Copiar el archivo JAR generado por Maven o Gradle al contenedor
COPY target/StudyApplication.jar /app/StudyApplication.jar

# 4. Exponer el puerto en el que se ejecutará la aplicación
EXPOSE 8080

# 5. Comando para ejecutar la aplicación Java
ENTRYPOINT ["java", "-jar", "my-app.jar"]
