FROM alpine/git as clone
ARG branch=maven-master
WORKDIR /app
RUN git clone -b ${branch} 'https://gitee.com/cloudyscode/qx-project.git'

FROM node as web-build
WORKDIR /app/qx-admin/admin-web
COPY --from=clone /app/qx-project /app
RUN  npm config set registry https://registry.npm.taobao.org --global && \
     npm config set disturl https://npm.taobao.org/dist --global && \
     npm install yarn -g && \
     npm install && npm run build

FROM maven as build
USER root
WORKDIR /app
COPY --from=web-build /app /app
COPY --from=web-build /app/qx-admin/admin-web/dist /app/qx-admin/src/main/resources/public
RUN mvn clean package

FROM openjdk:8-jre
ARG path=/app/qx-admin
ENV artifact ${path}/target/*.jar
WORKDIR /app
COPY --from=build ${artifact} /app
EXPOSE 8080
ENTRYPOINT ["sh", "-c"]
CMD ["java -jar *.jar"]
