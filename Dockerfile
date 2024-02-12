FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the source code into the container
COPY . .

ARG JAR_FILE=target/groups-0.0.1-SNAPSHOT*.jar



COPY ${JAR_FILE} app/app.jar

# Expose the port your Spring Boot app is listening on (default is usually 8080)
EXPOSE 8081

#ENTRYPOINT ["java", "-Djava.security.edg=file:/dev/./urandom","-jar","/app.jar"]
# Set the entry point to run the application
ENTRYPOINT ["java", "-jar", "app/app.jar"]
