package com.lastma.data.repositories;

import com.lastma.data.models.Driver;

import com.lastma.data.repositories.DriverRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

    public class DriverRepositoryImplTest {
        private DriverRepositoryImpl driverRepository;
        private Driver driver;

        @BeforeEach
        void setUp() {
            driverRepository = new DriverRepositoryImpl();
            driver = new Driver();
        }

        @Test
        public void testThatWhenISaveDriver_CountIsOne() {
            assertEquals(0L, driverRepository.count());
            driverRepository.save(driver);
            assertEquals(1L, driverRepository.count());
        }

        @Test
        public void testThatWhenTwoDriversAreSaved_CountIsTwo() {
            assertEquals(0L, driverRepository.count());
            Driver driverOne = new Driver();
            Driver driverTwo = new Driver();
            driverRepository.save(driverOne);
            driverRepository.save(driverTwo);
            assertEquals(2L, driverRepository.count());
        }

        @Test
        public void testThatWhenIFindById_DriverIsFind() {
            driver.setId(1);
            driverRepository.save(driver);
            assertEquals(driver, driverRepository.findById(1));
        }

        @Test
        public void testThatWhenIFindByIncorrectId_ErrorIsThrown() {
            driver.setId(1);
            driverRepository.save(driver);
            assertThrows(IllegalArgumentException.class, () -> driverRepository.findById(8));
        }

        @Test
        public void testThatWhenIDeleteDriverWithId_DriverIsDeleteAndCountIsZero() {
            driver.setId(1);
            driverRepository.save(driver);
            assertEquals(1L, driverRepository.count());
            driverRepository.delete(1);
            assertEquals(0L, driverRepository.count());
        }

    }

