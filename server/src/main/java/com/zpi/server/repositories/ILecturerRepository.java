package com.zpi.server.repositories;

import com.zpi.server.dbObjects.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILecturerRepository extends JpaRepository<Lecturer, Integer>
{ }
