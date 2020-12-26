package com.shevchenko.Controller.services;

import com.shevchenko.Model.dao.RegionDao;
import com.shevchenko.Model.entity.Region;

import java.util.List;

public class RegionService {
    private RegionDao regionDao = new RegionDao();

    public RegionService() {
    }

    public Region findRegion(int id) {
        return regionDao.findById(id);
    }

    public void saveRegion(Region region) {
        regionDao.save(region);
    }

    public void deleteRegion(Region region){
        regionDao.delete(region);
    }

    public void updateRegion(Region region){
        regionDao.update(region);
    }

    public List<Region> findAllRegions(){
        return regionDao.findAll();
    }

    public Region findRegionById(int id){
        return regionDao.findRegionById(id);
    }
}
