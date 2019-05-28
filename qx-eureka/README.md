docker镜像构建

> docker build -t qx-eureka .

docker容器启动

> docker run -d --name qx-eureka7001 -p 7001:7001 -e SPRING_PROFILES_ACTIVE=7001  qx-eureka

> docker run -d --name qx-eureka7002 -p 7002:7002 -e SPRING_PROFILES_ACTIVE=7002  qx-eureka

> docker run -d --name qx-eureka7003 -p 7003:7003 -e SPRING_PROFILES_ACTIVE=7003  qx-eureka
