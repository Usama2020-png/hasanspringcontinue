package com.example.springcontinue.controllers;

import com.example.springcontinue.entity.Country;
import com.example.springcontinue.repository.CountryRepository;
import com.example.springcontinue.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "country")
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping
    public List<Country> getCountries(){
        return countryService.getCountries();
    }
    @GetMapping("/{id}")
    public Country getCountry(@RequestParam int id){
        return countryService.getCountry(id);
    }
    @PostMapping
    public ResponseEntity<?> addCountry(@Valid @RequestBody Country country,BindingResult result){
        if(result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String, String>>(errors, HttpStatus.BAD_REQUEST);

        }
       Country country1=  countryService.addCountry(country);
       return new ResponseEntity<Country>(country1,HttpStatus.CREATED);

    }
    @PutMapping("/{id}")
    public ResponseEntity<?> addCountry(@RequestParam int id,@Valid @RequestBody Country country,BindingResult result){
        country.setCountryId(id);
        if(result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return new ResponseEntity<Map<String, String>>(errors, HttpStatus.BAD_REQUEST);

        }
        Country country1=  countryService.addCountry(country);
        return new ResponseEntity<Country>(country1,HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCountry(@RequestParam int id){
        countryService.deleteCountry(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
}