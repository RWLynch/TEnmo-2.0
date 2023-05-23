package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    User getUserById(int id);

    User findByUsername(String username);

    int findIdByUsername(String username);

    User getAllUsers(String username);

    boolean create(String username, String firstName, String lastName, String email, String phone, String password, String profilePicture);
}
