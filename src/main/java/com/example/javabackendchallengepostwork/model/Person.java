package com.example.javabackendchallengepostwork.model;

import java.util.Comparator;
import java.util.Objects;

public class Person implements Comparable<Person> {

    private String name;
    private String telephone;

    public Person(String name, String telephone) {
        this.name = name;
        this.telephone = telephone;
    }

    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }


    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }
}
