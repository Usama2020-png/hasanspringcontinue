package com.example.springcontinue.service;

import com.example.springcontinue.entity.Country;
import com.example.springcontinue.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getCountries(){
        return countryRepository.findAll();
    }
    public Country getCountry(int id){
        return countryRepository.findById(id).orElse(null);
    }
    public Country addCountry(Country country){
        return countryRepository.save(country);
    }
    public Country updateCountry(int id,Country country){
        country.setCountryId(id);
        return countryRepository.save(country);
    }
    public void deleteCountry(int id){
        countryRepository.deleteById(id);
    }
}