# Etapa 1: Definir a imagem base
FROM openjdk:17-jdk-slim

# Etapa 2: Definir o diretório de trabalho no container
WORKDIR /app

# Etapa 3: Copiar o JAR gerado para dentro do container
COPY target/cursospring-0.0.1-SNAPSHOT.jar app.jar

# Etapa 4: Expôr a porta em que o Spring Boot vai rodar
EXPOSE 8081

# Etapa 5: Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
