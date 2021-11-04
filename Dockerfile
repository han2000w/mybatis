FROM openjdk:11-jdk-slim
EXPOSE 8080
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} sample.jar
COPY scouter-agent-java-2.15.0.jar scouter-agent-java-2.15.0.jar
COPY scouter.conf scouter.conf
ENTRYPOINT ["sh", "-c", "java -javaagent:/scouter-agent-java-2.15.0.jar -Dscouter.config=/scouter.conf -jar /sample.jar"]
