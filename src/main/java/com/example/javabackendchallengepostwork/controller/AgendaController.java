package com.example.javabackendchallengepostwork.controller;

import com.example.javabackendchallengepostwork.model.Person;
import com.example.javabackendchallengepostwork.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/agenda")
public class AgendaController {


    private final AgendaService agendaService;

    @Autowired
    public AgendaController(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    @GetMapping
    public ResponseEntity<Set<Person>> getPeople(){
        return ResponseEntity.ok(agendaService.getPeople());
    }

    @PostMapping
    public ResponseEntity<Person> savePerson(@RequestBody Person person) {
        Person result = agendaService.savePerson(person);

        if (result == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(result);
    }

}

