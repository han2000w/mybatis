FROM openjdk:11-jdk-slim
EXPOSE 8080
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} sample.jar
COPY scouter.agent.jar scouter.agent.jar
ENTRYPOINT ["sh", "-c", "java -javaagent:/scouter.agent.jar -Dnet_collector_ip=192.168.62.200 -jar /sample.jar"]
