package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@PreAuthorize("isAuthenticated()")
@RestController
public class AccountController {

    @Autowired
    AccountDao accountDao;

    @GetMapping(path = "/account/{userId}")
    public Account getAccount(@PathVariable int userId){
        return accountDao.getAccountByUserId(userId);
    }
    
}
