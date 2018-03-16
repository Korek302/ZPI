package com.zpi.server.repositories;

import com.zpi.server.dbObjects.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Integer>
{ }
