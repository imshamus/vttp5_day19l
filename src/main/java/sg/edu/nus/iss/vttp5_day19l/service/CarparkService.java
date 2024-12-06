package sg.edu.nus.iss.vttp5_day19l.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import sg.edu.nus.iss.vttp5_day19l.model.Carpark;

@Service
public class CarparkService {

    RestTemplate restTemplate = new RestTemplate();

    public List<Carpark> getCarparkRates()
    {
        //RequestEntity req = RequestEntity(HttpMethod.GET, "http://localhost:8888/api/carparks").build();
        // if header info need, which dont need for this mod
        // RequestEntity req = RequestEntity.get("http://localhost:8888/api/carparks").header("Bearer", "JWT Token").header("accept", "application/json").build();
        
        @SuppressWarnings("rawtypes")
        RequestEntity req = RequestEntity
            .get("http://localhost:8888/api/carparks")
            .build();

        ResponseEntity<List<Carpark>> resCarparkRates = restTemplate.exchange(req, new ParameterizedTypeReference<List<Carpark>>(){
        }); // what is this?

        // there is also GetForEntity (Header + body), make sure you get body only
        // can you GetForObject

        List<Carpark> carparkRates = new ArrayList<>();

        carparkRates = resCarparkRates.getBody();

        return carparkRates;
    }
    
}
