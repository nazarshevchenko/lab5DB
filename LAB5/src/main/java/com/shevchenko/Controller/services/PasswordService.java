package com.shevchenko.Controller.services;

import com.shevchenko.Model.dao.CityDao;
import com.shevchenko.Model.dao.PasswordDao;
import com.shevchenko.Model.entity.City;
import com.shevchenko.Model.entity.Password;

import java.util.List;

public class PasswordService {
    private PasswordDao passwordDao = new PasswordDao();

    public PasswordService() {
    }

    public Password findPassword(int id) {
        return passwordDao.findById(id);
    }

    public List<Password> findAllPasswords(){
        return passwordDao.findAll();
    }

    public void savePassword(Password password){
        passwordDao.save(password);
    }

    public void deletePassword(Password password){
        passwordDao.delete(password);
    }

    public void updatePassword(Password password){
        passwordDao.update(password);
    }
}
