package oop.darkfree.servise.person.imlementations;

import oop.darkfree.dao.person.implementations.DaoPerson;
import oop.darkfree.dao.person.interfaces.IDaoPerson;
import oop.darkfree.models.person.implementation.Person;
import oop.darkfree.servise.person.interfaces.ISPerson;

import java.util.List;

/**
 * Created by Darkfree on 09.04.2017.
 */
public class SPerson implements ISPerson{
    IDaoPerson persons;

    public SPerson() {
        persons = new DaoPerson();
    }

    public SPerson(IDaoPerson persons) {

        this.persons = persons;
    }

    public IDaoPerson getPersons() {

        return persons;
    }

    public void setPersons(IDaoPerson persons) {
        this.persons = persons;
    }

    @Override
    public List<Person> getAll() {
        return persons.getAll();
    }

    @Override
    public Person getPerson(int id) {
        return persons.getPerson(id);
    }

    @Override
    public void createPerson(Person person) {
        persons.createPerson(person);
    }

    @Override
    public void updatePerson(Person person) {
        persons.updatePerson(person);
    }

    @Override
    public void deletePerson(int id) {
        persons.deletePerson(id);
    }
}
