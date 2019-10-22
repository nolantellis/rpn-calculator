RPNCalCulator
-------
[![Build Status](https://dev.azure.com/nolantellis0022/Nolan%20Project%201/_apis/build/status/nolantellis.rpn-calculator?branchName=master)](https://dev.azure.com/nolantellis0022/Nolan%20Project%201/_build/latest?definitionId=1&branchName=master)

Assumptions
----
* Not Sure if Java Doc was required.
* Log4j not used.
* Models are generic but Application implementation uses Double.

Features
----
* Case sensitivity considered.
* Snapshot is saved if last operation was invalid
* Program terminates on 'bbye'


Structure Flow
---
* Enter single or multiple expressions.
* Each space seperated item is equal to an operation

Few Main Classes with 1 line explaination
---
CalculatorApplication.java - Main application
MyStack.java - Generic Stack which saves its snapshot
StackSnapShot.java - Responsible for saving snapshots


Technology Used
---
Maven 3.
Java 8.
Jacoc for code coverage (cobetura does not support java 8 yet.)
Junit 4.12

How To Run
---
mvn clean test /* This will run the test
mvn clean install /* This will run the program too.

java -jar target/rpn-calculator-1.0-SNAPSHOT.jar

The above command needs to be run from project folder. Or can be run from any folder with absolute paths to jar.
