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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.geohub.model.City;
import com.example.geohub.model.Country;
import com.example.geohub.service.CityJpaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




/**
 * CityController
 */
@RestController
public class CityController {
    @Autowired
    private CityJpaService cityJpaService;

    @GetMapping("/countries/cities")
    public ArrayList<City> getCities() {
        return cityJpaService.getCities();
    }
    @PostMapping("/countries/cities")
    public City addCity(@RequestBody City city) {
        return cityJpaService.addCity(city);
    }
    @GetMapping("/countries/cities/{id}")
    public City getCity(@PathVariable("id") int id) {
        return cityJpaService.getCityById(id);
    }
    @GetMapping("/cities/{id}/country")
    public Country getCityCountry(@PathVariable("id") int id) {
        return cityJpaService.getCityCountry(id);
    }
    @PutMapping("/countries/cities/{id}")
    public City updateCity(@PathVariable("id") int id, @RequestBody City city) {
        return cityJpaService.updateCity(id, city);
    }
    @DeleteMapping("countries/cities/{id}")
    public void deleteCity(@PathVariable("id") int id) {
        cityJpaService.deleteCity(id);
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }
    
}