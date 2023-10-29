package com.example.javabackendchallengepostwork.service;

import com.example.javabackendchallengepostwork.model.Person;
import com.example.javabackendchallengepostwork.persistence.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class AgendaService {

    private final PhoneValidator phoneValidator;
    private final PersonRepository personRepository;

    @Autowired
    public AgendaService(PhoneValidator phoneValidator, PersonRepository personRepository) {
        this.phoneValidator = phoneValidator;
        this.personRepository = personRepository;
    }

    public Person savePerson(Person person) {

        if (!phoneValidator.isValid(person.getTelephone())){
            return null;
        }

        String telephoneNumber = phoneValidator.cleanNumber(person.getTelephone());
        person.setTelephone(telephoneNumber);


        return personRepository.save(person);
    }

    public List<Person> getPeople() {
        return personRepository.findAll(Sort.by("name"));
    }
}
