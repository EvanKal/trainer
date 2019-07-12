/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.test.dao;

import com.example.test.entities.Users;
import com.example.test.repositories.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Los_e
 */
@Service
public class UserDAO {

    @Autowired
    private UsersRepo usersRepo;

    public void addUser(Users user) {
        usersRepo.save(user);
    }
    
    public boolean checkIfUserByUsernameExists(String username) {
       return usersRepo.existsUsersByUsername(username);
    }

    public Users getUserByUsername(String username) {
        return usersRepo.findUserByUsername(username);
    }

    public void deleteUser(int userid) {
        usersRepo.deleteUserById(userid);
    }

}
