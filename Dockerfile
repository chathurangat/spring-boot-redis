FROM java:8
LABEL maintainer="dev@rumex.lk"
WORKDIR /app
COPY target/spring-boot-redis-0.0.1-SNAPSHOT.jar /app/spring-boot-app.jar
COPY elastic-apm-agent-1.16.0.jar /app/elastic-apm-agent.jar
#ENTRYPOINT ["java","-jar","spring-boot-app.jar"]
ENTRYPOINT ["java","-jar"]