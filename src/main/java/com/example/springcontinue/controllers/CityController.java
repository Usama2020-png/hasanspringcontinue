package com.example.springcontinue.controllers;

import com.example.springcontinue.entity.City;
import com.example.springcontinue.entity.Country;
import com.example.springcontinue.repository.CityRepository;
import com.example.springcontinue.service.CityService;
import com.example.springcontinue.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping
    public List<City> getCities(){
        return cityService.getCities();
    }
    @GetMapping("/{id}")
    public City getCity(@RequestParam int id){
        return cityService.getCity(id);
    }
    @PostMapping
    public City addCity(@RequestBody City city){
        return cityService.addCity(city);
    }
    @PutMapping("/{id}")
    public City addCity(@RequestParam int id,@RequestBody City city){
        return cityService.updateCity(id,city);
    }
    @DeleteMapping("/{id}")
    public void deleteCity(@RequestParam int id){
        cityService.deleteCity(id);
    }
}