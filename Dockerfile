FROM adoptopenjdk:13.0.2_8-jre-hotspot-bionic
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]