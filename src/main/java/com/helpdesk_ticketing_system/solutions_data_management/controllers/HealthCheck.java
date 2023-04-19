package com.helpdesk_ticketing_system.solutions_data_management.controllers;

import com.helpdesk_ticketing_system.solutions_data_management.persistence.repository.SolutionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthCheck {
    private final SolutionsRepository solutionsRepository;

    @Autowired
    public HealthCheck(SolutionsRepository solutionsRepository) {
        this.solutionsRepository = solutionsRepository;
    }

    @GetMapping
    public ResponseEntity<Object> getHealth(){
        solutionsRepository.get("_id","TestDoc");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
