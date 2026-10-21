package com.lastma.data.repositories;

import com.lastma.data.models.Driver;
import com.lastma.data.models.Vehicle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleRepositoryImplTest {

    private VehicleRepositoryImpl vehicleRepository;
    private Vehicle vehicle;

    @BeforeEach
    void setUp(){
        vehicleRepository = new VehicleRepositoryImpl();
        vehicle = new Vehicle();
    }

    @Test
    public void testThatWhenISaveVehicle_CountIsOne() {
        assertEquals(0L, vehicleRepository.count());
        vehicleRepository.save(vehicle);
        assertEquals(1L, vehicleRepository.count());
    }
    @Test
    public void testThatWhenTwoVehicleAreSaved_CountIsTwo() {
        assertEquals(0L, vehicleRepository.count());
        Vehicle vehicleOne = new Vehicle();
        Vehicle vehicleTwo = new Vehicle();
        vehicleRepository.save(vehicleOne);
        vehicleRepository.save(vehicleTwo);
        assertEquals(2L, vehicleRepository.count());
    }

    @Test
    public void testThatWhenIFindById_VehicleIsFind() {
        vehicle.setId("1");
        vehicleRepository.save(vehicle);
        assertEquals(vehicle, vehicleRepository.findById("1"));
    }

    @Test
    public void testThatWhenIFindByIncorrectId_ErrorIsThrown() {
        vehicle.setId("1");
        vehicleRepository.save(vehicle);
        assertThrows(IllegalArgumentException.class, () -> vehicleRepository.findById("5"));
    }

    @Test
    public void testThatWhenIDeleteVehicleWithId_VehicleIsDeleteAndCountIsZero() {
        vehicle.setId("1");
        vehicleRepository.save(vehicle);
        assertEquals(1L, vehicleRepository.count());
        vehicleRepository.delete("1");
        assertEquals(0L, vehicleRepository.count());
    }
}