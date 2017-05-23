package oop.darkfree.dao.person.interfaces;

import oop.darkfree.models.person.implementation.Person;

import java.util.List;

/**
 * Created by Darkfree on 28.03.2017.
 */
public interface IDaoPerson {
    List<Person> getAll();
    Person getPerson(int id);
    void createPerson(Person person);
    void updatePerson(Person person);
    void deletePerson(int id);
}
