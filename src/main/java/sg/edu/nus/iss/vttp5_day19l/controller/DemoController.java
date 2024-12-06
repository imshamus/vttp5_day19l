package sg.edu.nus.iss.vttp5_day19l.controller;

import java.util.Random;

import javax.swing.text.html.HTML;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import sg.edu.nus.iss.vttp5_day19l.service.WeatherService;


// Option 1: Change the Return Type and Add Logging

// If you just want to see the URL printed in the terminal and confirm the endpoint is working, make these changes:

/* @Controller // cares abt displaying a html page
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/weather")
    public String demoController() {

        // weatherService.getWeatherData("89cf984b680d493088f25426240612", "London", "no");

        String apiKey = "89cf984b680d493088f25426240612"; // Replace with your actual API key
        String country = "London";
        String airQuality = "no";

        // Call the WeatherService and print the response
        weatherService.getWeatherData(apiKey, country, airQuality);
        System.out.println("WeatherService called successfully!");

        return "demo";
    } */

// Option 2: Option 2: Use @RestController to Return the Response

// If you are testing the service and don't care about rendering an HTML page, use @RestController instead of @Controller. This allows you to return the raw response.

@RestController 
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/weather")
    public ResponseEntity<String> demoController() {
        String apiKey = "89cf984b680d493088f25426240612"; // Replace with your actual API key
        String country = "London";
        String airQuality = "no";

        // Call the WeatherService and return its response
        ResponseEntity<String> response = weatherService.getWeatherData(apiKey, country, airQuality);

        // Log the URL and response
        System.out.println("WeatherService called successfully!");
        System.out.println("Response: " + response.getBody());

        
        return response;
    }

    /* @GetMapping("/health")
    public ModelAndView getHealth() {
        ModelAndView mav = new ModelAndView();

        try
        {
            // call checkHealth();
            checkHealth();

            mav.setViewName("healthy");
            mav.setStatus(HttpStatusCode.valueOf(200));
        }
        catch
        {

        }
    }
    
    public void checkHealth() throws Exception {
        Random random = new Random();
        Integer randomValue = random.nextInt(0,10);

        if (randomValue <= 5)
        {
            throw new Exception();
        }
    } */
}