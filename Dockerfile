FROM openjdk:11
VOLUME /tmp
EXPOSE 8080
COPY target/desafio-pichincha-1.0.0-SNAPSHOT.jar service-pichincha-desafio.jar
ENTRYPOINT ["java","-jar","/service-pichincha-desafio.jar"]