FROM openjdk:11-jre-slim
WORKDIR /app
COPY target/FXDeals-1.0-SNAPSHOT.jar.jar /app/application.jar
CMD ["java", "-jar", "application.jar"]
LABEL maintainer="mohanned.fds@gmail.com"
LABEL version="1.0"
LABEL description="Maven app for adding FX deals"