# Etapa 1: Build do projeto
FROM maven:3.9.5-eclipse-temurin-17 AS builder
WORKDIR /app

# Copia arquivos de projeto
COPY pom.xml .
COPY src ./src

# Realiza o build da aplicação
RUN mvn clean package -DskipTests

# Etapa 2: Runtime com JDK leve
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copia o JAR gerado do estágio anterior
COPY --from=builder /app/target/*.jar app.jar

# Define porta exposta
EXPOSE 8080

# Define ponto de entrada
ENTRYPOINT ["java", "-jar", "app.jar"]
