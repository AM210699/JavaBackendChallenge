package com.example.javabackendchallengepostwork.controller;

import com.example.javabackendchallengepostwork.model.Person;
import com.example.javabackendchallengepostwork.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class AgendaController {

    private final AgendaService agendaService;


    @Autowired
    public AgendaController(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    @GetMapping({"/", "/index"})
    public String registerForm(Model model) {
        model.addAttribute("person", new Person());
        model.addAttribute("listPeople", agendaService.getPeople());

        return "index";
    }

    @PostMapping("/register")
    public ModelAndView register(@Valid Person person) {

        agendaService.savePerson(person);

        ModelAndView mav = new ModelAndView("index");
        mav.addObject("listPeople", agendaService.getPeople());
        return mav;
    }

}