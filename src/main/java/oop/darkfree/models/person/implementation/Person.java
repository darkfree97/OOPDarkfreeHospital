package oop.darkfree.models.person.implementation;

import oop.darkfree.models.person.interfaces.IPerson;

/**
 * Created by Darkfree on 07.03.2017.
 */
public class Person implements IPerson {
    private int id;
    private String surname;
    private String name;
    private String fathername;

    public Person() {
    }

    public Person(int id, String surname, String name, String fathername) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.fathername = fathername;
    }

    @Override
    public String getInfo() {
        return surname+" "+name+" "+" "+fathername;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    @Override
    public String toString() {
        return  "ID:" + id +" "+ surname +" "+ name +" "+ fathername;
    }
}
