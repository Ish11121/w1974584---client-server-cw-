Overview - Api built using JAX-RS to manage rooms,sensors and the sensor readings. You can create rooms, retrieve specific sensor readings also deleting rooms and other data like sensors and the readings, while also being able to handle errors and filter sensors.

HOW TO BUILD PROJECT AND LAUNCH SERVER

- open project in netbeans
- make sure have Apache Tomcat added as the server
- download POSTMAN 
- clean and build
- run project enabling Apache Tomcat to start
- server starts now after running
- Use this URL to access the Api : http://localhost:8080/SmartSensor/api/v1
- Use POSTMAN to test Api endpoints

CURL COMMANDS

- Get all sensors(GET): curl http://localhost:8080/SmartSensor/api/v1/sensors
  
- Get readings for a sensor(GET): curl http://localhost:8080/SmartSensor/api/v1/sensors/1/readings

- Get all rooms(GET): curl http://localhost:8080/SmartSensor/api/v1/rooms

- Delete a room(DELETE): curl -X DELETE http://localhost:8080/SmartSensor/api/v1/rooms/1

- Add a sensor(POST): curl -X POST http://localhost:8080/SmartSensor/api/v1/sensors -H "Content-Type: application/json" -d '{"sensorName":"Oxygen Sensor","type":"O2","roomId":2,"currentValue":0.9}'

REPORT

Part 1 - Service Architecture & Setup 

1.1 - JAX-RS has a statelessness design where no client session data is stored on the server and each one of the request will be handled individually, statelessness design allows it to run more smoothly. A new instance is instantiated for every incoming request, because of this it means that a new object is created for every request and that the data that is stored in a one place like in tutorial 8 where MockDatabase was used. Due to the fact that many requests are using the data it must be handled correctly to ensure no mistakes. 

1.2 - Hypermedia as the engine of application state means that the API should contain links that allow clients to discover avaliable actions and transition between application state dynamically. This approach benefits client developers compared to static documentation because of the simplicity and the ease of use while being more flexible, as the client can just follow the links while being able to understand a lot more easily compared to if they were to approach using static documentation. Allowing the API to be used easily with no confusion and all while it is flexible as the clients can engage with the api without needing to have knowledge.  

Part 2 - Room Management  

2.1 - When returning a list of rooms, the implications of returning only ID's is that because there is less data being sent meaning that there is an improved performance because it is using less bandwidth as less data is being used, also on the client side this may still mean they will make more requests as they are only getting single rooms and may need full room details so more requests will still need to be processed. However, when returning the full room object more data is being used therefore it is using more bandwidth but it will make it more simple for the client as it will get all rooms in one response, so overall the implications is that if a client was to only return id vs the full room object is that even though it is more efficient, the full room object will be easier for the client but more bandwidth is used.

2.2 - The Delete operation is indeed idempotent in my implementation. If a client mistakenly sends the exact same DELETE request for a room multiple times then the system should return a 404 Not Found error if the room has already been deleted, the system should stay the same as the room has already been deleted once so it will be the same as before but just one less room if the room has no sensors that is, as a room can only be deleted once it has no sensors. If in fact the room does have sensors still assigned, then the delete request will be blocked and the room will not be removed. Overall, meaning that no matter how many delete requests ar made the data will not change for the system. 

part 3 - Sensor Operations & Linking 

3.1 - As we are using Java API for RESTful Web Services and a key component of it is @Consumes (MediaType.APPLICATION_JSON) which means that the POST method will only allow JSON data. If a client was to send data in the format of text/plain or application/xml JAX-RS will reject the request and it would return an error as the request format has not matched what the method accepts.

3.2 - Query parameter is used to pass additional information to the server and this approach is generally considered superior for filtering and searching collections because it keeps the same resource and just filters the results. Using path sensors/type/CO2 path can make it look as if it is a seperate resource instead of just a filtered result.

part 4 - Deep Nesting with Sub - Resources 

4.1 - The architectural benefits of the Sub-Resource Locator pattern is that it helps by seperating the API into smaller classes instead of putting it all into one, while allowing the organisation of the code to be at its best at all times. Having it organised allows the code to be read more easily and can be managed more easily. Also delegating logic to separate classes help manage complexity in large APIs because it reduces complexity as each class handles a certain part in the API compared to defining every nested path (e.g.,sensors/{id}/readings/{rid}) in one massive controller class because this way it would be harder to understand and manage.

part 5 - Advanced Error Handling, Exception Mapping & Logging 

5.2 - HTTP 422 often considered more semantically accurate than a standard 404 when the issue is a missing reference inside a valid JSON payload, is because of the fact that 422 is a lot more accurate when it comes to the request being valid but then the roomId will not exist. The 404 will be used when the actual room itself is not existing and not when the data is incorrect.

5.4 - The risks associated with exposing internal Java stack traces to external API consumer is that it can expose internal details about the system e.g. the class name, files and the application structure/layout. This information can allow the attacker to understand how the whole system works and use that information to find weakpoints to exploit it further. 

5.5. - It is advantageous to use JAX-RS filters for cross-cutting concerns like logging, rather than manually inserting Logger.info() statements inside every single resource method because it keeps it logged all in one place instead of adding Logger.info everytime. This is advantageous because it alows for the code the be easier to manage and more time effiecient when coding it. 



