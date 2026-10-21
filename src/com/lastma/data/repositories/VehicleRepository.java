package com.lastma.data.repositories;

import com.lastma.data.models.Vehicle;

public interface VehicleRepository {

    long count();

    void save(Vehicle vehicle);

    Vehicle findById(String id);
}
