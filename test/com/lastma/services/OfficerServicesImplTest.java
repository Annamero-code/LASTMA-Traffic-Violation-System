package com.lastma.services;

import com.lastma.data.models.Officer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OfficerServicesImplTest {
    private OfficerServicesImpl officerServices;
    private Officer officer;

    @BeforeEach
    void setUp(){
        officerServices = new OfficerServicesImpl();
        officer = new Officer();
    }

    @Test
    public void testThatICanFindARegisteredOfficer_ById(){

    }

}