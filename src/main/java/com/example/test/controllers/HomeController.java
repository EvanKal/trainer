/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.test.controllers;

import com.example.test.dao.TrainersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Los_e
 */
@Controller
public class HomeController {

    @Autowired
    private TrainersDAO trainersDAO;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showHomePage(ModelMap mm
    ) {

        mm.addAttribute("trainerslist", trainersDAO.getAll());
        return "mainmenu";
    }

    @RequestMapping(value = "/mainmenuafterdelete/{success}/{deletedtrainerid}", method = RequestMethod.GET)
    public String showMainMenuAfterDelete(ModelMap mm,
            @PathVariable("success") int success,
            @PathVariable("deletedtrainerid") int deletedtrainerid
    ) {

        mm.addAttribute("trainerslist", trainersDAO.getAll());
        mm.addAttribute("success", success);
        mm.addAttribute("deletedtrainerid", deletedtrainerid);
        return "mainmenu";
    }
    
    @RequestMapping(value = "/mainmenuafterupdate/{successupdate}/{updatedtrainerid}", method = RequestMethod.GET)
    public String showMainMenu(ModelMap mm,
            @PathVariable("successupdate") int successupdate,
            @PathVariable("updatedtrainerid") int updatedtrainerid
    ) {

        mm.addAttribute("trainerslist", trainersDAO.getAll());
        mm.addAttribute("successupdate", successupdate);
        mm.addAttribute("updatedtrainerid", updatedtrainerid);
        return "mainmenu";
    }

}
