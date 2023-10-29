package com.example.javabackendchallengepostwork.persistence;

import com.example.javabackendchallengepostwork.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PersonRepository extends JpaRepository<Person, Long> {

}
