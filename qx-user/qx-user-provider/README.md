docker镜像构建

> docker build -t qx-user-provider .

docker容器启动

> docker run -d --name qx-user-provider-7201 -p 7201:7201 -e SPRING_PROFILES_ACTIVE=7201  qx-user-provider

> docker run -d --name qx-user-provider-7202 -p 7202:7202 -e SPRING_PROFILES_ACTIVE=7202  qx-user-provider

> docker run -d --name qx-user-provider-7203 -p 7203:7203 -e SPRING_PROFILES_ACTIVE=7203  qx-user-provider
