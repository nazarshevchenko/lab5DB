package com.shevchenko.Controller.services;

import com.shevchenko.Model.dao.DoctorDao;
import com.shevchenko.Model.dao.HospitalDao;
import com.shevchenko.Model.entity.Doctor;
import com.shevchenko.Model.entity.Hospital;

import java.util.List;

public class DoctorService {
    private DoctorDao doctorDao = new DoctorDao();

    public DoctorService() {
    }

    public Doctor findDoctor(int id) {
        return doctorDao.findById(id);
    }

    public List<Doctor> findAllDoctors(){
        return doctorDao.findAll();
    }

    public void saveDoctor(Doctor doctor){
        doctorDao.save(doctor);
    }

    public void deleteDoctor(Doctor doctor){
        doctorDao.delete(doctor);
    }
    public void updateDoctor(Doctor doctor){ doctorDao.update(doctor); }
}
