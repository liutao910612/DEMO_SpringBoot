#添加Java8镜像来源
FROM java:8
MAINTAINER kevin <kevin@gmail.com>
VOLUME /tmp

#添加Spring Boot包
ADD springboot-docker-1.0-SNAPSHOT.jar app.jar

RUN bash -c 'touch /app.jar'
#执行启动命令
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]