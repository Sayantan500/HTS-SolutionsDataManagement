package com.helpdesk_ticketing_system.solutions_data_management.controllers;

import com.helpdesk_ticketing_system.solutions_data_management.entities.SolutionDocument;
import com.helpdesk_ticketing_system.solutions_data_management.persistence.repository.SolutionsRepository;
import com.helpdesk_ticketing_system.solutions_data_management.utilities.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/solutions")
public class ResourceControllers
{
    private final SolutionsRepository solutionsRepository;
    private final Utilities utilities;
    private final MultiValueMap<String,String> headers;

    @Autowired
    public ResourceControllers(
            SolutionsRepository solutionsRepository, Utilities utilities) {
        this.solutionsRepository = solutionsRepository;
        this.utilities = utilities;
        this.headers = new LinkedMultiValueMap<>();
        headers.put("Content-Type", List.of("application/json; charset=utf-8"));
    }

    @PostMapping
    public ResponseEntity<Object> addSolutionToDb(@RequestBody SolutionDocument solution) throws Exception {
        if(utilities.validatePostRequestBody(solution)==true){
            solution.set_id(utilities.generateId());
            solution.setPostedOn(System.currentTimeMillis());
            String insertedSolutionId = solutionsRepository.save(solution);
            String jsonMessage = String.format("{\"id\" : \"%s\"}",insertedSolutionId);
            return new ResponseEntity<>(jsonMessage,headers,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping
    public ResponseEntity<Object> getSolution(@RequestParam Map<String,String> requestParams)
    {
        if(utilities.validateGetRequestQueryParameters(requestParams)==true) {
            SolutionDocument solutionDocument;
            String fieldName = null;
            Object fieldValue = null;
            for (Map.Entry<String, String> entrySet : requestParams.entrySet())
            {
                fieldName = entrySet.getKey();
                fieldValue = entrySet.getValue();
                break;
            }
            solutionDocument = solutionsRepository.get(fieldName,fieldValue);
            if (solutionDocument == null)
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            else
                return new ResponseEntity<>(solutionDocument, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
    }
}
