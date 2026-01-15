# Estágio 1: Build
# Usamos uma imagem que já contém o Maven e o JDK 25
FROM maven:3.9.9-eclipse-temurin-25 AS build
WORKDIR /app

# Copia o pom.xml e baixa as dependências (otimiza o cache do Docker)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia o código fonte e compila o projeto
COPY src ./src
RUN mvn clean package -DskipTests

# Estágio 2: Runtime (Execução)
# Usamos uma imagem leve apenas com o JRE do Java 25
FROM eclipse-temurin:25-jre-alpine
WORKDIR /app

# Copia o JAR gerado no estágio anterior
# O "*" garante que ele pegue o arquivo independente do nome/versão definido no pom.xml
COPY --from=build /app/target/*.jar app.jar

# Define a porta (o Render injeta o valor na variável PORT)
EXPOSE 8080

# Comando para rodar a aplicação definindo o limite de memória para o plano gratuito
ENTRYPOINT ["java", "-Xmx400m", "-jar", "app.jar"]