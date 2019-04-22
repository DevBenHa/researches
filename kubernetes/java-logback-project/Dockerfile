FROM openjdk:8-jdk-alpine
COPY target/logback-test2.war /home/appmobid/app/logback-test2.war
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-Dlogging.config=/cluster-data/apps/logback/config/logback-spring.xml","-jar","/home/appmobid/app/logback-test2.war"]
