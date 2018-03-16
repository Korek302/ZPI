package com.zpi.server.repositories;

import com.zpi.server.dbObjects.Invitation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInvitationRepository extends JpaRepository<Invitation, Integer>
{ }
