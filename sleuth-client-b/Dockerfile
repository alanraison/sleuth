FROM openjdk:jre

EXPOSE 8080

ADD target/sleuth-client-b.jar .

ENTRYPOINT [ "java" ]
CMD [ "-jar", "sleuth-client-b.jar" ]