package com.example.demo.requests_archives;

import com.example.demo.entity.EntityRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface RequestRepository extends JpaRepository<EntityRequest, String> {

    @Query("SELECT r FROM requests r WHERE r.status_payment = 'Processing'")
    List<EntityRequest> findAllByStatus_paymentProcessing();
}