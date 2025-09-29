package com.example.demo.controller;


import com.example.demo.dao.*;
import com.example.demo.model.*;
import lombok.extern.slf4j.*;
import org.slf4j.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import java.util.logging.*;
import java.util.logging.Logger;


import org.slf4j.LoggerFactory;

@Slf4j
@Controller
@RequestMapping("/people")

public class PeopleController {

    private final PeopleDAO peopleDAO;

    public PeopleController(PeopleDAO peopleDAO) {
        this.peopleDAO = peopleDAO;
    }




    @GetMapping
    public String people(Model model) {
        model.addAttribute("people", peopleDAO.getPeople());
        return "people/people";
    }

    @GetMapping("/show")
    public String show(@RequestParam("id") int id, Model model) {
        model.addAttribute("person", peopleDAO.look(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String newPerson(Model model) {
        model.addAttribute("person", new User());
        return "people/new";
    }


    @PostMapping()
    public String create(@ModelAttribute("person") User user) {
            peopleDAO.save(user);
            return "redirect:/people";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") int id, Model model) {
        model.addAttribute("person", peopleDAO.look(id));
        return "people/edit";
    }
    @PostMapping("/update")
    public String update(@ModelAttribute User user,
                         @RequestParam("id") int id) {
        peopleDAO.update(id, user);
        return "redirect:/people";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") int id) {

        peopleDAO.delete(id);
        return "redirect:/people";
    }
}
