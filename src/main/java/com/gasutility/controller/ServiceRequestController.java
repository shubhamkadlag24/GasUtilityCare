
package com.gasutility.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gasutility.entities.ServiceRequest;
import com.gasutility.service.ServiceRequestService;



//it is controller of application 
@RestController
@RequestMapping("/api/service-requests")
public class ServiceRequestController {

	@Autowired
    private ServiceRequestService serviceRequestService;

//    @PostMapping
//    public ResponseEntity<ServiceRequest> createServiceRequest(@RequestBody ServiceRequest serviceRequest) {
//        ServiceRequest createdRequest = serviceRequestService.createServiceRequest(serviceRequest);
//        return ResponseEntity.ok(createdRequest);
//    }

    @PostMapping
    public ResponseEntity<ServiceRequest> createServiceRequest(@RequestBody ServiceRequest serviceRequest) {
        ServiceRequest createdRequest = serviceRequestService.createServiceRequest(serviceRequest);
        return ResponseEntity.ok(createdRequest);
    }



    @PutMapping("/{requestId}")
    public ResponseEntity<ServiceRequest> updateServiceRequest(@PathVariable Long requestId, @RequestBody ServiceRequest updatedRequest) {
        ServiceRequest updatedServiceRequest = serviceRequestService.updateServiceRequest(requestId, updatedRequest);
        return ResponseEntity.ok(updatedServiceRequest);
    }

    @GetMapping
    public ResponseEntity<List<ServiceRequest>> getAllServiceRequests() {
        List<ServiceRequest> serviceRequests = serviceRequestService.getAllServiceRequests();
        return ResponseEntity.ok(serviceRequests);
    }

    @DeleteMapping("/{requestId}")
    public ResponseEntity<String> deleteServiceRequest(@PathVariable Long requestId) {
        serviceRequestService.deleteServiceRequest(requestId);
        return ResponseEntity.ok("Service Request with ID: " + requestId + " deleted successfully.");
    }
    
    @GetMapping("/{requestId}")
    public ResponseEntity<ServiceRequest> getServiceRequestById(@PathVariable Long requestId) {
        ServiceRequest serviceRequest = serviceRequestService.getServiceRequestById(requestId);
        if (serviceRequest != null) {
            return ResponseEntity.ok(serviceRequest);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/{requestId}/resolve")
    public ResponseEntity<ServiceRequest> resolveServiceRequest(@PathVariable Long requestId) {
        ServiceRequest resolvedRequest = serviceRequestService.resolveServiceRequest(requestId);
        System.out.println("Resolved Service Request: " + resolvedRequest);
        return ResponseEntity.ok(resolvedRequest);
    }
    
}
