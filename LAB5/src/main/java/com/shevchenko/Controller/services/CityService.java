package com.shevchenko.Controller.services;

import com.shevchenko.Model.dao.CityDao;
import com.shevchenko.Model.dao.CountryDao;
import com.shevchenko.Model.entity.City;
import com.shevchenko.Model.entity.Country;

import java.util.List;

public class CityService {
    private CityDao cityDao = new CityDao();

    public CityService() {
    }

    public City findCity(int id) {
        return cityDao.findById(id);
    }

    public List<City> findAllCities(){
        return cityDao.findAll();
    }

    public void saveCity(City city){
        cityDao.save(city);
    }

    public void deleteCity(City city){
        cityDao.delete(city);
    }

    public void updateCity(City city){
        cityDao.update(city);
    }

}
