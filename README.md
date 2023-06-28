<h2>Redis message queue for microservices</h2>
<h2>Technologies:</h2>
<h3>
<ul>
<li> <a href="https://docs.oracle.com/en/java/javase/11/core/java-core-libraries-developer-guide.pdf">Java 11</a></li>
<li> <a href="https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/">Spring Boot</a></li>
<li> <a href="https://redis.io/docs/">Redis</a></li>
</ul>
<h2>Installation:</h2>
<h3> These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.</h3>

#### 1) Install Mysql server or create docker image

```
// Pull Redis docker container

docker pull redis
```

```
// Run Redis docker container

docker run --name redis -d redis
```

#### 2) To run the application, run the following command in a terminal window (in the complete) directory:

```
//Build the project with Gradle

gradle bootJar
```

```
//Run the project with "java" command

cd build/libs

java -jar scaling-spring-boot-microservice-scheduler-0.0.1-SNAPSHOT.jar --port=8081
```
