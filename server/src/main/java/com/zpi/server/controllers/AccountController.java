package com.zpi.server.controllers;

import com.zpi.server.dbObjects.Account;
import com.zpi.server.repositories.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AccountController
{
    @Autowired
    IAccountRepository _repo;

    @GetMapping("/accounts")
    public List<Account> getAllAccounts()
    {
        return _repo.findAll();
    }

    @PostMapping("/accounts")
    public Account createAccount(@Valid @RequestBody Account account)
    {
        return _repo.save(account);
    }

    @GetMapping("/accounts/{id}")
    public Account getAccountById(@PathVariable(value = "id") Integer accountId)
    {
        return _repo.findById(accountId).get();
    }

    @PutMapping("/accounts/{id}")
    public Account updateAccount(@PathVariable(value="id") Integer accountId, @Valid @RequestBody Account accountDetails)
    {
        Account _account = _repo.findById(accountId).get();

        _account.setLogin(accountDetails.getLogin());
        _account.setPassword(accountDetails.getPassword());
        _account.setUserType(accountDetails.getUserType());

        Account _updatedAccount = _repo.save(_account);
        return _updatedAccount;
    }

    @DeleteMapping("/accounts/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable(value="id") Integer accountId)
    {
        Account _account = _repo.findById(accountId).get();
        _repo.delete(_account);
        return ResponseEntity.ok().build();
    }
}
