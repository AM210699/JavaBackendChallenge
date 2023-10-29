package com.example.javabackendchallengepostwork.persistence;

import com.example.javabackendchallengepostwork.model.Person;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

@Repository
public class AgendaMemoryDao {

    private static final SortedSet<Person> peopleSortedSet = new TreeSet<>();

    public Person savePerson(Person person) {
        peopleSortedSet.add(person);
        return person;
    }

    public Set<Person> getPeople() {
        return peopleSortedSet;
    }


}
