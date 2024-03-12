package com.gasutility.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gasutility.entities.ServiceRequest;

import java.util.List;


//repository- ServiceRequestRepository
public interface ServiceRequestRepository extends JpaRepository<ServiceRequest, Long> {
    List<ServiceRequest> findAllByUser_Id(Long userId);

}
