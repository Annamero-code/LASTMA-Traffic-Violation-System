package com.lastma.services;

import com.lastma.data.models.Officer;
import com.lastma.data.repositories.OfficerRepository;
import com.lastma.data.repositories.OfficerRepositoryImpl;
import com.lastma.dtos.requests.RegisterOfficerRequest;
import com.lastma.dtos.responses.FoundOfficerResponse;


public class OfficerServicesImpl implements OfficerServices {
    private OfficerRepository officerRepository = new OfficerRepositoryImpl();


    @Override
    public  FoundOfficerResponse register(RegisterOfficerRequest request){
        if(request.getFullNume()==null){
            throw new IllegalArgumentException("Officer name does not exist");
        }

        if(request.getEmail()==null ||!request.getEmail().contains("@") || !request.getEmail().contains(".")){
            throw new IllegalArgumentException("This officer's email does not exist");
        }

        if(request.getPassword() == null){
            throw new IllegalArgumentException("Invalid password");
        }

        Officer officer = new Officer();
        officer.setFullName(request.getFullNume());
        officer.setEmail(request.getEmail());
        officer.setPassword(request.getPassword());

        Officer savedOfficer = officerRepository.save(officer);

        FoundOfficerResponse response = new FoundOfficerResponse();
        response.setFullName(savedOfficer.getFullName());
        response.setId(savedOfficer.getId());
        response.setMessage("Officer register successfully");
        return response;
    }

    @Override
    public FoundOfficerResponse findById(int id) {
        Officer foundOfficer = officerRepository.findById(id);
        if (foundOfficer == null){
            throw new IllegalArgumentException("This officer id  does not exist");
        }

        FoundOfficerResponse response = new FoundOfficerResponse();

        response.setId(foundOfficer.getId());
        response.setFullName(foundOfficer.getFullName());
        response.setMessage("Officer retrieved successfully");
        return response;
    }

}

