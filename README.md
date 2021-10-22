# resilient microservices implemented using Resilience4j. 

The implemented Microservice application uses the Circuit Breaker pattern to gracefully degrade functionality when a method call fails. Use of the Circuit Breaker pattern can allow a microservice to continue operating when a related service fails ( service not available or timeouts), preventing the failure from cascading and giving the failing service time to recover.

The circuit breaker not only prevents cascading of the failures to the microservices, but also gives an opportunity to the misbehaving microservice to get corrected and once they are back to health the circuit breaker closes and the related features comes to normalcy. Circuit breaker has the states of CLOSED, OPEN, HALF-OPEN.

CLOSED - when all the services are healthy

OPEN - there are some failed/failing(not healthy) microservices detected. In this state the circuit is open and fallback methods can serve during this time

HALF-OPEN - this is kind of experimental state after OPEN which allows to check if the failed services are back to normal or not. In this state not all the requests are passed to the failed microservice, but configured(minimum) number of requests will be sent at configued time intervals to check if the microservice is functioning or not and further state of the circuit breaker will be decided. 

# Dependencies

1.Spring Web

2.Spring Boot

3.Resilience4j

4.Lombok




 # stock-price-provider-microservice -  
      simulates a stock exchange which provides api;s for returning the stock prices info

# stock-broking-house-microservice - 
     simulates a broking house & consumes the pricing api provided by the above provider microservice.

 http://localhost:9002/client/scrip/2  - properly working api which provides scrip info of the passed id

![image](https://user-images.githubusercontent.com/8149802/138482171-d9e358d3-0d6a-4f13-a60e-bc65fb6255c0.png)


 http://localhost:9002/client/scrip/cktBrkr/unavail/2 - services are not available and the response is provided by the designated fallback method of circuit breaker pattern for service not avaialble
![image](https://user-images.githubusercontent.com/8149802/138482418-913d56a2-5b5f-44bd-8b7d-390ba44501cf.png)

 http://localhost:9002/client/scrip/cktBrkr/timeout/2 - when a single call is made this works but with simulated latency

 http://localhost:9002/client/scrip/cktBrkr/timeout/2 - when 3 or more calls are made simultaneously the response is provided by the designated fallback method of the circuit breaker pattern for timeouts
 ![image](https://user-images.githubusercontent.com/8149802/138482695-b7960390-823e-47f7-b927-cac7d44b77ac.png)


