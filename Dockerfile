FROM openjdk:8-jre
RUN mkdir app
ARG JAR_FILE
ADD /target/${JAR_FILE} /app/application.jar
WORKDIR /app
ENTRYPOINT java -jar application.jar