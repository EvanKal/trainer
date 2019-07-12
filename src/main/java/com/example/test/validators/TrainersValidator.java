/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.test.validators;

import com.example.test.entities.Trainers;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Los_e
 */
@Component
public class TrainersValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return Trainers.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Trainers trainer = (Trainers) o;
        if (!trainer.getFirstname().matches("^[a-zA-Z]*$")) {
            errors.rejectValue("firstname", "name.only.letters");
        }
        if (!trainer.getLastname().matches("^[a-zA-Z]*$")) {
            errors.rejectValue("lastname", "name.only.letters");
        }
    }

}
