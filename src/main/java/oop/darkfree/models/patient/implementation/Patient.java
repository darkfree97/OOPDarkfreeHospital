package oop.darkfree.models.patient.implementation;


import oop.darkfree.models.patient.interfaces.IPatient;
import oop.darkfree.models.person.interfaces.IPerson;

/**
 * Created by Darkfree on 07.03.2017.
 */
public class Patient implements IPatient {
    private IPerson person;
    private Integer year;

    public Patient() {
    }

    public Patient(IPerson person, Integer year) {
        this.person = person;
        this.year = year;
    }

    public IPerson getPerson() {
        return person;
    }

    public void setPerson(IPerson person) {
        this.person = person;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return  person +
                ", year=" + year ;
    }
}
