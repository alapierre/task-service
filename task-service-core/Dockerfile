FROM dc.sidgroup.pl/java:14

EXPOSE 8080

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

USER app

ENTRYPOINT ["/run-java.sh",  "/app.jar"]
