package com.zpi.server.repositories;

import com.zpi.server.dbObjects.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IApplicationRepository extends JpaRepository<Application, Integer>
{ }
