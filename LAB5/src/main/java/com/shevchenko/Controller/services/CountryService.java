package com.shevchenko.Controller.services;

import com.shevchenko.Model.dao.CountryDao;
import com.shevchenko.Model.entity.City;
import com.shevchenko.Model.entity.Country;

import java.util.List;

public class CountryService {
    private CountryDao countryDao = new CountryDao();

    public CountryService() {
    }

    public Country findCountry(int id) {
        return countryDao.findById(id);
    }

    public void saveCountry(Country country) {
        countryDao.save(country);
    }

    public void deleteCountry(Country country){
        countryDao.delete(country);
    }

    public void updateCountry(Country country){
        countryDao.update(country);
    }

    public List<Country> findAllCountrys(){
        return countryDao.findAll();
    }

    public Country findCountryById(int id){
        return countryDao.findCountryById(id);
    }

}
