# Inversion of Control + Dependency Injection Demo

This demo was created to provide a real world example to the article: [The Importance of Inversion of Control and the way to Achieve it using Dependency Injection
](https://medium.com/@arielkohan/inversion-of-control-ac8dd48e4341).

## Requirements
- Java 11

## Execution

In the root of the project:
```
./mvnw clean package
java -jar application/target/*.jar
```

## Project Stages

The article tries to exemplify the evolution of a project from the worst case to a flexible, mainteinable and testeable architecture based on Dependency Injection and Inversion of Control.

- [Worst Case](https://github.com/arielkohan/inversion-of-control-demo/tree/worst-case): first version with awful design choices.
- [Improvable Case](https://github.com/arielkohan/inversion-of-control-demo/tree/improvable-case): improved version with some intents to solve the problems but not enough yet.
- [IoC Version](https://github.com/arielkohan/inversion-of-control-demo/tree/ioc-version): solution based on Inversion of Control that accomplish all the proposed requirements.

For more context about the project and the topic refer to the article.
