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

import com.example.geohub.model.City;
import com.example.geohub.model.Country;
import com.example.geohub.repository.CityJpaRepository;
import com.example.geohub.repository.CityRepository;
import com.example.geohub.repository.CountryJpaRepository;

/**
 * CityJpaService
 */
@Service
public class CityJpaService implements CityRepository {
    @Autowired
    private CityJpaRepository cityJpaRepository;

    @Autowired
    private CountryJpaRepository countryJpaRepository;

    @Override
    public ArrayList<City> getCities() {
       List<City> cityList = cityJpaRepository.findAll();
       return new ArrayList<>(cityList);
    }

    @Override
    public City getCityById(int id) {
        try {
            City city = cityJpaRepository.findById(id).get();
            return city;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public City addCity(City city) {
        try {
            city.setCityId(0);
            Country country = countryJpaRepository.findById(city.getCountry().getCountryId()).get();
            city.setCountry(country);
            cityJpaRepository.save(city);
            return city;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public City updateCity(int id, City city) {
        try {
            City newCity = cityJpaRepository.findById(id).get();
            if (city.getCityName() != null) {
                newCity.setCityName(city.getCityName());
            }
            if (city.getCountry() != null) {
                Country country = countryJpaRepository.findById(city.getCountry().getCountryId()).get();
                newCity.setCountry(country);
            }
            if (city.getLatitude() != null) {
                newCity.setLatitude(city.getLatitude());
            }
            if (city.getLongitude() != null) {
                newCity.setLongitude(city.getLongitude());
            }
            if (city.getPopulation() != 0) {
                newCity.setPopulation(city.getPopulation());
            }
            cityJpaRepository.save(newCity);
            return newCity;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteCity(int id) {
        try {
            cityJpaRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Country getCityCountry(int cityId) {
        try {
            City city = cityJpaRepository.findById(cityId).get();
            return city.getCountry();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}