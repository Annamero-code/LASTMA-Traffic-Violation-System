package com.lastma.data.repositories;

import com.lastma.data.models.Driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DriverRepositoryImpl implements DriverRepository {
    private List<Driver> drivers = new ArrayList<>();
    private int count = 0;


    @Override
    public long count(){
        return drivers.size();
    }

    @Override
    public Driver save(Driver driver) {
        driver.setId(++count);
        drivers.add(driver);
        return driver;

    }
    @Override
    public long count(Driver driver) {
        return drivers.size();
    }

    @Override
    public Driver findById(int id) {
        for(Driver driver : drivers){
            if(driver.getId() == id){
                return driver;
            }
        }

        throw new IllegalArgumentException("Driver with id " + id + "Not found");

    }

    @Override
    public void delete(int id) {
        for(Driver driver : drivers){
            if(driver.getId() == id){
                drivers.remove(driver);
                break;
            }
        }

    }
}
