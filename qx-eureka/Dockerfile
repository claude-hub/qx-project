FROM openjdk:8-jre

WORKDIR /app

COPY /target/*.jar .

ENTRYPOINT ["sh", "-c"]

CMD ["java -jar *.jar --spring.profiles.active=${SPRING_PROFILES_ACTIVE}"]
