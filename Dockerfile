FROM openjdk:8
ADD target/livenessprobe.jar /livenessprobe.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","livenessprobe.jar"]