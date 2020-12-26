package com.shevchenko.Controller.services;

import com.shevchenko.Model.dao.CountryDao;
import com.shevchenko.Model.dao.DegreeDao;
import com.shevchenko.Model.entity.Country;
import com.shevchenko.Model.entity.Degree;

import java.util.List;

public class DegreeService {
    private DegreeDao degreeDao = new DegreeDao();

    public DegreeService() {
    }

    public Degree findDegree(int id) {
        return degreeDao.findById(id);
    }

    public void saveDegree(Degree degree) {
        degreeDao.save(degree);
    }

    public void deleteDegree(Degree degree){
        degreeDao.delete(degree);
    }

    public void updateDegree(Degree degree){
        degreeDao.update(degree);
    }

    public List<Degree> findAllDegree(){
        return degreeDao.findAll();
    }

    public Degree findDegreeById(int id){
        return degreeDao.findDegreeById(id);
    }

}
