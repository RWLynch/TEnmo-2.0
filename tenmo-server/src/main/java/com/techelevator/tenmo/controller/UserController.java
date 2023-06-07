package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@PreAuthorize("isAuthenticated()")
public class UserController {

    @Autowired
    UserDao userDao;

    @GetMapping(path = "/users")
    public List<User> getListOfAllUsers() {
        return userDao.getAllUsers();
    }

    @PatchMapping(path = "/users/update/{id}")
    public boolean updateUser(@PathVariable int id, @RequestBody User updatedUser) {
        return userDao.updateUser(id, updatedUser);
    }
}
