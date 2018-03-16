package com.zpi.server.repositories;

import com.zpi.server.dbObjects.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGroupRepository extends JpaRepository<Group, Integer>
{ }
