package com.example.demo.controllers;

import com.example.demo.entity.EntityRequest;
import com.example.demo.requests_archives.RequestRepository;
import com.example.demo.requests_archives.RequestReq;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/request")
public class RequestController {

    @Autowired
    private RequestRepository repository;

    @GetMapping()
    public ResponseEntity getRequests(){
        var allRequests = repository.findAllByStatus_paymentProcessing();
        return ResponseEntity.ok(allRequests);
    }

    @PostMapping()
    public ResponseEntity setRequest(@Valid @RequestBody RequestReq req){
        EntityRequest reqs = new EntityRequest(req);
        repository.save(reqs);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateRequest(@Valid @RequestBody RequestReq req){
        Optional<EntityRequest> optionalEntityRequest = repository.findById(req.id_request());
        if(optionalEntityRequest.isPresent()){
            EntityRequest entity_obj = optionalEntityRequest.get();
            entity_obj.setStatus_payment(req.status_payment());
            return ResponseEntity.ok(entity_obj);
        }else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id_request}")
    @Transactional
    public ResponseEntity deleteRequest(@PathVariable String id_request){
        Optional<EntityRequest> optionalEntityRequest = repository.findById(id_request);
        if (optionalEntityRequest.isPresent()){
            EntityRequest entityRequest = optionalEntityRequest.get();
            entityRequest.setStatus_payment("Excluded");
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
