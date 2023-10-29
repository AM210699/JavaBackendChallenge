package com.example.javabackendchallengepostwork.persistence;

import com.example.javabackendchallengepostwork.model.Person;
import com.example.javabackendchallengepostwork.service.PhoneFormatter;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

@Repository
public class AgendaMemoryDao {

    private static final SortedSet<Person> peopleSortedSet = new TreeSet<>();

    private final PhoneFormatter  phoneFormatter;


    public AgendaMemoryDao(PhoneFormatter phoneFormatter) {
        this.phoneFormatter = phoneFormatter;
    }


    public Person savePerson(Person person) {
        person.setTelephone(phoneFormatter.format(person.getTelephone()));
        peopleSortedSet.add(person);
        return person;
    }

    public Set<Person> getPeople() {
        return peopleSortedSet;
    }

}
