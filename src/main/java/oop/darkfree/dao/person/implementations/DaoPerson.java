package oop.darkfree.dao.person.implementations;

import oop.darkfree.dao.person.interfaces.IDaoPerson;
import oop.darkfree.models.person.implementation.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Darkfree on 28.03.2017.
 */
public class DaoPerson implements IDaoPerson {
    List<Person> persons = new ArrayList<>();

    public DaoPerson() {
    }

    public DaoPerson(List<Person> persons) {

        this.persons = persons;
    }

    public List<Person> getPersons() {

        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public List<Person> getAll() {
        return persons;
    }

    @Override
    public Person getPerson(int id) {
        return persons.stream().filter(p->p.getId()==id).findAny().get();
    }

    @Override
    public void createPerson(Person person) {
        persons.add(person);
    }

    @Override
    public void updatePerson(Person person) {
        persons.stream().filter(p -> person.getId()==p.getId()).forEach(p->p=person);
    }

    @Override
    public void deletePerson(int id) {
        persons.stream().filter(p->p.getId()==id).forEach(p->persons.remove(p));
    }
}
