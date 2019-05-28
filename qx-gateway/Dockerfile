FROM openjdk:8-jre

WORKDIR /app

COPY /target/*.jar .

ENTRYPOINT ["sh", "-c"]

CMD ["java -jar *.jar"]
