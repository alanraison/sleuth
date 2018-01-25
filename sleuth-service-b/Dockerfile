FROM openjdk:jdk AS build

COPY . .
RUN ./mvnw verify

FROM openjdk:jre

EXPOSE 8080

COPY --from=build sleuth-service-b/target/sleuth-service-b.jar .

HEALTHCHECK --interval=30s --timeout=5s --start-period=5s --retries=3 \
  CMD [ "wget", "-q", "-O-", "-T", "5", "-t", "1", "http://localhost:8080/health" ]

ENTRYPOINT [ "java" ]
CMD [ "-jar", "sleuth-service-b.jar" ]