### MicroService 1
Setup notes:
To get a functioning kafka cluster:
* If you don't have docker-compose, install it
  * https://docs.docker.com/compose/install/
* Run the following command
  * ```docker-compose -f docker-compose.yml up -d```
* Run ```docker ps```
  * Ensure you have kafka-ui, kafka, and zookeeper running
* Because of wonky networking that I did not feel like debugging, we are going to hack around it.
  * In /etc/hosts - add kafka as an alias to 127.0.0.1
* Run microservices1
* Navigate to http://localhost:8085 and ensure you have a kafka connection
* In a separate window, run microservices2
* In the kafka-ui localhost:8085 you should now see a consumer
* post a message to the endpoint in example1
  * You should see a message in the kafka ui
  * Microservice2 should have consumed that message and stored it in the H2 database
* Microservice 2 runs on port 8081
  * You can hit the rest api created for microservice2 which is a GET to http://localhost:8081/api/messages and that should return all messages sent
* Now for your portion, create a third small microservice which will consume the data from the endpoint exposed from microservice2
* The flow is post a message to microservice1 -> show the flow into kafka, show microservice2 consume it -> show your microservice 3 interact with microservice 2 and do something with that data

Examples:
1. This microservice is a message producer. You send a JSON message via a post to http://localhost:8080/messages and it publishes a topic to the kafka queue
Example JSON message:
```json
{
  "message": "This is a test message"
}
```