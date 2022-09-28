<div align="center">

# URL Shortener API

![](https://img.shields.io/badge/Status-Done-brightgreen)


</div>
<div align="center">

![](https://img.shields.io/badge/Autor-Welington%20Larsen-brightgreen)
![](https://img.shields.io/badge/Language-Java-brightgreen)
![](https://img.shields.io/badge/MicroFramework-Spark-brightgreen)

</div>

## Description
The project is a simple url shortener that contains two methods: one to short an url and another to redirect from a unique key.

## Java Version

It's recommended use java 18

## Local setup

Install project dependencies

```bash
$ ./mvnw package
```

Up necessary infrastructure

```bash
$ docker-compose up -d
```

Start application (port 4567)

```bash
$ java -jar ./target/url-shortener-1.0-SNAPSHOT.jar
```

## Run tests

You may execute the following command via CLI:

```bash
$ ./mvnw test
```
