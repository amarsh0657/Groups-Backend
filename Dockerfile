FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the source code into the container
COPY . .

ARG JAR_FILE=target/hitechdotcomapp*.jar

# Copy the MySQL credentials JSON file into the container
# Arguments to pass MySQL credentials during build
COPY appkey/credentials.json app/credentials.json

COPY ${JAR_FILE} app/app.jar

# Expose the port your Spring Boot app is listening on (default is usually 8080)
EXPOSE 8080

#ENTRYPOINT ["java", "-Djava.security.edg=file:/dev/./urandom","-jar","/app.jar"]
# Set the entry point to run the application
ENTRYPOINT ["java", "-jar", "app/app.jar"]
