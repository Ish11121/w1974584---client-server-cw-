SmartSensor Api - CW

Part 1 - Service Architecture & Setup 

1.1 - JAX-RS has a statelessness design where no client session data is stored on the server and each one of the request will be handled individually, statelessness design allows it to run more smoothly. A new instance is instantiated for every incoming request, because of this it means that a new object is created for every request and that the data that is stored in a one place like in tutorial 8 where MockDatabase was used. Due to the fact that many requests are using the data it must be handled correctly to ensure no mistakes. 

1.2 - 
