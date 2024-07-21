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

import com.example.geohub.model.Country;

/**
 * CountryRepository
 */
public interface CountryRepository {

    ArrayList<Country> getCountries();
    Country getCountryById(int id);
    Country updateCountry(int id, Country country);
    Country addCountry(Country country);
    void deleteCountry(int id);
}