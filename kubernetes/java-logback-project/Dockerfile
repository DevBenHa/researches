FROM openjdk:8-jdk-alpine
COPY logback-test2/target/logback-test2-0.0.1-SNAPSHOT.war /home/appmobid/app/logback-test2-0.0.1-SNAPSHOT.war
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-Dlogging.config=/cluster-data/apps/logback/config/logback-spring.xml","-jar","/home/appmobid/app/logback-test2-0.0.1-SNAPSHOT.war"]
