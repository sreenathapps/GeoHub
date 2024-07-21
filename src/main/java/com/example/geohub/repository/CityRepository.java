/*
 *
 * You can use the following import statements
 * 
 * java.util.ArrayList;
 * 
 */

// Write your code here
package com.example.geohub.repository;

import java.util.ArrayList;

import com.example.geohub.model.City;
import com.example.geohub.model.Country;

/**
 * CityRepository
 */
public interface CityRepository {

    ArrayList<City> getCities();
    City getCityById(int id);
    City addCity(City city);
    City updateCity(int id, City city);
    void deleteCity(int id);
    Country getCityCountry(int cityId);
    
}