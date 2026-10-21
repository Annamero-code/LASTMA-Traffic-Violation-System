package com.lastma.data.repositories;

import com.lastma.data.models.Driver;
import com.lastma.data.models.Officer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OfficerRepositoryImplTest {
    private OfficerRepositoryImpl officerRepository;
    private Officer officer;

    @BeforeEach
    void setUP(){
        officerRepository = new OfficerRepositoryImpl();
        officer = new Officer();
    }

    @Test
    public void testThatWhenISaveOfficer_CountIsOne(){
        assertEquals(0L,officerRepository.count());
        officerRepository.save(officer);
        assertEquals(1L, officerRepository.count());
    }

    @Test
    public void testThatWhenTwoOfficersAreSaved_CountIsTwo() {
        assertEquals(0L, officerRepository.count());
        Officer officerOne = new Officer();
        Officer officerTwo = new Officer();
        officerRepository.save(officerOne);
        officerRepository.save(officerTwo);
        assertEquals(2L, officerRepository.count());
    }

    @Test
    public void testThatWhenIFindById_OfficerIsFind(){
        officer.setId(1);
        officerRepository.save(officer);
        assertEquals(officer,officerRepository.findById(1));
    }

    @Test
    public void testThatWhenIFindByIncorrectId_ErrorIsThrown() {
        officer.setId(1);
        officerRepository.save(officer);
        assertNull(officerRepository.findById(8));
    }

    @Test
    public void testThatWhenIDeleteOfficerWithId_OfficerIsDeleteAndCountIsZero() {
        officer.setId(1);
        officerRepository.save(officer);
        assertEquals(1L, officerRepository.count());
        officerRepository.delete(1);
        assertEquals(0L, officerRepository.count());
    }

}