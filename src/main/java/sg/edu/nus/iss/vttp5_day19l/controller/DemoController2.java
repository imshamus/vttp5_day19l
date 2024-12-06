package sg.edu.nus.iss.vttp5_day19l.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sg.edu.nus.iss.vttp5_day19l.service.WeatherService;

@Controller
@RequestMapping("/demo2")
public class DemoController2 {
    
    @Autowired
    private WeatherService weatherService;

    @GetMapping("/weather")
    @ResponseBody
    public String demoController() {

        // weatherService.getWeatherData("89cf984b680d493088f25426240612", "London", "no");

        String apiKey = "89cf984b680d493088f25426240612"; // Replace with your actual API key
        String country = "London";
        String airQuality = "no";

        // Call the WeatherService and print the response
        ResponseEntity<String> resWeather = weatherService.getWeatherData(apiKey, country, airQuality);
        System.out.println("WeatherService called successfully!");

        return resWeather.getBody(); // this returns a String
    }
}
