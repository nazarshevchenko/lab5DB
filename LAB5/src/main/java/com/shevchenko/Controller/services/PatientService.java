package com.shevchenko.Controller.services;

import com.shevchenko.Model.dao.DoctorDao;
import com.shevchenko.Model.dao.PatientDao;
import com.shevchenko.Model.entity.Doctor;
import com.shevchenko.Model.entity.Patient;

import java.util.List;

public class PatientService {
    private PatientDao patientDao = new PatientDao();

    public PatientService() {
    }

    public Patient findPatient(int id) {
        return patientDao.findById(id);
    }

    public List<Patient> findAllPatients(){
        return patientDao.findAll();
    }

    public void savePatient(Patient patient){
        patientDao.save(patient);
    }

    public void deletePatient(Patient patient){
        patientDao.delete(patient);
    }
    public void updatePatient(Patient patient){ patientDao.update(patient); }

}
