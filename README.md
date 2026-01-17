# Weather
A simple weather application that fetches data from an external weather API and caches the results using Redis for better performance.

# Requirements:
Java 25
Redis Server
A weather API (Visual Crossing Weather API is used)
https://www.visualcrossing.com/weather-api/
# How to use:
This is a Spring Boot Application with a maven.To run the app use mvn spring-boot:run
Make sure that:
Redis is running on localhost:6379
Your API key is configured in application.properties

## Endpoints:
localhost:8080/api/weather/{cityName} Retrieves the weather forecast for the next 15 days (including today) in a simplified JSON format, based on the city name.

localhost:8080/api/weather/{latitude},{longitude} Retrieves the weather forecast in a simplified JSON format using geographical coordinates
