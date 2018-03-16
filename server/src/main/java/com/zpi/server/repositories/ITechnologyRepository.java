package com.zpi.server.repositories;

import com.zpi.server.dbObjects.Technology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITechnologyRepository extends JpaRepository<Technology, Integer>
{ }
