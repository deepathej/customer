FROM openjdk:11
EXPOSE 8080
COPY target/customerservice.jar customerservice.jar
ENTRYPOINT ["java","-jar","/customerservice.jar"]