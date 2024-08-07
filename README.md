# Java Maven FX Deals Assignment

## Overview

This project is a Java application designed to submit FX deals using MongoDB. The application is packaged in a Docker container for ease of deployment and development.
the project was developed as a console application prompting the user in each step and data input

## Project Structure

- `src/main/java/` - Contains the main application code.
  - `com.example` - Package for application logic and services.
  - `Models` - Contains data models.
- `src/test/java/` - Contains unit tests for the application.
- `Dockerfile` - Defines the Docker image for the application.
- `docker-compose.yml` - Orchestrates Docker containers for the application.
- `pom.xml` - Maven configuration file for dependencies and build.

## Getting Started


### Prerequisites

- [Java JDK 17](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- [Maven](https://maven.apache.org/)
- [Docker](https://www.docker.com/products/docker-desktop)
- [Docker Compose](https://docs.docker.com/compose/install/)

### Build the Application


1.  Clone the repository:
    ```bash
    git clone https://github.com/FadousMohannad/FXDeals.git
    ```

2. Build the project using Maven:
    ```bash
    mvn clean package
    ```
3. Use command to run the app
    ```bash
    mvn clean compile exec:java  .
    ```

   This will generate a JAR file in the `target` directory.

### Docker Setup

#### Build Docker Image

1. Build the Docker image:
    ```bash
    docker build -t fx-deals .
    ```

2. Run the Docker container:
    ```bash
    docker run -d -p 8080:8080 --name fx-deals-analyzer fx-deals-analyzer
    ```

   This will start the application on port 8080.

#### Using Docker Compose

1. Start the application using Docker Compose:
    ```bash
    docker-compose up
    ```

   This will build the Docker image (if not already built) and start the container.

2. To stop and remove the containers:
    ```bash
    docker-compose down
    ```

### Testing

1. Run the unit tests:
    ```bash
    mvn test
    ```

   Tests are located in `src/test/java/` and cover the application logic and functionality.

## Configuration

- **MongoDB**:
  - a connection string is set from my mongo atlas account in the code
  - change connection string using your own connection string from mongo atlas if you wanted to navigate test the database and browse collections
  - connection string example 
    ```bash
    mongodb+srv://mohannedfds:MEX9h88XeINUVvaZ@cluster0.nuvuyxn.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0
    ```

## Deployment

To deploy the Docker container to a production environment, you may need to customize the `Dockerfile` and `docker-compose.yml` with specific configurations or environment settings.



