# Estágio 1: Build
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

# Estágio 2: Runtime (Trocamos Alpine pela estável baseada em Debian)
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Expõe a porta que o Render usa
EXPOSE 8080

# Usamos o shell form para garantir que as variáveis de ambiente JAVA_OPTS sejam lidas
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Xmx400m -jar app.jar"]