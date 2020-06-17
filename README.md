# Simple Testerra Skeleton

This project is a simple skeleton project for Testerra framework addressing basic features,  
file and directory structure and common best practices to getting you and your project work as fast as possible.  
For simplicity, we will use Maven as build and dependency management tool. 

## Perquisites

This project is an implementation of the [getting started](https://tapas-docs.s3.eu-central-1.amazonaws.com/testerra/latest/index.html#_getting_started) tutorial.
All you have to do is, to setup an [own selenium server](https://tapas-docs.s3.eu-central-1.amazonaws.com/testerra/latest/index.html#_setup_selenium)

## Demo App
For sample page objects and easy testcases we use https://the-internet.herokuapp.com/ as base url for testing.

## Execution
You can simply execute the provided tests for the demo app by running following Maven command.
````shell script
mvn test -PmySuite
````
This will execute four simple tests in parallel mode for demonstrating you, how to use basic components of Testerra. You can see a list of features below.

## What this skeleton project offers you

### Page object and GuiElement
You will see how to use Testerra `Page` objects and work with basic features and selectors of `GuiElement`. 

### Properties
This project shows how you can set up a basic `test.properties` file to get things started locally.

### TestNG execution
With a simple Maven profile called `mySuite` you can run all tests from `TheInternetTest` class with 3 parallel browser sessions. 
You get in touch how to configure a TestNG suite file.

### Localization
To get in touch with localization, this skeleton project provides a simple resource bundle for english language.
The usage can be seen in some `Page` object classes of this project. 

### Fails-Annotation
The project shows you how to use Testerras `@Fails` annotation for marking test as expected errors.

### Failure Corridor
The skeleton shows you how to use `FailureCorridor` annotations and configuration in `test.properties`.

