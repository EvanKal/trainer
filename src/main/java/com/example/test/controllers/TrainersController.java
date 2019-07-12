/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.test.controllers;

import com.example.test.dao.TrainersDAO;
import com.example.test.dao.UserDAO;
import com.example.test.dtos.UserTrainerDTO;
import com.example.test.entities.Trainers;
import com.example.test.entities.Users;
import com.example.test.repositories.TrainersRepo;
import com.example.test.validators.TrainersValidator;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Los_e
 */
@Controller
@RequestMapping(value = "trainer")

public class TrainersController {

    @Autowired
    private TrainersDAO trainersDAO;
    @Autowired
    private UserDAO usersDAO;
    @Autowired
    private TrainersRepo trainersRepo;
    @Autowired
    private TrainersValidator trainersValidator;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(trainersValidator);
    }

    @RequestMapping(value = "/showaddtrainer", method = RequestMethod.GET)
    public String showAddTrainer(ModelMap mm,
            @RequestParam("username") String username) {
        Users user = usersDAO.getUserByUsername(username);
        Trainers trainer1 = new Trainers();
        trainer1.setTrainerid(user.getUserid());
        mm.addAttribute("trainer", trainer1);
        mm.addAttribute("username", username);
        mm.addAttribute("trainerid", user.getUserid());
        return "addtrainer";
    }

    @RequestMapping(value = "/doaddtrainer", method = RequestMethod.POST)
    public String addTrainer(ModelMap mm,

            @RequestParam("traineridhidden") String traineridhidden,
            @RequestParam("usernamehidden") String username,
            @Valid @ModelAttribute("trainer") Trainers trainer,
            BindingResult br

    ) {

        if (br.hasErrors()) {
            mm.addAttribute("trainerid", traineridhidden);
            mm.addAttribute("username", username);
            trainer.setTrainerid(Integer.parseInt(traineridhidden));
            return "addtrainer";

        } else {
            trainer.setTrainerid(Integer.parseInt(traineridhidden));
            trainersDAO.addTrainer(trainer);
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/deletetrainer/{trainerid}", method = RequestMethod.GET)
    public String showHomePage(ModelMap mm,
            @PathVariable("trainerid") int trainerid) {

        int success;
        try {
            usersDAO.deleteUser(trainerid);
            trainersDAO.deleteTrainer(trainerid);
            success = 1;
        } catch (Exception e) {
            success = 0;
        }

        return "redirect:/mainmenuafterdelete/" + success + "/" + trainerid;
    }

    @RequestMapping(value = "/updatetrainer/{trainerid}", method = RequestMethod.GET)
    public String updateTrainer(ModelMap mm,
            @PathVariable("trainerid") int trainerid) {

        Trainers trainer = trainersDAO.getTrainerById(trainerid);
        mm.addAttribute("trainer", trainer);
        return "updatetrainer";
    }

    @RequestMapping(value = "/doupdatetrainer", method = RequestMethod.POST)
    public String doUpdateTrainer(ModelMap mm,
            @RequestParam("traineridhidden") String traineridhidden,
            //            @PathVariable("trainerid") int trainerid,
            @Valid @ModelAttribute("trainer") Trainers trainer,
            BindingResult br
    ) {

        if (br.hasErrors()) {
            
            mm.addAttribute("trainerid", traineridhidden);
            trainer.setTrainerid(Integer.parseInt(traineridhidden));
            return "updatetrainer";

        } else {
            int successupdate;
        try {
            trainer.setTrainerid(Integer.parseInt(traineridhidden));
            trainersDAO.addTrainer(trainer);
            successupdate = 1;
        } catch (Exception e) {
            successupdate = 0;
        }
        return "redirect:/mainmenuafterupdate/" + successupdate + "/" + traineridhidden;
        }
        
    }

}
