package com.zpi.server.repositories;

import com.zpi.server.dbObjects.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer>
{ }
