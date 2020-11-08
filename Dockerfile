FROM openjdk:8
ADD target/springboot-demo.jar /springboot-demo.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","springboot-demo.jar"]
