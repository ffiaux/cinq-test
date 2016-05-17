# Producer-Consumer Proposed Exercise
The current project is a scaffold for an application that receives messages via REST endpoint and
must transfer the message to another endpoint using pure JMS, or a combination of JMS/REST or JMS/SOAP.

There are two projects:
- jms-producer: It is the client application, runs on spring-boot and enables an POST endpoint to post messages
- jms-consumer: Almost empty.

## Details
The method to transfer the message from the Producer should be via JMS. It must be implemented on the com.cinq.rh.jms.Client class.
The way the Consumer receives is up to you: it can be JMS, REST, SOAP. It must be implemented on the com.cinq.rh.jms.Service class. The transfer the message, you must use a third-party software, like an ESB stack, Application Server or a queue manager. The intention is to simulate an environment were the middleware can be scabalble without interfering in the application. 

The Producer application is implemented with Spring-boot and is self-contained. To run, just use:

    java -jar producer.war

To assure that the applications are isolated, the Consumer must run on its own VM. Currently the project is self-contained and can be run with :

    java -jar consumer-jar-with-dependencies.war

To test the application using the endpoint, POST a message with a _text/plain_ payload to

    http://localhost:8080/greet/send

I recommend using a plugin for Google Chrome to POST messages, like Postman or Advanced Rest Client.

#Challenge 1
Transfer the message using a ESB software (or similar) available on the Market, like Mule, Oracle Service Bus, IBM Integration Bus, Apache Kafka, etc. For that, you will need to send evidence and the configuration instructions so we can replicate the solution. If you take this challenge, the Middleware must run in another container, i.e., like in the diagram below.


![Ideal Application](https://github.com/cinqtechnologies/producer-consumer-test/blob/master/IdealApplication.jpg?raw=true)

#Challenge 2
Implement a neat page to send messages
