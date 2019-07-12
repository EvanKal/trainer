/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.test.validators;

import com.example.test.dao.UserDAO;
import com.example.test.entities.Trainers;
import com.example.test.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Los_e
 */
@Component
public class UsersValidator implements Validator {
    
    @Autowired
    private UserDAO userDAO;

    @Override
    public boolean supports(Class<?> type) {
        return Users.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Users user = (Users) o;
        boolean check = userDAO.checkIfUserByUsernameExists(user.getUsername());
        if (check) {
            errors.rejectValue("username", "username.unique");
        }
    }

}
