package com.shevchenko.Controller.services;

import com.shevchenko.Model.dao.PatientDao;
import com.shevchenko.Model.dao.TreatmentDao;
import com.shevchenko.Model.entity.Patient;
import com.shevchenko.Model.entity.Treatment;

import java.util.List;

public class TreatmentService {
    private TreatmentDao treatmentDao = new TreatmentDao();

    public TreatmentService() {
    }

    public Treatment findTreatment(int id) {
        return treatmentDao.findById(id);
    }

    public List<Treatment> findAllTreatments(){
        return treatmentDao.findAll();
    }

    public void saveTreatment(Treatment treatment){
        treatmentDao.save(treatment);
    }

    public void deleteTreatment(Treatment treatment){
        treatmentDao.delete(treatment);
    }
    public void updateTreatment(Treatment treatment){ treatmentDao.update(treatment); }
}
