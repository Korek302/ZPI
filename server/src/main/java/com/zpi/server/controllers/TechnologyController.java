package com.zpi.server.controllers;

import com.zpi.server.dbObjects.Technology;
import com.zpi.server.repositories.ITechnologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TechnologyController 
{
    @Autowired
    ITechnologyRepository _repo;

    @GetMapping("/technologys")
    public List<Technology> getAllTechnologys()
    {
        return _repo.findAll();
    }

    @PostMapping("/technologys")
    public Technology createTechnology(@Valid @RequestBody Technology technology)
    {
        return _repo.save(technology);
    }

    @GetMapping("/technologys/{id}")
    public Technology getTechnologyById(@PathVariable(value = "id") Integer technologyId)
    {
        return _repo.findById(technologyId).get();
    }

    @PutMapping("/technologys/{id}")
    public Technology updateTechnology(@PathVariable(value="id") Integer technologyId, @Valid @RequestBody Technology technologyDetails)
    {
        Technology _technology = _repo.findById(technologyId).get();

        _technology.setTechnologyName(technologyDetails.getTechnologyName());

        Technology _updatedTechnology = _repo.save(_technology);
        return _updatedTechnology;
    }

    @DeleteMapping("/technologys/{id}")
    public ResponseEntity<?> deleteTechnology(@PathVariable(value="id") Integer technologyId)
    {
        Technology _technology = _repo.findById(technologyId).get();
        _repo.delete(_technology);
        return ResponseEntity.ok().build();
    }
}
