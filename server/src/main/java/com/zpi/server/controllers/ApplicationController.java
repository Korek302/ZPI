package com.zpi.server.controllers;

import com.zpi.server.dbObjects.Application;
import com.zpi.server.repositories.IApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ApplicationController 
{
    @Autowired
    IApplicationRepository _repo;

    @GetMapping("/applications")
    public List<Application> getAllApplications()
    {
        return _repo.findAll();
    }

    @PostMapping("/applications")
    public Application createApplication(@Valid @RequestBody Application application)
    {
        return _repo.save(application);
    }

    @GetMapping("/applications/{id}")
    public Application getApplicationById(@PathVariable(value = "id") Integer applicationId)
    {
        return _repo.findById(applicationId).get();
    }

    @PutMapping("/applications/{id}")
    public Application updateApplication(@PathVariable(value="id") Integer applicationId, @Valid @RequestBody Application applicationDetails)
    {
        Application _application = _repo.findById(applicationId).get();

        _application.setGroupID(applicationDetails.getGroupID());
        _application.setStudentID(applicationDetails.getStudentID());
        _application.setIsConfirmed(applicationDetails.getIsConfirmed());
        _application.setIsViewed(applicationDetails.getIsViewed());

        Application _updatedApplication = _repo.save(_application);
        return _updatedApplication;
    }

    @DeleteMapping("/applications/{id}")
    public ResponseEntity<?> deleteApplication(@PathVariable(value="id") Integer applicationId)
    {
        Application _application = _repo.findById(applicationId).get();
        _repo.delete(_application);
        return ResponseEntity.ok().build();
    }
}
