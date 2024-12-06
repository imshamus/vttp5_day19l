package sg.edu.nus.iss.vttp5_day19l.controller;

import java.io.StringReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import sg.edu.nus.iss.vttp5_day19l.model.Weather;
import sg.edu.nus.iss.vttp5_day19l.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController 
// When a method in a @RestController returns an object (like Weather), Spring Boot automatically converts the object into a JSON string for the HTTP response.
// This behavior is enabled by Spring's @RestController, which includes the @ResponseBody functionality by default.
// Spring uses the Jackson library (or another compatible library) to serialize the Weather object into a JSON response.
// So basically you get a JSON Object
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("")
    // Return Weather Obj Data 
    public Weather getWeatherData(@RequestParam("x") String apiKey, @RequestParam("y") String country, @RequestParam("z") String airQuality) 
    {
        
        // Gets the responseentity (Header + Body) from the given url
        ResponseEntity<String> resWeather = weatherService.getWeatherData(apiKey, country, airQuality); 
        
        // Only get the body data
        String rawString = resWeather.getBody();

        // Using JSON-P to extratc out the data i want for weather object
        // Return the weather object
        // Should do this in svc class

        JsonReader jReader = Json.createReader(new StringReader(rawString));
        JsonObject jObject = jReader.readObject();


        /* // Error prone method
        String countryData = jObject.get("location").asJsonObject().getString("country");
        String regionData = jObject.get("location").asJsonObject().getString("region");
        Double latData = jObject.get("location").asJsonObject().getJsonNumber("lat").doubleValue();
        Double lonData = jObject.get("location").asJsonObject().getJsonNumber("lon").doubleValue();
        Double pm25Data = jObject.get("current").asJsonObject().get("air_quality").asJsonObject().getJsonNumber("pm2_5").doubleValue();
        Double coData = jObject.get("current").asJsonObject().get("air_quality").asJsonObject().getJsonNumber("co").doubleValue(); */

        // Better method
        JsonObject jLocationData = jObject.getJsonObject("location");
        JsonObject jAirQuality = jObject.getJsonObject("current").getJsonObject("air_quality");

        String countryData = jLocationData.getString("country");
        String regionData = jLocationData.getString("region");
        Double latData = jLocationData.getJsonNumber("lat").doubleValue();
        Double lonData = jLocationData.getJsonNumber("lon").doubleValue();
        Double pm25Data = jAirQuality.getJsonNumber("pm2_5").doubleValue();
        Double coData = jAirQuality.getJsonNumber("co").doubleValue(); // 614.2 original data

        int co2Data = jAirQuality.getJsonNumber("co").intValue();
        System.out.println(co2Data); // prints 614
        
        Weather weatherData = new Weather(countryData, regionData, latData, lonData, pm25Data, coData);

        return weatherData;
    }
    
    
}
