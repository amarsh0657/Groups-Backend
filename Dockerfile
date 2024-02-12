FROM openjdk:19-jdk-slim

#Information around who maintains the image
MAINTAINER amarsh0657



# Add the application's jar to the image
COPY target/groups-0.0.1-SNAPSHOT.jar groups-0.0.1-SNAPSHOT.jar


# execute the application
ENTRYPOINT ["java", "-jar", "groups-0.0.1-SNAPSHOT.jar"]