package com.example.javabackendchallengepostwork.service;

import com.example.javabackendchallengepostwork.model.Person;
import com.example.javabackendchallengepostwork.persistence.AgendaMemoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AgendaService {

    private final PhoneValidator phoneValidator;
    private final AgendaMemoryDao agendaMemoryDao;

    @Autowired
    public AgendaService(PhoneValidator phoneValidator, AgendaMemoryDao agendaMemoryDao) {
        this.phoneValidator = phoneValidator;
        this.agendaMemoryDao = agendaMemoryDao;
    }

    public Person savePerson(Person person) {

        if (!phoneValidator.isValid(person.getTelephone())){
            return null;
        }

        String telephoneNumber = phoneValidator.cleanNumber(person.getTelephone());
        person.setTelephone(telephoneNumber);


        return agendaMemoryDao.savePerson(person);
    }

    public Set<Person> getPeople() {

        return agendaMemoryDao.getPeople();
    }
}
