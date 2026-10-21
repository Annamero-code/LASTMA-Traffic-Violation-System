package com.lastma.data.repositories;

import com.lastma.data.models.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleRepositoryImpl implements VehicleRepository {
    private List<Vehicle> vehicles = new ArrayList<>();


    @Override
    public long count() {
        return vehicles.size();
    }
    @Override
    public void save(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    @Override
    public Vehicle findById(String id) {
        for(Vehicle vehicle : vehicles){
            if(vehicle.getId().equals(id)){
                return vehicle;
            }
        }

        throw new IllegalArgumentException("This Vehicle Is Not Find: ");
    }


    public void delete(String id) {
        for(Vehicle vehicle : vehicles){
            if(vehicle.getId().equals(id)){
                vehicles.remove(vehicle);
                break;
            }
        }
    }
}
