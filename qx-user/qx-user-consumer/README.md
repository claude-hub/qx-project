docker镜像构建

> docker build -t qx-user-consumer .

docker容器启动

> docker run -d --name qx-user-consumer-7101 -p 7101:7101 -e SPRING_PROFILES_ACTIVE=7101  qx-user-consumer

> docker run -d --name qx-user-consumer-7102 -p 7102:7102 -e SPRING_PROFILES_ACTIVE=7102  qx-user-consumer

> docker run -d --name qx-user-consumer-7103 -p 7103:7103 -e SPRING_PROFILES_ACTIVE=7103  qx-user-consumer
