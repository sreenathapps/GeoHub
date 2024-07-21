/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 */

// Write your code here
package com.example.geohub.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.geohub.model.Country;
import com.example.geohub.repository.CountryJpaRepository;
import com.example.geohub.repository.CountryRepository;

/**
 * CountryJpaService
 */
@Service
public class CountryJpaService implements CountryRepository{
    @Autowired
    private CountryJpaRepository countryJpaRepository;

    @Override
    public ArrayList<Country> getCountries() {
       List<Country> countryList = countryJpaRepository.findAll();
       ArrayList<Country> countries = new ArrayList<Country>(countryList);
       return countries;
    }

    @Override
    public Country getCountryById(int id) {
        try {
            Country country = countryJpaRepository.findById(id).get();
            return country;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Country updateCountry(int id, Country country) {
        try {
            Country newCountry = countryJpaRepository.findById(id).get();
            if (country.getCountryName() != null) {
                newCountry.setCountryName(country.getCountryName());
            }
            if (country.getCurrency() != null) {
                newCountry.setCurrency(country.getCurrency());
            }
            if (country.getLatitude() != null) {
                newCountry.setLatitude(country.getLatitude());
            }
            if (country.getLongitude() != null) {
                newCountry.setLongitude(country.getLongitude());
            }
            if (country.getPopulation() != 0) {
                newCountry.setPopulation(country.getPopulation());
            }
            countryJpaRepository.save(newCountry);
            return newCountry;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Country addCountry(Country country) {
        countryJpaRepository.save(country);
        return country;
    }

    @Override
    public void deleteCountry(int id) {
        try {
            countryJpaRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    
}