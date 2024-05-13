Introduction-to-docker-for-java-developers by Mary Ellen Bowman


Dockerfile
```
FROM tomcat:9.0.jdk17-alpine

COPY ./app ./
WORKDIR /app
RUN ./mnvw package -DskipTests

RUN cp /app/target/*.war /usr/local/tomcat/webapps/Root.war
CMD ["catalina.sh", "run"]

```

run-example.sh
docker build -t war-example
docker run --name war-example -p 8080:8080 -d war-example

OCI (Open Container Initiative)

Dockerfile Structure:
It begins with a from base image and ends with a CMD or entry point command. From provides the builder a starting state, followed by more of the following, add and copy commands contribute files from the local file system into the image. Additional Forms are for creating multi-stage builds. Run executes a shell command within the image. User claims a user permission for proceeding instructions. Volume is used to associate a folder in a container with external data. Workdir changes the current working directory. And CMD or entry point is the final command which usually launches the containerized application. 
1. FROM

2. ADD, COPY, FROM, RUN,, USER, VOLUME, WORKDIR

3. CMD or ENTRYPOINT

Docker File Examples:
Eg: for Simple HelloWorld app
```
FROM openjdk:17-jdk
COPY ./Hello.class /
CMD ["java","Hello"}
```

Eg: 
```
FROM openjdk:17-jdk
ADD app /app
WORKDIR /app
CMD ["java","mainclassname","cp","lombok.jar"]
```




Eg:
```
FROM openjdk:17-jdk
ADD app /app
WORKDIR /app
RUN javac -cp lombok.jar mainclassname.java
CMD ["java","mainclassname","cp","lombok.jar"]
```
### Container Best Practices:
- Collection of files resulting from a docker file instruction
- Unique Hash
- Cacheable
- Builds faster when cached
- Change invalidates hash
- Invalid layers require rebuild
- Remaining layers invalidated

#### Layering best Practices:
- Import lightest, stable, verified and non-changing version images
- Only add files needed

E.g:
```
# JRE instead of JDK
FROM openjdk:11-jre-slim

# Work directory
WORKDIR /app

# Added only jar files
# Added jar file right before use
ADD target/project-name.jar /app/

CMD ["java","project-name.jar"]

```

Example 2: Bad practice
```
FROM openjdk:17-jdk
WORKDIR /app
ADD . /app
RUN ./mvnw package
CMD ["java", "-jar", "target/jarname.jar"]

```

## Docker Alternative:
Advantages with Alternatives:
Opinionated
Applies best practices for layering
Attempts lightest image possible
Configurable to override defaults
Out of docker world, back to coding

Examples:
1. Cloud Native build packs
2. Springboot Docker maven and Gradle plugin
3. Jib Maven and Gradle plugin

1. Cloud Native build packs (CFCF Project: buildpacks.io.docs)
- Specification and Various Implementations
- Transform source code to image
- Dependencies in separate layers
- Requires local docker engine
- Requires tool download

eg: pack



2. Springboot Docker plugin:
- Leverages build pack libraries within maven and gradle
- JDK of host and JRE in image based on java version
- Spring-aware dependency layering
- Requires local docker engine
- Springboot 2.3 or higher

<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<configuration>
					<image>
					<name> webapp:spring-boot</name>
					</image>
				</configuration>
			</plugin>

mvn package spring-boot:build-image


3. Google Jib plugin
- Developed by Google
- Maven and Gradle plugin available
- JAR built on host and JRE in image based on java version
- Dependency layering
- Lightweight and fast

```
<plugin>
				<groupId>com.google.cloud.tools</groupId>
				<artifactId>jib-maven-plugin</artifactId>
				<version>2.3.0</version>
				<configuration>
					<to>
					<image> webapp:spring-boot</image>
					</to>
				</configuration>

			</plugin>
```

for image to push to docker repo
mvn package jib:build

For local image:
mvn package jib:dockerbuild


Recap:
- A CI/CD Pipeline, when is it best to create an image?
  - during the build phase

- When building and launching a Java app that is packaged as a war, what is required to deploy the web archive?
  - Apache Tomcat Web Application Server

- Which command starts the application?
  - docker run
    Explanation: docker run starts the application.

Which image contains the Java compiler?
OpenJdk:jdk-17

What is a container?
a running instance of an image

How is a container instantiated from an image?
By deploying the image to a container runtime platform

What instruction is at the beginning of a Dockerfile?
FROM

How would you create an image using the Docker CLI?
docker build

How would you create an container using the Docker CLI?
docker run

Which Dockerfile instruction contributes filesystem artifacts to an image?
ADD

What is an instruction typically found at the end of a Dockerfile?
CMD


Why would you use one of Dockerfile alternatives?
Alternatives enforce best practices.

Cloud Native Buildpack _____.
is a specification published by the Cloud Native Computing Initiative

What is true about Spring Boot's plugin spring-boot:build-image?
It creates an image on the host machine.

What is true about Jib's plugin jib:build?
It automatically pushes an image to a docker registry.

What is true about Jib's plugin jib:dockerBuild?
It requires Docker to be installed locally.
