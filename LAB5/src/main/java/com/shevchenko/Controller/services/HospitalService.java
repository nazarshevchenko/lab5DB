package com.shevchenko.Controller.services;

import com.shevchenko.Model.dao.HospitalDao;
import com.shevchenko.Model.entity.Hospital;

import java.util.List;

public class HospitalService {
    private HospitalDao hospitalDao = new HospitalDao();

    public HospitalService() {
    }

    public Hospital findHospital(int id) {
        return hospitalDao.findById(id);
    }

    public List<Hospital> findAllHospitals(){
        return hospitalDao.findAll();
    }

    public void saveHospital(Hospital hospital){
        hospitalDao.save(hospital);
    }

    public void deleteHospital(Hospital hospital){
        hospitalDao.delete(hospital);
    }
    public void updateHospital(Hospital hospital){ hospitalDao.update(hospital); }
}
