package com.gasutility.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gasutility.entities.ServiceRequest;
import com.gasutility.repo.ServiceRequestRepository;
import com.gasutility.repo.UserRepository;
import com.gasutility.service.ServiceRequestService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public  class ServiceRequestServiceImpl implements ServiceRequestService {


    @Autowired
    private ServiceRequestRepository serviceRequestRepository;

    @Autowired
    private UserRepository userRepository;



    @Override
    public ServiceRequest createServiceRequest(ServiceRequest serviceRequest) {
        serviceRequest.setCreatedAt(new Date()); 
        return serviceRequestRepository.save(serviceRequest);
    }

    
    @Override
    public List<ServiceRequest> getServiceRequestsByUserId(Long userId) {
        return serviceRequestRepository.findAllByUser_Id(userId);
    }

    @Override
    public ServiceRequest updateServiceRequest(Long requestId, ServiceRequest updatedRequest) {
        Optional<ServiceRequest> optionalRequest = serviceRequestRepository.findById(requestId);
        if (optionalRequest.isPresent()) {
            updatedRequest.setId(requestId);
            return serviceRequestRepository.save(updatedRequest);
        } else {
            throw new RuntimeException("Service Request not found with id: " + requestId);
        }
    }

    @Override
    public List<ServiceRequest> getAllServiceRequests() {
        return serviceRequestRepository.findAll();
    }

    @Override
    public void deleteServiceRequest(Long requestId) {
        Optional<ServiceRequest> optionalRequest = serviceRequestRepository.findById(requestId);
        if (optionalRequest.isPresent()) {
            serviceRequestRepository.deleteById(requestId);
        } else {
            throw new RuntimeException("Service Request not found with id: " + requestId);
        }
    }
    
    @Override
    public ServiceRequest getServiceRequestById(Long requestId) {
        Optional<ServiceRequest> serviceRequestOptional = serviceRequestRepository.findById(requestId);
        return serviceRequestOptional.orElse(null);
    }
    
    @Override
    public ServiceRequest resolveServiceRequest(Long requestId) {
        ServiceRequest serviceRequest = serviceRequestRepository.findById(requestId).orElse(null);
        if (serviceRequest != null) {
            if (serviceRequest.getStatus().equalsIgnoreCase("pending")) {
                serviceRequest.setStatus("success");
                serviceRequest.setResolvedAt(new Date());
                return serviceRequestRepository.save(serviceRequest);
            } else {
               
                throw new IllegalArgumentException("Service request with ID " + requestId + " is not pending.");
            }
        }
        return null;
    }



	}
