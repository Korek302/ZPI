package com.zpi.server.controllers;

import com.zpi.server.dbObjects.Lecturer;
import com.zpi.server.repositories.ILecturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class LecturerController 
{
    @Autowired
    ILecturerRepository _repo;

    @GetMapping("/lecturers")
    public List<Lecturer> getAllLecturers()
    {
        return _repo.findAll();
    }

    @PostMapping("/lecturers")
    public Lecturer createLecturer(@Valid @RequestBody Lecturer lecturer)
    {
        return _repo.save(lecturer);
    }

    @GetMapping("/lecturers/{id}")
    public Lecturer getLecturerById(@PathVariable(value = "id") Integer lecturerId)
    {
        return _repo.findById(lecturerId).get();
    }

    @PutMapping("/lecturers/{id}")
    public Lecturer updateLecturer(@PathVariable(value="id") Integer lecturerId, @Valid @RequestBody Lecturer lecturerDetails)
    {
        Lecturer _lecturer = _repo.findById(lecturerId).get();

        _lecturer.setAccountID(lecturerDetails.getAccountID());
        _lecturer.setForename(lecturerDetails.getForename());
        _lecturer.setSurname(lecturerDetails.getSurname());
        _lecturer.setTitle(lecturerDetails.getTitle());

        Lecturer _updatedLecturer = _repo.save(_lecturer);
        return _updatedLecturer;
    }

    @DeleteMapping("/lecturers/{id}")
    public ResponseEntity<?> deleteLecturer(@PathVariable(value="id") Integer lecturerId)
    {
        Lecturer _lecturer = _repo.findById(lecturerId).get();
        _repo.delete(_lecturer);
        return ResponseEntity.ok().build();
    }
}
