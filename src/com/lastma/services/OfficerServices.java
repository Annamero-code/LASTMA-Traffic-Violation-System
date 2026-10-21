package com.lastma.services;

import com.lastma.data.models.Officer;
import com.lastma.dtos.requests.RegisterOfficerRequest;
import com.lastma.dtos.responses.FoundOfficerResponse;

public interface OfficerServices {

    FoundOfficerResponse register(RegisterOfficerRequest request);

    FoundOfficerResponse findById(int id);

}
