package sg.edu.nus.iss.vttp5_day19l.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private static final String baseUrl = "http://api.weatherapi.com/v1/current.json";

    RestTemplate restTemplate = new RestTemplate();

    public ResponseEntity<String> getWeatherData(String apiKey, String country, String airQuality)
    {   
        String url = String.format("%s?key=%s&q=%s&aqi=%s", baseUrl, apiKey, country, airQuality);

        System.out.println("Url is: " + url);

        return restTemplate.getForEntity(url, String.class);
        // returns the response from the new url
    }
}
