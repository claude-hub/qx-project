FROM openjdk:8-jre-alpine
WORKDIR /app
COPY build/libs/*.jar /app
EXPOSE 8080
ENTRYPOINT ["sh", "-c"]
CMD ["java -jar *.jar"]