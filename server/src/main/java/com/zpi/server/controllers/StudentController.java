package com.zpi.server.controllers;

import com.zpi.server.dbObjects.Student;
import com.zpi.server.repositories.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class StudentController 
{
    @Autowired
    IStudentRepository _repo;

    @GetMapping("/students")
    public List<Student> getAllStudents()
    {
        return _repo.findAll();
    }

    @PostMapping("/students")
    public Student createStudent(@Valid @RequestBody Student student)
    {
        return _repo.save(student);
    }

    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable(value = "id") Integer studentId)
    {
        return _repo.findById(studentId).get();
    }

    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable(value="id") Integer studentId, @Valid @RequestBody Student studentDetails)
    {
        Student _student = _repo.findById(studentId).get();

        _student.setAccountID(studentDetails.getAccountID());
        _student.setForename(studentDetails.getForename());
        _student.setSurname(studentDetails.getSurname());
        _student.setGroupID(studentDetails.getGroupID());
        _student.setIndex(studentDetails.getIndex());

        Student _updatedStudent = _repo.save(_student);
        return _updatedStudent;
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable(value="id") Integer studentId)
    {
        Student _student = _repo.findById(studentId).get();
        _repo.delete(_student);
        return ResponseEntity.ok().build();
    }
}
