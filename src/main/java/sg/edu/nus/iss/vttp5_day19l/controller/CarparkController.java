package sg.edu.nus.iss.vttp5_day19l.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.iss.vttp5_day19l.model.Carpark;
import sg.edu.nus.iss.vttp5_day19l.service.CarparkService;

@RestController
@RequestMapping("/carparks")
public class CarparkController {
    
    @Autowired
    private CarparkService carparkService;

    @GetMapping("")
    public List<Carpark> displayCarparks()
    {
        return carparkService.getCarparkRates();
    }

}
