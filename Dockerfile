FROM openjdk:17-alpine
ADD /target/ci_cd-0.0.1-SNAPSHOT.jar ci_cd.jar
ENTRYPOINT ["java","-jar" , "ci_cd.jar"]
EXPOSE 8080