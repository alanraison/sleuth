FROM openjdk:jre

EXPOSE 8080

ADD target/sleuth-client-a.jar .

ENTRYPOINT [ "java" ]
CMD [ "-jar", "sleuth-client-a.jar" ]