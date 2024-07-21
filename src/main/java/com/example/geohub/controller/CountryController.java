/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.ArrayList;
 * 
 */

// Write your code here
package com.example.geohub.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.geohub.model.Country;
import com.example.geohub.service.CountryJpaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




/**
 * CountryController
 */
@RestController
public class CountryController {
    @Autowired
    CountryJpaService countryJpaService;

    @GetMapping("/countries")
    public ArrayList<Country> getCountries() {
        return countryJpaService.getCountries();
    }
    @PostMapping("/countries")
    public Country addCountry(@RequestBody Country country) {
        return countryJpaService.addCountry(country);
    }
    @GetMapping("/countries/{id}")
    public Country getCountry(@PathVariable("id") int id) {
        return countryJpaService.getCountryById(id);
    }    
    @PutMapping("countries/{id}")
    public Country updateCountry(@PathVariable("id") int id, @RequestBody Country country) {
        return countryJpaService.updateCountry(id, country);
    }
    @DeleteMapping("countries/{id}")
    public void deleteCountry(@PathVariable("id") int id) {
        countryJpaService.deleteCountry(id);
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

}