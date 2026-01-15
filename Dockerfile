# Estágio 1: Build (Usando Java 21 estável)
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Copia dependências
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia código e compila
COPY src ./src
RUN mvn clean package -DskipTests

# Estágio 2: Runtime (Usando a imagem oficial do Java 21)
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copia o JAR do build
COPY --from=build /app/target/*.jar app.jar

# Define a porta do Render e limite de memória
EXPOSE 8080

# Otimização de memória para o plano free do Render
ENTRYPOINT ["java", "-Xmx400m", "-jar", "app.jar"]