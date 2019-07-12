/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.test.controllers;

import com.example.test.dao.UserDAO;
import com.example.test.entities.Users;
import com.example.test.validators.UsersValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Los_e
 */
@Controller
@RequestMapping(value = "user")
public class UsersController {

    @Autowired
    private UserDAO usersDAO;

    @Autowired
    private UsersValidator usersValidator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
                    binder.setValidator(usersValidator);
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.GET)
    public String showHomePage(ModelMap mm) {

        mm.addAttribute("user", new Users());
        return "adduser";
    }


    @RequestMapping(value = "/doadduser", method = RequestMethod.POST)
    public String postUser(
            ModelMap mm,
//            @RequestParam("useridhidden") String useridhidden,
            @ModelAttribute("user") Users user,
            BindingResult br,
             RedirectAttributes ra
    ) {
        usersValidator.validate(user, br);
        if (br.hasErrors()) {

            return "adduser";
        } else {
            

            ra.addAttribute("userusername", user.getUsername());
            user.setRole("trainer");
            usersDAO.addUser(user);
            return "redirect:/user/addtrainer";
        }
    }

    @RequestMapping(value = "/addtrainer", method = RequestMethod.GET)
    public String getPostedUser(
            ModelMap mm,
            @RequestParam("userusername") String username,
                         RedirectAttributes ra

    ) {

        if (!mm.containsAttribute("trainer")) {

            ra.addAttribute("username", username);
            return "redirect:/trainer/showaddtrainer";

        } else {
            return "addtrainer";
        }

    }

}
