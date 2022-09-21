#referencia al jdk
FROM openjdk:18-jdk-alpine as builder

#creacion de carpeta
WORKDIR /app/msvc-usuarios

COPY ./pom.xml /app
COPY ./msvc-usuarios/.mvn ./.mvn
COPY ./msvc-usuarios/mvnw .
COPY ./msvc-usuarios/pom.xml .

RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/
#RUN ./mnvw dependency:gi-offline
COPY ./msvc-usuarios/src ./src

RUN ./mvnw clean package -DskipTests

#segunda configuracion
FROM openjdk:18-jdk-alpine
#creacion de carpeta
WORKDIR /app
COPY --from=builder /app/msvc-usuarios/target/msvc-usuarios-0.0.1-SNAPSHOT.jar .
#puerto de despliegue
EXPOSE 6666

#referencia del jar
ENTRYPOINT ["java","-jar", "msvc-usuarios-0.0.1-SNAPSHOT.jar"]

