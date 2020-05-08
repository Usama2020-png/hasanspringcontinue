package com.example.springcontinue.service;

import com.example.springcontinue.entity.City;
import com.example.springcontinue.entity.Country;
import com.example.springcontinue.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;
    public List<City> getCities(){
        return cityRepository.findAll();
    }
    public City getCity(int id){
        return cityRepository.findById(id).orElse(null);
    }
    public City addCity(City city){
        return cityRepository.save(city);
    }
    public City updateCity(int id,City city){
        city.setCityId(id);
        return cityRepository.save(city);
    }
    public void deleteCity(int id){
        cityRepository.deleteById(id);
    }
}