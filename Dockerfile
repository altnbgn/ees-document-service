FROM openjdk:11

WORKDIR /usr/src/app
VOLUME /accounting-report

COPY ./build/libs/*-SNAPSHOT.jar app.jar
EXPOSE 8812
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://erin:ErinAdmin@mongo-report:27017/?authSource=admin","-Dspring.profiles.active=prod","-jar", "app.jar"]
